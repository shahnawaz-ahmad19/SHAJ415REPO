package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	//get Print writter
    	PrintWriter pw=res.getWriter();
    	//set contet type
    	res.setContentType("text/html");
    	//read special request param value(s1)
    	String s1val=req.getParameter("s1");
    	//read form data (text box value)
    	int val1=0; int val2=0;
    	if(!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {// read text box value only when request is not coming from hyperlinks
    		val1=Integer.parseInt(req.getParameter("t1"));
    		val2=Integer.parseInt(req.getParameter("t2"));	
    	}
    	//diffrentiate logics for submit button and hyperlinks
    	if(s1val.equalsIgnoreCase("add")) 
    		pw.println("<h1>Sum of "+val1+" and "+val2+" is ::"+(val1+val2)+"</h1>");
    	else if(s1val.equalsIgnoreCase("sub"))
    		pw.println("<h1>Sub of "+val1+" and "+val2+" is ::"+(val1-val2)+"</h1>");
    	else if(s1val.equalsIgnoreCase("mul"))
    		pw.println("<h1>Mul of "+val1+" and "+val2+" is ::"+(val1*val2)+"</h1>");
    	else if(s1val.equalsIgnoreCase("div"))
    		pw.println("<h1>Div of "+val1+" and "+val2+" is ::"+((float)val1/val2)+"</h1>");
    	else if(s1val.equalsIgnoreCase("link1")) {
    		pw.println("<h1>System properties are</h1>");
    	    pw.println("<b>"+System.getProperties()+"</b>");   
       } 
    	else {
    		pw.println("<h1> system date and time ::"+LocalDateTime.now()+"</h1>");
    	}
    	//Add home hyperlink
    	pw.println("<br><a href='form.html'>HOME</a>");
    	
    	//close stream
    	pw.close();
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req, res);
    }
}
