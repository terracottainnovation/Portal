package com.nath.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.ModelAndView;

import com.nath.common.MappingURL;
import com.nath.common.View;
import com.nath.util.ProperyReader;
/**
 * 
 * @author Tejas Mahajan
 *
 */
@Controller
public class WelcomeController {
	static Logger LOGGER  = Logger.getLogger(WelcomeController.class);
	
	@RequestMapping(value=MappingURL.WELCOME_PAGE_URL, method=RequestMethod.GET)
	public ModelAndView welComePageController(HttpServletRequest request, 
											  HttpServletResponse response){
		LOGGER.info("Started WelcomePageController.java - WelcomePageController()");
		ModelAndView  modelAndView = new ModelAndView(View.WELCOME_VIEW);
		modelAndView.addObject("defaultLanguage", ProperyReader.getProperty("defaultLanguage"));
		return modelAndView; 
	}
}
