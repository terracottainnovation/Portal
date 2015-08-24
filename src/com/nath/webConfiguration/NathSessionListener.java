package com.nath.webConfiguration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class NathSessionListener implements HttpSessionListener {
	
	static Logger LOGGER  = Logger.getLogger(NathSessionListener.class);	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		LOGGER.info("New Session created - NathSessionListener -sessionCreated()");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

}
