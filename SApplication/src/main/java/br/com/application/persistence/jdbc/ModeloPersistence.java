package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Modelo;
import br.com.application.persistence.util.JDBConnectionUtil;

public class ModeloPersistence {
	
	private static final String UPDATE = "UPDATE APPLICATION.MODELOS SET modelo = ?, lancamento = ?, fornecedor_id = ?";
	private static final String INSERT = "INSERT INTO APPLICATION.MODELOS() VALUES(?,?,?)";
	private static final String SELECT = "SELECT * FROM APPLICATION.MODELOS";
	private static final String DELETE = "DELETE * FROM APPLICATION.MODELOS";
	private static final String WHERE_BY_FK = " WHERE fornecedor_id = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
	
	List<Modelo> modelos;
	Modelo modelo;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public ModeloPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}
	
	public void save(Modelo modelo) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, modelo.getModelo());
			
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public void update(Modelo modelo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);

			preparedStatement.setLong(4, modelo.getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}
	
	@SuppressWarnings({ "finally" })
	public List<Modelo> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			modelos = new ArrayList<>();
			while (resultSet.next()) {
				modelo = new Modelo();
				//modelo.setId(resultSet.getLong("codigo"));
				modelos.add(modelo);
			}
		} catch (SQLException SQLexception) {
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return modelos;
		}
	}
	
	public Modelo findById(long codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				modelo = new Modelo();
				//modelo.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return modelo;
		}
	}
	
	public void delete(Long codigo) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(DELETE + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

}
