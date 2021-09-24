package com.cofigLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Credentials {
	
	public static String getConfig(String key) throws Exception {
		
		Properties pr = new Properties();
		
		String path = "./config.Properties";
		FileInputStream fis = new FileInputStream(path);
		
		pr.load(fis);
		
		return pr.get(key).toString();
	}
	
	public static void main(String[] args) throws Exception {
		
	}

}
