package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineElgibilityServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VaccineElgibilityServlet.doPost(-,-)"); 
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data (req parameter values)
		String name=req.getParameter("pname");
		String address=req.getParameter("paddrs");
		int age=Integer.parseInt(req.getParameter("page"));
		//write b.logic(request processing logic)
		if(age<18)
			pw.println("<h1 style='color:red;text-align:center'>Mr/Miss  "+name+"  You are not eligible for Corona Vaccination </h1>");
		
		else
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss  "+name+"  You are eligible for Corona Vaccination, Make it happen </h1>");
			
		 //add home hyperlink (graphical hyperlink ) 	
		pw.println("<a href='corona_vaccine.html'><img src='images/home.jfif' style='width:100px;'></a>");
		
		//close stream
		pw.close();
		
		
	}//doPost(-,-)
		        
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("VaccineElgibilityServlet.doGet(-,-)"); 
		//get print writter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get system date and time
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour<12)
			pw.println("<h1 style='color:orange;text-align:center'> Good Morning</h1>");
		else if(hour<16)
			pw.println("<h1 style='color:cyan;text-align:center'> Good Afternoon</h1>");
		else if(hour<20)
			pw.println("<h1 style='color:pink;text-align:center'> Good Evening</h1>");
		else
			pw.println("<h1 style='color:green;text-align:center'> Good Night</h1>");
		
		
		//close stream
		pw.close();
	}//doGet(-,-)
		
        
}//class
