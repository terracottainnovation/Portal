package com.nath.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nath.common.MappingURL;
import com.nath.common.View;
import com.nath.service.ILoginService;

@Controller
public class LoginController {
	static Logger LOGGER  = Logger.getLogger(LoginController.class);
	
	@Autowired 
	@Qualifier("loginService")
	ILoginService loginService;

	@RequestMapping(value=MappingURL.LOGIN_PAGE_URL, method=RequestMethod.GET)
	public ModelAndView initializeLoginPage(HttpServletRequest request, 
								HttpServletResponse response){
		LOGGER.info("Initializing Login page.");
  		ModelAndView modelAndView = new ModelAndView(View.LOGIN_VIEW);
		return modelAndView;
	}

	@RequestMapping(value=MappingURL.LOGIN_PAGE_URL, method=RequestMethod.POST, params=ActionKey.ACTIONKEY_DOLOGIN)
	public ModelAndView doLogin(HttpServletRequest request, 
								HttpServletResponse response){
		LOGGER.info("Logging for user"+ request.getParameter("userName"));
		request.getParameter("userName");
		
		ModelAndView modelAndView = new ModelAndView(View.WELCOME_VIEW);
		return modelAndView;
	}

	
}
