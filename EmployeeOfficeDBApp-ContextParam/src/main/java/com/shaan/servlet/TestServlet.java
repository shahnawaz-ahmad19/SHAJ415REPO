package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwritter
		PrintWriter pw=res.getWriter();
		//get access to ServletContext object
		ServletContext sc=getServletContext();
		pw.println("<br><b> server info:: "+sc.getServerInfo()+"</b>");
		pw.println("<br><b> Servlet api version ::"+sc.getMajorVersion()+"."+sc.getMinorVersion()+"</b>");
		pw.println("<br><b> MIME type of search.html file ::"+sc.getMimeType("/search.html")+"</b>");
		pw.println("<br><b> path  of web application:: "+sc.getRealPath("/")+"</b>");
		pw.println("<br><b> path of search html :: "+sc.getRealPath("/search.html")+"</b>");
		pw.println("<br><b> name of the web application:: "+sc.getContextPath()+"</b>");
		pw.println("<br><b> Virtual host name :: "+sc.getVirtualServerName()+"</b>");
		
		System.out.println("TestServlet's ServletContext obj hashCode::"+ sc.hashCode());
	    
		//read init parameter
		pw.println("<br><b> dbuser init param values ::"+sc.getInitParameter("dbuser")+"</b>");
		pw.println("<br><b> Servlet config object object class name ::"+sc.getClass()+"</b>");
		

		//close stream
		pw.close();  
	}

}
