package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.application.domain.Departamento;
import br.com.application.persistence.util.JDBConnectionUtil;

public class DepartamentoPersistence {
    
	private static final String UPDATE = "UPDATE APPLICATION.DEPARTAMENTOS SET departamento = ?, hierarquia = ?, sigla = ?, localidade = ?";
	private static final String INSERT = "INSERT INTO APPLICATION.DEPARTAMENTOS(departamento, hierarquia, sigla, localidade) VALUES(?,?,?,?)";
	private static final String SELECT = "SELECT * FROM APPLICATION.DEPARTAMENTOS";
	private static final String DELETE = "DELETE FROM APPLICATION.DEPARTAMENTOS";
	
	private static final String WHERE_BY_PK = " WHERE codigo = ?";

	List<Departamento> departamentos;
	Departamento departamento;

	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public DepartamentoPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}

	public void save(Departamento departamento) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, departamento.getDepartamento());
			preparedStatement.setString(2, departamento.getHierarquia());
			preparedStatement.setString(3, departamento.getSigla());
			preparedStatement.setString(4, departamento.getLocalidade());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public void update(Departamento departamento) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setString(1, departamento.getDepartamento());
			preparedStatement.setString(2, departamento.getHierarquia());
			preparedStatement.setString(3, departamento.getSigla());
			preparedStatement.setString(4, departamento.getLocalidade());
			preparedStatement.setLong(5, departamento.getId());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public List<Departamento> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			departamentos = new ArrayList<Departamento>();
			while (resultSet.next()) {
				departamento = new Departamento();
				departamento.setDepartamento(resultSet.getString("departamento"));
				departamento.setHierarquia(resultSet.getString("hierarquia"));
				departamento.setLocalidade(resultSet.getString("localidade"));
				departamento.setSigla(resultSet.getString("sigla"));
				//departamento.setId(resultSet.getLong("codigo"));
				departamentos.add(departamento);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return departamentos;
		}
	}

	public Departamento findById(Long codigo) throws Exception{
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				departamento = new Departamento();
				departamento.setDepartamento(resultSet.getString("departamento"));
				departamento.setHierarquia(resultSet.getString("hierarquia"));
				departamento.setLocalidade(resultSet.getString("localidade"));
				departamento.setSigla(resultSet.getString("sigla"));
				//departamento.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
			return departamento;
		}
	}
	
	@SuppressWarnings("finally")
	public Departamento findBy(String codigo) throws Exception{
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setString(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				departamento = new Departamento();
				departamento.setDepartamento(resultSet.getString("departamento"));
				departamento.setHierarquia(resultSet.getString("hierarquia"));
				departamento.setLocalidade(resultSet.getString("localidade"));
				departamento.setSigla(resultSet.getString("sigla"));
				//departamento.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
			return departamento;
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
