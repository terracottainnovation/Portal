package com.nath.webConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import con.nath.daoImpl.UserDaoImpl;

@Configuration
@ComponentScan("com.nath")
@EnableWebMvc
public class DAOConfiguration {

	@Bean(name = "userDao")
	public UserDaoImpl userDao(){
		return new UserDaoImpl();
	}
}
