package com.app.bloodnetwork.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.app.loader.PropertyFileLoader;

public class PropertyLoaderListener implements ServletContextListener {

	private static final Logger log = Logger.getLogger(PropertyLoaderListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("Property file is being loaded");
		PropertyFileLoader.loadProperties("bloodnetwork.properties");
		log.info("Loading of proprty file is done");
	}

	
}
