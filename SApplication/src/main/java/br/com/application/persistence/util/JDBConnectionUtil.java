package br.com.application.persistence.util;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class JDBConnectionUtil {

	//private static final String ORACLECONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	//private static final String ORACLEDRIVER = "oracle.jdbc.driver.OracleDriver";

	private static final String serverTimeZone = "?serverTimezone=UTC";
	private static final String useSSL = "&useSSL=false";

	// private static final String CONEXAO = "jdbc:postgresql://127.0.0.1:5433/";
	//private static final String POSTGRECONNECTION = "jdbc:postgresql://127.0.0.1:5432/";
	//private static final String POSTGREDRIVER = "com.mysql.jdbc.Driver";

	private static final String MYSQLCONNECTION = "jdbc:mysql://127.0.0.1:3306/";
	//private static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";

	//private static final String MARIACONNECTION = "jdbc:mariadb://24046-4612.sucom.gna.saneago:3306/";
	//private static final String MARIACONNECTION2 = "jdbc:mariadb://localhost:3306/";
	//private static final String MARIADRIVER = "org.mariadb.jdbc.Driver";

	//private static final String SERVER = "?useTimezone=true&amp;serverTimezone=UTC";
	private static final String DATABASE = "application" + /*SERVER +*/ serverTimeZone + useSSL;
	//private static final String USUARIO = "jhullyannoorammos";
	private static final String PASSWORD = "$Pr!ngf!3ld";
	private static final String ROOT = "root";

	private Properties properties;

	public JDBConnectionUtil() {

	}

	public static Connection getConectionfactory() throws Exception {
		// Class.forName(MYSQLDRIVER);
		Connection connection = DriverManager.getConnection(MYSQLCONNECTION + DATABASE, ROOT, PASSWORD);
		connection.setAutoCommit(Boolean.FALSE);
		return connection;

	}

	public void setProperties(HashMap conn) {
		try {
			properties = new Properties();
			properties.setProperty("jdbc.database", conn.get("database").toString());
			properties.setProperty("jdbc.password", conn.get("password").toString());
			properties.setProperty("jdbc.user", conn.get("user").toString());
			properties.setProperty("jdbc.url", conn.get("url").toString());
			try {
				FileOutputStream file = new FileOutputStream("");
				properties.storeToXML(file, "FILE JDBC PROPERTIES", "ISO-8859-1");
				file.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {

		}
	}

	/*
	 * public void getProperties() throws InvalidPropertiesFormatException,
	 * IOException {
	 * 
	 * properties = new Properties(); try { FileInputStream file = new
	 * FileInputStream(""); properties.loadFromXML(file);
	 * JDBConnectionUtil.setConectionfactory(properties);
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } }
	 * 
	 * public static Connection getConectionfactory3() throws
	 * ClassNotFoundException, SQLException { try {
	 * Class.forName(ConnectionDBEnum.POSTGREDRIVER.toString()); Connection
	 * connection = DriverManager.getConnection(
	 * ConnectionDBEnum.POSTGRECONNECTION.toString() +
	 * ConnectionDBEnum.DATABASE.toString(), ConnectionDBEnum.USER.toString(),
	 * ConnectionDBEnum.PASSWORD.toString()); return connection; } catch
	 * (SQLException i) { throw new
	 * SQLException("Falha na conexao com o banco de dados " + i.getMessage()); } }
	 * 
	 * 
	 * public static Connection getConectionfactory2() throws
	 * ClassNotFoundException, SQLException { try {
	 * Class.forName(ConnectionDBEnum.MARIADRIVER.toString()); Connection connection
	 * = DriverManager.getConnection( ConnectionDBEnum.MARIACONNECTION.toString() +
	 * ConnectionDBEnum.DATABASE.toString(), ConnectionDBEnum.USER.toString(),
	 * ConnectionDBEnum.PASSWORD.toString()); return connection; } catch
	 * (SQLException i) { throw new
	 * SQLException("Falha na conexao com o banco de dados " + i.getMessage()); } }
	 * 
	 * public static Connection setConectionfactory(Properties properties) throws
	 * ClassNotFoundException, SQLException { try {
	 * Class.forName(properties.getProperty("").toString()); Connection connection =
	 * DriverManager.getConnection( properties.getProperty("jdbc.url").toString() +
	 * properties.getProperty("jdbc.database").toString(),
	 * properties.getProperty("jdbc.user").toString(),
	 * properties.getProperty("jdbc.password").toString()); return connection; }
	 * catch (SQLException i) { throw new
	 * SQLException("Falha na conexao com o banco de dados" + i.getMessage()); } }
	 */
	public static void commit(Connection connection) throws SQLException {
		if (connection != null) {
			connection.commit();
		}
	}

	public static void rollback(Connection connection) throws SQLException {
		if (connection != null) {
			connection.rollback();
		}
	}

	public static void close(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public static void close(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		if (connection != null) {
			connection.close();
			preparedStatement.close();
		}
	}

	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
			throws SQLException {
		if (connection != null) {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
