package com.stackroute.activitystream.ActivityStreamRest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.stackroute.activitystream.ActivityStreamBackend.config.DBConfig;

public class WebInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {DBConfig.class,WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return null;
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}

}
