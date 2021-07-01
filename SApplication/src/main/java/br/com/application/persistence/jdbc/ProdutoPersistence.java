package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Produto;
import br.com.application.persistence.util.JDBConnectionUtil;

public class ProdutoPersistence {
	
	private static final String INSERT = "INSERT INTO APPLICATION.PRODUTOS(valor, produto, modelo_id) VALUES(?,?,?)";
	private static final String DELETE = "DELETE * FROM APPLICATION.PRODUTOS";
	private static final String UPDATE = "UPDATE APPLICATION.PRODUTOS SET produto = ? valor = ?";
	private static final String SELECT = "SELECT * APPLICATION.PRODUTOS";
	private static final String WHERE_BY_FK = " WHERE modelo_id = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
	
	private List<Produto> produtos;
	private Produto produto;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public ProdutoPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}
	
	public void save(Produto produto) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setDouble(1, produto.getValor());
			preparedStatement.setString(2, produto.getProduto());
			preparedStatement.setLong(3, produto.getModelo().getId());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public void update(Produto produto) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setDouble(1, produto.getValor());
			preparedStatement.setString(2, produto.getProduto());
			preparedStatement.setLong(3, produto.getModelo().getId());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public List<Produto> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			produtos = new ArrayList<Produto>();
			while (resultSet.next()) {
				produto = new Produto();
				//produto.getModelo().setId(resultSet.getLong("modelo_id"));
				produto.setProduto(resultSet.getString("produto"));
				produto.setValor(resultSet.getDouble("valor"));
				//produto.setId(resultSet.getLong("codigo"));
				produtos.add(produto);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return produtos;
		}
	}
	
	public Produto findById(long codigo) throws Exception{
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				produto = new Produto();
				//produto.getModelo().setId(resultSet.getLong("modelo_id"));
				produto.setProduto(resultSet.getString("produto"));
				produto.setValor(resultSet.getDouble("valor"));
				//produto.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
			return produto;
		}
	}
	
	
	
	public void delete(Long codigo) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(DELETE + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
}
