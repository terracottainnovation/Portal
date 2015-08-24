package com.nath.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class is to read the properties configuration related to this Application
 * 
 * This  class first look for default property file which is configured 
 * at com.nath.property package  named PortalConfiguration.properties
 * 
 * @author Tejas Mahajan
 *
 */
public class ProperyReader {
	
	static Logger logger = Logger.getLogger(ProperyReader.class);
	/**
	 * This Flag will be set false if external property file is configured.
	 * if this flag sets to be false then AutoDb will load properties from default location.
	 */
	private  boolean defaultPropertyFile = Boolean.TRUE;
	private String propertyFilePath;
	private  String PROPERTY_FILE_NAME = "/com/nath/property/PortalConfiguration.properties";
	/**
	 * This holds all properties
	 */
	static Properties  properties = new Properties();
	
	/**
	 * This method initializes all properties.
	 * This method store all properties in to Map name "property" of this same class.
	 * 
	 */


	public ProperyReader() {
		if(isDefaultPropertyFile()){
			setPropertyFileName(PROPERTY_FILE_NAME);
		}else{
			logger.debug("You might configured external property file relative file path is not properly configured");
		}
		
		try{
			InputStream in = getClass().getResourceAsStream(getPropertyFileName());
			this.properties.load(in);
		}catch(FileNotFoundException e){
			logger.error("PortalConfiguration.properties file not found");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Faild to load properties from file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPropertyFileName() {
		return propertyFilePath;
	}

	/**
	 * This method is to set default 
	 * @param propertyFileName
	 */
	public void setPropertyFileName(String propertyFileName) {
		setDefaultPropertyFile(Boolean.FALSE);
		this.propertyFilePath = propertyFileName;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isDefaultPropertyFile() {
		return defaultPropertyFile;
	}
	
	/**
	 * This sets flag whether AutoDB will use default file or externally configured file
	 * @return
	 */
	public void setDefaultPropertyFile(boolean defaultPropertyFile) {
		this.defaultPropertyFile = defaultPropertyFile;
	}
	/**
	 * This methods fetches value  from property file 
	 * returns null if key doesn't matches. 
	 * @param key
	 * @return Sting value
	 */
	public static String getProperty(String key){
		if(properties.containsKey(key)){
			return (String) properties.getProperty(key);
		}else{
			logger.error("Property"+key +"not found returning null value");
			return (String)properties.getProperty(key);
		}
		
	}
}
