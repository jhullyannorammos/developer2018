package br.com.application.enumerator;

public enum ConnectionDBEnum {
	
	root,
	USER,
	ADMINISTRADOR,
	PASSWORD,
	PASSWORD2,
	DATABASE,
	ORACLEDRIVER,
	MARIADRIVER,
	MYSQLDRIVER,
	POSTGREDRIVER,
	ORACLECONNECTION,
	MARIACONNECTION,
	MYSQLCONNECTION,
	POSTGRECONNECTION;
	
    public String getAccess() {
    	switch(this) {
    	  case DATABASE: return "application"; 
    	  case ADMINISTRADOR: return "administrador";
    	  case PASSWORD2: return "sdbs3cur!ty";
    	  case PASSWORD: return "$Pr!ngf!3ld";
    	  case root: return "root";
    	  case USER: return "jr";
    	  default : return "";
    	}
    }
	
	public String getDriver() {
	       switch(this) {
	        case ORACLEDRIVER: return "oracle.jdbc.driver.OracleDriver";
	        case MARIADRIVER: return "org.mariadb.jdbc.Driver";
	        case MYSQLDRIVER: return "com.mysql.jdbc.Driver";
	        case POSTGREDRIVER: return "com.mysql.jdbc.Driver";
	        default : return "";
	       }
	}
	
	
	public String getConnection() {
	       switch(this) {
	        case ORACLECONNECTION: return "jdbc:oracle:thin:@localhost:1521:xe";
	        case MARIACONNECTION: return "jdbc:mariadb://localhost:3306/";
	        case MYSQLCONNECTION: return "jdbc:mysql://127.0.0.1/";
	        case POSTGRECONNECTION: return "jdbc:postgresql://127.0.0.1:5433/";
	        default : return "";
	       }
	}
	
	/*
	ORACLECONNECTION("jdbc:oracle:thin:@localhost:1521:xe");
	ORACLEDRIVER("oracle.jdbc.driver.OracleDriver");
	POSTGRECONNECTION("jdbc:postgresql://127.0.0.1:5433/");
	POSTGREDRIVER("com.mysql.jdbc.Driver");
	MYSQLCONNECTION("jdbc:mysql://127.0.0.1:3306/");
	MYSQLDRIVER("com.mysql.jdbc.Driver");
	MARIACONNECTION("jdbc:mariadb://24046-4612.sucom.gna.saneago:3306/DB?user=juliano&password=juju2020");
	MARIADRIVER("org.mariadb.jdbc.Driver");
	DATABASE("application" + "?useTimezone=true&amp;serverTimezone=UTC");
	USUARIO("root");
	PASSWORD("$Pr!ngf!3ld");
    */
}
