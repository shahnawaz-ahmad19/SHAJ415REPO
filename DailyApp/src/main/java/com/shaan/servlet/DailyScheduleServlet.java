package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyScheduleServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//writing b.logic for daily schedule
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour > 5 && hour < 8)
			pw.println("<h1 style='color:green;text-align:center'>It's Workout time</h1>");
		else if (hour > 9 && hour < 11) 
			pw.println("<h1 style='color:green;text-align:center'>It's Breakfast time</h1>");
		else if (hour>12 && hour<21)
			pw.println("<h1 style='color:green;text-align:center'>It's Study time</h1>");
		else if (hour>22 && hour < 23)
			pw.println("<h1 style='color:green;text-align:center'>It's Dinner time</h1>");
		else
			pw.println("<h1 style='color:green;text-align:center'>It's Sleeping time</h1>");
		
		pw.println("<br><a href='http://localhost:2020/DailyApp/page.html'>Home</a>");
		
		//close streamn
		pw.close();
			
		

	}
	
	

}
