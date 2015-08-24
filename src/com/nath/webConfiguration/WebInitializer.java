package com.nath.webConfiguration;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nath.util.ProperyReader;

@Configuration
public class WebInitializer implements WebApplicationInitializer{
	@Autowired ProperyReader properyReader;

	
	static Logger LOGGER  = Logger.getLogger(WebInitializer.class);	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		 AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		 dispatcherContext.register(SpringConfiguration.class);
//		 container.addFilter("authenticationFilter", new AuthenticationFilter());
		 container.addFilter("loggingFilter", new LoggingFilter());
		 Dynamic dispatcherServlet = container.addServlet("portal", new DispatcherServlet(dispatcherContext));
		 dispatcherServlet.setLoadOnStartup(1);
		 dispatcherServlet.addMapping("*.do");
		 SpringConfiguration.properyReader();
	}
	
}
