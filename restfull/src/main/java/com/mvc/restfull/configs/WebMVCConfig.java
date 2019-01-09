package com.mvc.restfull.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.mvc.restfull.controller")
@Import(PersistenceConfig.class)
public class WebMVCConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/", "classpath:/props");

	}

}
