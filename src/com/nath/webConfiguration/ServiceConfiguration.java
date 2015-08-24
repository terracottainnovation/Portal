package com.nath.webConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nath.service.Impl.LoginServiceImpl;

@Configuration
@ComponentScan("com.nath")
@EnableWebMvc
public class ServiceConfiguration {

	@Bean(name = "loginService")
	public LoginServiceImpl loginService(){
		return new LoginServiceImpl();
	}
}
