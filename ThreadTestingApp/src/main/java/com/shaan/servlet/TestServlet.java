package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet  implements SingleThreadModel{
	
	public TestServlet() {
		System.out.println("TestServlet:: 0-param constructor--->"+this.hashCode());
	}

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get Printwritter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write response
		pw.println("<h1> Date and time ::"+new java.util.Date()+"</h1>");
		try {
			Thread.sleep(30000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close stream
		pw.close();
		
		
	}
	
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}
