package br.com.application.persistence.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class JDBConnection {
	
	private Properties properties;
	
	public void getProperties() throws InvalidPropertiesFormatException, IOException {
		properties = new Properties();
		try {
			
			FileInputStream file = new FileInputStream("");
			properties.loadFromXML(file);
			//JDBConnectionUtil.setConectionfactory(properties);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//this.setDatabase(properties.getProperty("jdbc.database"));
		//this.setPassword(properties.getProperty("jdbc.password"));
		//this.setUser(properties.getProperty("jdbc.user"));
		//this.setUrl(properties.getProperty("jdbc.url"));
	}
	
	public void setProperties(HashMap conn) {
		
		properties = new Properties();
		
		properties.setProperty("jdbc.database", conn.get("database").toString());
		properties.setProperty("jdbc.password", conn.get("password").toString());
		properties.setProperty("jdbc.user", conn.get("user").toString());
		properties.setProperty("jdbc.url", conn.get("url").toString());
		
		try {
			FileOutputStream file = new FileOutputStream("");
			properties.storeToXML(file, "FILE JDBC PROPERTIES", "ISO-8859-1");
			file.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
