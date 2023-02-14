package com.shaan.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class WebApplicationMonitoringListener implements ServletContextListener {
   private long start=0,end=0; 
   
	public WebApplicationMonitoringListener() {
		System.out.println("WebApplicationMonitoringListener:: 0-param constructor");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoringListener.contextInitialized()");
		start=System.currentTimeMillis();
		//get ServletContext object
		ServletContext sc=sce.getServletContext();
		sc.log("Web application is deployed/reloaded/redeployed at:"+new Date());
		System.out.println("Web application is deployed/reloaded/redeployed at:"+new Date());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoringListener.contextDestroyed()");
		end=System.currentTimeMillis();
		//get ServletContext object
		ServletContext sc=sce.getServletContext();
		sc.log("Web application is undeployed/stopped at:"+new Date());
		System.out.println("Web application is undeployed/stopped at:"+new Date());
	}
}
