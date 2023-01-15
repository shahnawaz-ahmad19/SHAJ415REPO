//HtmlServlet.java
package com.shaan.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HtmlServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
          //set content type
		  res.setContentType("text/html");
		  //get PrintWriter stream
		  PrintWriter pw=res.getWriter();
		  // enable auto refresh on the webpage
		  res.setHeader("refresh","10");
		  //write output content to browser
		  pw.println("<table border='1';align-items='center'>");
		  pw.println("<tr><th>Player name</th><th>Medal</th><th>category</th></tr>");
		  pw.println("<tr><td>Neeraj chopra</td><td>Gold</td><td>javaline throw</td></tr>");
          pw.println("<tr><td>Meera Bhai Chanu</td><td>Silver</td><td>Weight Lifting</td></tr>"); 
		  pw.println("<tr><td>Ravi kumar Dahiya</td><td>Silver</td><td>Wrestling</td></tr>");
		  pw.println("<tr><td>PV Sandhu</td><td>Bronze</td><td>Badminton</td></tr>"); 
		  pw.println("<tr><td>Lovlina</td><td>Bronze</td><td>Boxing</td></tr>");
		  pw.println("<tr><td>Hockey</td><td>Bronze</td><td>Mens Hockey</td></tr>");
		  pw.println("<tr><td>Bajrang Punia</td><td>Bronze</td><td>Wrestling</td></tr>");

		  pw.println("<br><h1 style='color:red;text-align:center'> date and time is :: "+new java.util.Date()+"</h1>");

		  pw.print("<br>req object class name::"+req.getClass());
		  pw.print("<br>res object class name::"+res.getClass());
          //close stream
		  pw.close();
	}//service(-,-)
}//class

