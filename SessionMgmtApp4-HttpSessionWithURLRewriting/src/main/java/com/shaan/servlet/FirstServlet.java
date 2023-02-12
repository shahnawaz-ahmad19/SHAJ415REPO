 package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
		
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get Print Writer
		PrintWriter pw=res.getWriter();
		//get response object
		res.setContentType("text/html");
		//read form1/request1 data
		String name=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String addrs=req.getParameter("address");
		String ms=req.getParameter("ms");
		//create/access session object for current request
		HttpSession ses=req.getSession(true);
		//keep form1/req1 data in session object as session attribute values
		 ses.setAttribute("name", name);
		 ses.setAttribute("fname", fname);
		 ses.setAttribute("addrs", addrs);
		 ses.setAttribute("ms", ms);
		//generate form2 based on marital status value
		if(ms.equalsIgnoreCase("married")) {  
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>spouse name:: </td><td><input type='text' name='f2t1'>");
			pw.println("<tr><td>No. of kids:: </td><td><input type='text' name='f2t2'>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' name='cancel'>");
			pw.println("</table>");				
			pw.println("</form>");
		}
		else {
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>Why do you want to marry:: </td><td><input type='text' name='f2t1'>");
			pw.println("<tr><td>When do you want to marry:: </td><td><input type='text' name='f2t2'>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' name='cancel'>");
			pw.println("</table>");				
			pw.println("</form>"); 
		}
		
		pw.println("<br><br><b> SesssionId :: "+ses.getId()+"</b>");
		
		//close stream
		pw.close();
			
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
