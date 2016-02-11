package com.cv.movierentals.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Configuring the DispatcherServlet. Works with Servlet spec > 3.0 (Tomcat >= 7)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?> []{ RootConfig.class }; //Holds non web related beans : Data and middle tier beans, typically
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };		//Holds Web related beans : Controllers, ViewResolvers, and the like
	}

	@Override
	protected String[] getServletMappings() {
		return new  String[] { "/", "/movies" };
	}

}
