package com.nath.util;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSONUtils {

	static Logger LOGGER = Logger.getLogger(JSONUtils.class);

	// Refliction API
	// http://www.java2blog.com/2013/11/gson-example-read-and-write-json.html     

	public String convertToJson(Object object) {
		String jsonString = ""; 
		LOGGER.debug("Converting  Java object to JSON String :-"
				+ Thread.currentThread().getStackTrace()[1].getClassName()
				+ " "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		  Gson gson = new Gson();
		  try{
			   jsonString = gson.toJson(object);
			  
		  }catch(JsonIOException ex){
			  LOGGER.info("Trying to convert Object into Json ");
			  LOGGER.error("Error While converting above  object to JSON String:-"
						+ Thread.currentThread().getStackTrace()[1]
								.getClassName()
						+ " "
						+ Thread.currentThread().getStackTrace()[1]
								.getMethodName());
		  }
		  
		return jsonString;
	}

	public Object convertToObject(String jsonString, Class type) {
		Object parObject = new Object();
		
		LOGGER.debug("Converting  Java object to JSON String :-"
				+ Thread.currentThread().getStackTrace()[1].getClassName()
				+ " "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!StringUtils.isEmpty(jsonString)) {
			try {
				JsonParser parser = new JsonParser();
				Gson gson = new Gson();
				parObject = gson.fromJson(jsonString, type);
			} catch (JsonSyntaxException ex) {
				LOGGER.info("Trying to convert Json data into Object:- " + jsonString);
				LOGGER.error("Error While converting above JSON data to object :-"
						+ Thread.currentThread().getStackTrace()[1]
								.getClassName()
						+ " "
						+ Thread.currentThread().getStackTrace()[1]
								.getMethodName());
			}
		}
		return parObject;

	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
