package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Cidade;
import br.com.application.persistence.util.JDBConnectionUtil;

public class CidadePersistence {
    
	private static final String DELETE = "DELETE * FROM APPLICATION.CIDADES";
	private static final String UPDATE = "UPDATE APPLICATION.CIDADES SET cidade = ?, capital = ?, estado_id = ?";
	private static final String INSERT = "INSERT INTO APPLICATION.CIDADES(cidade, capital, estado_id) VALUES(?,?,?)";
	private static final String SELECT = "SELECT * APPLICATION.CIDADES";
	private static final String WHERE_BY_FK = " WHERE estado_id = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";

	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	List<Cidade> cidades;
	Cidade cidade;

	public CidadePersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}

	public void save(Cidade cidade) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, cidade.getCidade());
			preparedStatement.setBoolean(2, cidade.isCapital());
			preparedStatement.setLong(3, cidade.getId());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public void update(Cidade cidade) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setString(1, cidade.getCidade());
			preparedStatement.setBoolean(2, cidade.isCapital());
			preparedStatement.setLong(4, cidade.getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	@SuppressWarnings({ "finally" })
	public List<Cidade> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			cidades = new ArrayList<>();
			while (resultSet.next()) {
				cidade = new Cidade();
				cidade.setCidade(resultSet.getString("cidade"));
				cidade.setCapital(resultSet.getBoolean("capital"));
				cidades.add(cidade);
			}
		} catch (SQLException SQLexception) {
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return cidades;
		}
	}

	public Cidade findById(long codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cidade = new Cidade();
				cidade.setCidade(resultSet.getString("cidade"));
				cidade.setCapital(resultSet.getBoolean("capital"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return cidade;
		}
	}

	public Cidade findBy(String codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_FK);
			preparedStatement.setString(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				cidade = new Cidade();
				cidade.setCidade(resultSet.getString("cidade"));
				cidade.setCapital(resultSet.getBoolean("capital"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return cidade;
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

	@SuppressWarnings("finally")
	public Cidade findAllCidadesByfederacao(long parseLong) throws SQLException {
		try {
		} catch (Exception exception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return cidade;
		}
	}
    
}
