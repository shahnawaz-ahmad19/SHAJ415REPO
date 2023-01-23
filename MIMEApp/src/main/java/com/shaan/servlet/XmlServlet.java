//HtmlServlet.java
package com.shaan.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class XmlServlet extends HttpServlet
{
	
	static {
		System.out.println("XmlServlet:: static block");
	}
	
	public XmlServlet() {
		System.out.println("XmlServlet:: 0-param constructor ");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("XmlServlet.init(ServletConfig cg)");
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        System.out.println("XmlServlet.service()");  
		//set content type
		  res.setContentType("text/xml");
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
          //close stream
		  pw.close();
	}//service(-,-)
}//class

