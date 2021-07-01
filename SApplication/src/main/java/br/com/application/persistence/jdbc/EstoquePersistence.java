package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Estoque;
import br.com.application.persistence.util.JDBConnectionUtil;

public class EstoquePersistence {
    
	private static final String SELECT = "SELECT * FROM APPLICATION.ESTOQUE";
	private static final String DELETE = "DELETE * FROM APPLICATION.ESTOQUE";
	private static final String INSERT = "INSERT INTO APPLICATION.ESTOQUE(estoque, modelo, quantidade) VALUES(?,?,?)";
	private static final String UPDATE = "UPDATE APPLICATION.ESTOQUE SET estoque = ?, modelo = ?, quantidade = ?";
	
	private static final String WHERE_BY_FK = " WHERE modelo = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";

	PreparedStatement preparedStatement;
	List<Estoque> estoques;
	Connection connection;
	ResultSet resultSet;
	Long generatedKey;
	Estoque estoque;

	public EstoquePersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}

	public void save(Estoque estoque) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, estoque.getEstoque().toString());
			preparedStatement.setString(2, estoque.getModelo());
			preparedStatement.setLong(3, estoque.getQuantidade());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public List<Estoque> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			estoques = new ArrayList<Estoque>();
			while(resultSet.next()) {
				estoque = new Estoque();
				estoque.setQuantidade(resultSet.getLong("quantidade"));
				estoque.setModelo(resultSet.getString("modelo"));
				//estoque.setId(resultSet.getLong("codigo"));
				estoques.add(estoque);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return estoques;
		}
	}

	public long persist(Estoque estoque) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, estoque.getEstoque().toString());
			preparedStatement.setString(2, estoque.getModelo());
			preparedStatement.setLong(3, estoque.getQuantidade());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			resultSet = preparedStatement.getGeneratedKeys();
			generatedKey = resultSet.getLong(1);
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return generatedKey;
		}
	}

	public void update(Estoque estoque) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setLong(1, estoque.getQuantidade());
			preparedStatement.setLong(2, estoque.getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}

	public Estoque findBy(String codigo) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(SELECT + WHERE_BY_FK);
			preparedStatement.setString(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				estoque = new Estoque();
				//estoque.setId(resultSet.getLong("codigo"));
				estoque.setModelo(resultSet.getString("modelo"));
				estoque.setQuantidade(resultSet.getLong("quantidade"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return estoque;
		}
	}

	@SuppressWarnings("finally")
	public Estoque findById(Long codigo) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				estoque = new Estoque();
				//estoque.setId(resultSet.getLong("codigo"));
				estoque.setModelo(resultSet.getString("modelo"));
				estoque.setQuantidade(resultSet.getLong("quantidade"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return estoque;
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
