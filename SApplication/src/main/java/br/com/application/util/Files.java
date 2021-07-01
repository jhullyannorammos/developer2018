package br.com.application.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class Files {
	
	public void novo(String pathDestiny, String pathSource) throws IOException {
		
	}
	
	public void copy(String pathDestiny, String pathSource) throws IOException {
    	File destiny = new File(pathDestiny);
		File source = new File(pathSource);
		FileUtils.copyDirectory(source, destiny);
	}
	
    public void move(String pathDestiny, String pathSource) throws IOException {
    	File destiny = new File(pathDestiny);
		File source = new File(pathSource);
		FileUtils.moveDirectory(source, destiny);
	}
    
    public void delete(String path) throws IOException {

	}
	
	public StringBuilder readFile(String pathFile) {
		StringBuilder data = null;
		String line = null;
		try(BufferedReader reader = new BufferedReader(new FileReader(pathFile))){
			while ((line = reader.readLine()) != null) {
				data.append(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void writeFile(String pathFile, String data) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile));
		writer.write(data);
		writer.newLine();
	}
	
	public void printFile(String pathFile, String data) throws IOException {
		PrintStream writer = new PrintStream(pathFile);
		writer.println(data);
	}
	
	public void readConfig() throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream("/config/config.properties"));
		
		String password = properties.getProperty("database.data.password");
		String user = properties.getProperty("database.data.user");
		String url = properties.getProperty("database.data.url");
	}

}
