package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHomeSerevlet extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	  //set content type
    	  res.setContentType("text/html"); 
    	  //get Printwriter
    	  PrintWriter pw=res.getWriter();
    	  //write output to response obj
    	  pw.println("<h1 style='color:red;text-align:center'>Welcome to Servlet</h1>");
    	  //close stream
    	  pw.close();
    }
}
