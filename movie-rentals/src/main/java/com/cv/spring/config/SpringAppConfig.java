package com.cv.spring.config;

import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.cv.spring")
public class SpringAppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer initConfigurator(){
		return new PropertySourcesPlaceholderConfigurer();
	}

}
