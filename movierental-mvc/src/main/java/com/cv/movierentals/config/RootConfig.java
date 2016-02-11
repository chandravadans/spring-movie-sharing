package com.cv.movierentals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"com.cv.movierentals"}, 
			   excludeFilters = { 
					   @Filter( type = FilterType.ANNOTATION, value = EnableWebMvc.class)
			   })
public class RootConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer initConfigurator(){ 
		return new PropertySourcesPlaceholderConfigurer();
	}

}
