package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Produto;
import br.com.application.domain.SoftwareLicense;
import br.com.application.enumerator.SoftwareEnum;
import br.com.application.persistence.util.JDBConnectionUtil;

public class SoftwareLicensePersistence {
	
	private static final String UPDATE = "UPDATE APPLICATION.LICENSES SET cidade = ? capital = ?";
	private static final String INSERT = "INSERT INTO APPLICATION.LICENSES(number_key, sistema, patrimonio_id) VALUES(?,?,?)";
	private static final String SELECT = "SELECT * FROM APPLICATION.LICENSES";
	private static final String DELETE = "DELETE * FROM APPLICATION.LICENSES";
	private static final String WHERE_BY_FK = " WHERE patrimonio_id = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
	
	private List<SoftwareLicense> sls;
	private SoftwareLicense sl;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public SoftwareLicensePersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}
	
	public void save(SoftwareLicense SoftwareLicense) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, SoftwareLicense.getKey());
			preparedStatement.setString(2, SoftwareLicense.getSistema().toString());
			preparedStatement.setLong(3, SoftwareLicense.getPatrimonio().getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public void update(SoftwareLicense SoftwareLicense) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setString(1, SoftwareLicense.getKey());
			preparedStatement.setString(2, SoftwareLicense.getSistema().toString());
			preparedStatement.setLong(3, SoftwareLicense.getPatrimonio().getId());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	@SuppressWarnings("finally")
	public List<SoftwareLicense> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			sls = new ArrayList<SoftwareLicense>();
			while (resultSet.next()) {
				sl = new SoftwareLicense();
				//sl.getPatrimonio().setId(resultSet.getLong("patrimonio_id"));
				sl.setSistema(SoftwareEnum.getSoftwareEnum(resultSet.getString("sistema")));
				sl.setKey(resultSet.getString("number_key"));
				//sl.setId(resultSet.getLong("codigo"));
				sls.add(sl);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return sls;
		}
	}
	
	@SuppressWarnings("finally")
	public SoftwareLicense findById(long codigo) throws Exception{
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				sl = new SoftwareLicense();
				//sl.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
			return sl;
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
