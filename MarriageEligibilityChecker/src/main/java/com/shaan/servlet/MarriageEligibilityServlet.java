package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageEligibilityServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWritter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//red from request parameter values
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
	    //write request processing logic(b.logic)
		if(gender.equalsIgnoreCase("M")) {
			if(age>=21)
			    pw.println("<h1 style='color:red;text-align:center'>Mr. " + name+"You are eligible for marriage");
			else
				pw.println("<h1 style='color:red;text-align:center'>Mr. " + name+"You are  not eligible for marriage");	
		}
		else {
			if(age>=18)
			    pw.println("<h1 style='color:red;text-align:center'>Miss. " + name+"You are eligible for marriage");
			else
				pw.println("<h1 style='color:red;text-align:center'>Miss. " + name+"You are  not eligible for marriage");
		}
	
		 //add home hyperlink (graphical hyperlink ) 	
    	pw.println("<a href='marriage.html'><h1 style='color:cyan;text-align:center'>Home</h1></a>");
    	
    	//close stream
    	pw.close();
	}

}
