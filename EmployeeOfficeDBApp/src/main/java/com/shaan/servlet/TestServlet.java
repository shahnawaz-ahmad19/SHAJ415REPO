package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwritter
		PrintWriter pw=res.getWriter();
		//get access to ServletConfig object
		ServletConfig cg=getServletConfig();
		pw.println("<b> servlet name ::"+cg.getServletName()+"</b>");
		
		System.out.println("TestServlet's ServletConfig obj::"+ cg.hashCode());
	    
		//read init parameter
		pw.println("<br><b> dbuser init param values ::"+cg.getInitParameter("dbuser")+"</b>");
		pw.println("<br><b> Servlet config object object class name ::"+cg.getClass()+"</b>");
		
		//close stream
		pw.close();  
	}

}
