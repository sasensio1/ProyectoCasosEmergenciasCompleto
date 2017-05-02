package com.casosemergencias.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext context;

	public ApplicationContext getApplicationContext() {
		return context;
	}

	@Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        context = appContext;
    }
}