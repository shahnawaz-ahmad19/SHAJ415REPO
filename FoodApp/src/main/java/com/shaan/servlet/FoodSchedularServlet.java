package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodSchedularServlet  extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWritter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write b.logic to generate food schedular message
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour<11)
			pw.println("<h1 style='color:cyan;text-align:center'>It's Breakfast Time</h1>");
		else if (hour<16)
			pw.println("<h1 style='color:green;text-align:center'>It's  Lunch Time</h1>");
		else if (hour<19)
			pw.println("<h1 style='color:violet;text-align:center'>It's Snacks Time</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>It's Dinner Time</h1>");
		
		//add home hyperlink
		pw.println("<br> <a href='http://localhost:2020/FoodApp/page.html'>Home</a>");
		
		//close stream
		pw.close();
		
	}
	
	

}
