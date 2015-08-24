package com.nath.webConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nath.util.ProperyReader;

@Configuration
@ComponentScan("com.nath")
@EnableWebMvc
public class SpringConfiguration {

	@Bean
	 public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".html");
	    return resolver;
	 }
	
	@Bean
	public static ProperyReader properyReader(){
		return  new ProperyReader();
	}
}
