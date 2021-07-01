package br.com.application.persistence.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.application.domain.Usuario;
import br.com.application.enumerator.UsuarioEnum;
import br.com.application.enumerator.UsuarioStatus;
import br.com.application.persistence.util.JDBConnectionUtil;

public class UsuarioPersistence {
	
	private static final String UPDATE = "UPDATE APPLICATION.USUARIOS SET logon = ? username = ? profile = ? status = ?";
	private static final String INSERT = "INSERT INTO APPLICATION.USUARIOS(logon, username, profile, status) VALUES(?,?,?,?)";
	private static final String SELECT = "SELECT * FROM APPLICATION.USUARIOS";
	private static final String LOGON = " WHERE logon = ? AND password = ?";
	private static final String WHERE_PK = " WHERE codigo = ?";
	
	
	List<Usuario> usuarios;
	Usuario usuario;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;
	String clausuleSQL;

	public UsuarioPersistence() throws Exception{ 
        this.connection = JDBConnectionUtil.getConectionfactory();
    }
	
	@SuppressWarnings("finally")
	public Usuario findByLogonAndPassword(String logon, String password) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + LOGON);
			preparedStatement.setString(1, logon);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				usuario = new Usuario(); 
				usuario.setPassword(resultSet.getString("password"));
				usuario.setUsername(resultSet.getString("username"));
				usuario.setPerfil(UsuarioEnum.getUsuarioEnum(resultSet.getString("profile")));
				usuario.setStatus(UsuarioStatus.getUsuarioStatus(resultSet.getString("status")));
				usuario.setEmail(resultSet.getString("logon"));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return usuario;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Usuario> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			usuarios = new ArrayList<Usuario>();
			while (resultSet.next()) {
				usuario = new Usuario(); 
				usuario.setPassword(resultSet.getString("password"));
				usuario.setUsername(resultSet.getString("username"));
				usuario.setPerfil(UsuarioEnum.getUsuarioEnum(resultSet.getString("profile")));
				usuario.setStatus(UsuarioStatus.getUsuarioStatus(resultSet.getString("status")));
				usuario.setEmail(resultSet.getString("logon"));
				usuarios.add(usuario);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return usuarios;
		}
	}

	public void save(Usuario usuario) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, usuario.getEmail());
			preparedStatement.setString(2, usuario.getUsername());
			preparedStatement.setString(3, usuario.getPerfil().toString());
			preparedStatement.setString(4, usuario.getStatus().toString());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}
	
	public void update(Usuario usuario) throws Exception {
	    try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_PK);
			preparedStatement.setString(1, usuario.getEmail());
			preparedStatement.setString(2, usuario.getUsername());
			preparedStatement.setString(3, usuario.getPerfil().toString());
			preparedStatement.setString(4, usuario.getStatus().toString());
			preparedStatement.setLong(5, usuario.getId());
			preparedStatement.execute();
	    } catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
		}
	}

}
