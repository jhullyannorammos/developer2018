package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Movimentacao;
import br.com.application.domain.Patrimonio;
import br.com.application.persistence.util.JDBConnectionUtil;

public class PatrimonioPersistence {
	
	private static final String INSERT = "INSERT INTO APPLICATION.PATRIMONIOS() VALUES(?,?,?)";
	private static final String DELETE = "DELETE APPLICATION.PATRIMONIOS";
	private static final String UPDATE = "UPDATE APPLICATION.PATRIMONIOS SET produto = ? valor = ?";
	private static final String SELECT = "SELECT * APPLICATION.PATRIMONIOS";
	private static final String WHERE_BY_FK_MERCADORIA = " WHERE MERCADORIA_id = ?";
	private static final String WHERE_BY_FK_SL = " WHERE SL = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
	
	private List<Patrimonio> patrimonios;
	private Patrimonio patrimonio;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public PatrimonioPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}
	
	public void save(Patrimonio patrimonio) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, patrimonio.getPatrimonio());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	
	public void update(Patrimonio patrimonio) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setLong(4, patrimonio.getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	@SuppressWarnings({ "finally" })
	public List<Patrimonio> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			patrimonios = new ArrayList<>();
			while (resultSet.next()) {
				patrimonio = new Patrimonio();
				//patrimonio.setId(resultSet.getLong("codigo"));
				patrimonios.add(patrimonio);
			}
		} catch (SQLException SQLexception) {
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return patrimonios;
		}
	}
	
	public Patrimonio findById(long codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				patrimonio = new Patrimonio();
				//patrimonio.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException exception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return patrimonio;
		}
	}
	
	public void delete(Long codigo) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(DELETE + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			preparedStatement.execute();
		} catch (SQLException exception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

}
