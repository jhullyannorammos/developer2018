package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Modelo;
import br.com.application.domain.Movimentacao;
import br.com.application.persistence.util.JDBConnectionUtil;

public class MovimentacaoPersistence {
	
	private static final String INSERT = "INSERT INTO APPLICATION.MOVIMENTACAO() VALUES(?,?,?)";
	private static final String UPDATE = "UPDATE APPLICATION.MOVIMENTACAO SET modelo = ?, lancamento = ?, fornecedor_id = ?";
	private static final String SELECT = "SELECT * FROM APPLICATION.MOVIMENTACAO";
	private static final String DELETE = "DELETE * FROM APPLICATION.MOVIMENTACAO";
	private static final String WHERE_BY_FK_PATRIMONIO = " WHERE patrimonio_id = ?";
	private static final String WHERE_BY_SERIAL = " WHERE serialnumber = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
	
	List<Movimentacao> movimentacaos;
	Movimentacao movimentacao;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public MovimentacaoPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}
	
	public void save(Movimentacao movimentacao) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, movimentacao.getMovimentacao().toString());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public void update(Movimentacao movimentacao) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);

			preparedStatement.setLong(4, movimentacao.getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	@SuppressWarnings({ "finally" })
	public List<Movimentacao> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			movimentacaos = new ArrayList<>();
			while (resultSet.next()) {
				movimentacao = new Movimentacao();
				//movimentacao.setId(resultSet.getLong("codigo"));
				movimentacaos.add(movimentacao);
			}
		} catch (SQLException SQLexception) {
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return movimentacaos;
		}
	}
	
	public Movimentacao findById(long codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				movimentacao = new Movimentacao();
				//movimentacao.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return movimentacao;
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
