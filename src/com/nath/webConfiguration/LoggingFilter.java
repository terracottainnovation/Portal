package com.nath.webConfiguration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.nath.common.MappingURL;

@WebFilter(MappingURL.ALL_PAGE_URL)
public class LoggingFilter implements Filter{
	
	static Logger LOGGER  = Logger.getLogger(LoggingFilter.class);
	private ServletContext context;	
    
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain chain) throws IOException, ServletException {
	    String userName = "";
		long startTime = System.currentTimeMillis();
		LOGGER.debug("Inside doFilter() of LoggingFilter");
		boolean pageRequest = false;
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		userName = request.getParameter("userName");
		LOGGER.info("Request from "+ request.getRemoteAddr()+":"+request.getRemoteHost());
		
		String  uri = httpServletRequest.getRequestURI();
		if(uri.endsWith(".htm"));
			 pageRequest = true;
	  
		chain.doFilter(request, responce);
		long endTime = System.currentTimeMillis();
		LOGGER.info("Request Processed in "+ (endTime - startTime)+" ms.");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("Initializing Logging Filter");
		this.context = filterConfig.getServletContext();
	}
}
