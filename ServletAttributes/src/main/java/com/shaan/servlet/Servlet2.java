package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//get PrintWritter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read and display request attribute values
		pw.println("<b>Servlet2:: attr1(req) value ::"+req.getAttribute("attr1")+"</b>");
		
		//read and display session attribute value
		HttpSession ses=req.getSession();
		pw.println("<br><b>Servlet2:: attr2(ses) value ::"+ses.getAttribute("attr2")+"</b>");
		
		//read and display ServletContext attributes values
		ServletContext sc=getServletContext();
		pw.println("<br><b>Servlet2:: attr3(sc) value ::"+sc.getAttribute("attr3")+"</b>");
		
		 //forward request to servlet2 component
		RequestDispatcher rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
