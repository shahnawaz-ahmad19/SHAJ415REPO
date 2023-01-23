//ExcelServlet.java
package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
          //set content type
		  res.setContentType("application/vnd.ms-excel");
		  //get PrintWriter stream
		  PrintWriter pw=res.getWriter();
		  //write output content to browser
		  pw.println("<table border='1';align='center'>");
		  pw.println("<tr><th>Player name</th><th>Medal</th><th>category</th></tr>");
		  pw.println("<tr><td>Neeraj chopra</td><td>Gold</td><td>javaline throw</td></tr>");
          pw.println("<tr><td>Meera Bhai Chanu</td><td>Silver</td><td>Weight Lifting</td></tr>"); 
		  pw.println("<tr><td>Ravi kumar Dahiya</td><td>Silver</td><td>Wrestling</td></tr>");
		  pw.println("<tr><td>PV Sandhu</td><td>Bronze</td><td>Badminton</td></tr>"); 
		  pw.println("<tr><td>Lovlina</td><td>Bronze</td><td>Boxing</td></tr>");
		  pw.println("<tr><td>Hockey</td><td>Bronze</td><td>Mens Hockey</td></tr>");
		  pw.println("<tr><td>Bajrang Punia</td><td>Bronze</td><td>Wrestling</td></tr>");
          pw.println("</table>");
		  //close stream
		  pw.close();
	}//service(-,-)
}//class

