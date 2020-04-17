package com.example.exinterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
public class DemoInterceptorRegistry extends WebMvcConfigurerAdapter{

	@Autowired
	DemoInterceptors demoInterceptors;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptors);
	}

}
