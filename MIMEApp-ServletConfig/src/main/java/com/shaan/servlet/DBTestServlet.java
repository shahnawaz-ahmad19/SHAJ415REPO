package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DBTestServlet extends HttpServlet {
	
	static {
		System.out.println("DBTestServlet:: static block");
	}
	
	public DBTestServlet() {
		System.out.println("DBTestServlet:: 0-param constructor ");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("DBTestServlet.init()");
		ServletConfig cg=getServletConfig();
		System.out.println("driver class name::"+cg.getInitParameter("driverClass"));
		System.out.println("jdbc url ::"+cg.getInitParameter("url"));
	}
	
	/*	@Override 
		public void init(ServletConfig cg) throws ServletException {
			System.out.println("DBTestServlet:: init(ServletConfig cg)");
			//read init param values from Servletconfig object
			System.out.println("driver class name::"+cg.getInitParameter("driverClass"));
			System.out.println("jdbc url ::"+cg.getInitParameter("url"));
			System.out.println("db username::"+cg.getInitParameter("dbuser"));
			System.out.println("db password::"+cg.getInitParameter("dbpwd"));
			//write JDBC code here ... using the jdbc properties available in ServletConfig object
			
		}*/
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("DBTestServlet.service(req,res)");
		//destroy();
		//get Print Writer
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write messages to response object using PrintWriter
		pw.println("<h1 style='color:red;text-align:center'>Date and Time::"+new java.util.Date()+"</h1>");
	    //close stream
		pw.close();
	}
	
	public static void main(String[] args) {
		System.out.println("DBTestServlet.main(-)");
	}
	
	@Override
	public void destroy() {
		System.out.println("DBTestServlet:: destroy()");
	}

}
