package com.cv.movierentals.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cv.movierentals.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	/*
	 * @Bean // A simple jsp resolver public ViewResolver viewResolver(){
	 * InternalResourceViewResolver resolver = new
	 * InternalResourceViewResolver(); resolver.setPrefix("/WEB-INF/views/");
	 * resolver.setSuffix(".jsp");
	 * resolver.setExposeContextBeansAsAttributes(true); return resolver; }
	 */

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {

		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		InternalResourceViewResolver r1 = new InternalResourceViewResolver();
		r1.setPrefix("/WEB-INF/pages/");
		r1.setSuffix(".jsp");
		r1.setViewClass(JstlView.class);
		resolvers.add(r1);

		JsonViewResolver r2 = new JsonViewResolver();
		resolvers.add(r2);

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		return resolver;

	}

	public class JsonViewResolver implements ViewResolver {
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			MappingJackson2JsonView view = new MappingJackson2JsonView();
			view.setPrettyPrint(true);
			return view;
		}
	}

	@Override
	// Static content handling
	// Please don't handle requests for static web pages, pass them on to the
	// default handler of the container
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
		configurer.enable();
	}
	  //super.configureDefaultServletHandling(configurer); }
}
