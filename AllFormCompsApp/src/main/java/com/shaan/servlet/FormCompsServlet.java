package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;


@WebServlet("/formurl")
public class FormCompsServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWritter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		String name=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		ms=(ms==null)?"single":ms;
		String qlfy=req.getParameter("qlfy");
		String languages[]=req.getParameterValues("languages");
		if(languages==null)
			languages=new String[] {"no languages are selected"};
		String hobbies[]=req.getParameterValues("hb");
		if(hobbies==null)
			hobbies=new String[] {"no hobbies are selected"};
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String month=req.getParameter("mob");
		String wdb=req.getParameter("wdb");
		int favNumber=Integer.parseInt(req.getParameter("favNumber"));
		long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		String mail=req.getParameter("mail");
		String favColor=req.getParameter("favColor");
		int income=Integer.parseInt(req.getParameter("income"));
		String url=req.getParameter("fburl");
		String favSS=req.getParameter("favSearch");
		//write b.logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:red;text-align:center'>Master::"+name+" you are a baby boy</h1>");
			else if(age<13)
				pw.println("<h1 style='color:red;text-align:center'>Master::"+name+" you are  a small boy</h1>");
			else if(age<19)
				pw.println("<h1 style='color:red;text-align:center'>Mr::"+name+" you are a teenage boy</h1>");
			else if(age<35)
				pw.println("<h1 style='color:red;text-align:center'>Mr::"+name+" you are a young man</h1>");
		    else if(age<50)
			    pw.println("<h1 style='color:red;text-align:center'>Mr::"+name+" you are a middle aged man</h1>");
		    else
				pw.println("<h1 style='color:red;text-align:center'>Mr::"+name+" you are a buddha</h1>");
		}
		else {
			if(age<5)
				pw.println("<h1 style='color:red;text-align:center'>Master::"+name+" you are a baby girl</h1>");
			else if(age<13)
				pw.println("<h1 style='color:red;text-align:center'>Master::"+name+" you are  a small girl</h1>");
			else if(age<19) {
				if(ms.equalsIgnoreCase("married"))
				     pw.println("<h1 style='color:red;text-align:center'>Mrs::"+name+" you are a teenage married girl</h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'>Ms::"+name+" you are a teenage girl</h1>");
			}
			else if(age<35) {
				if(ms.equalsIgnoreCase("married"))
				    pw.println("<h1 style='color:red;text-align:center'>Mrs::"+name+" you are a young married lady</h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'>Ms::"+name+" you are a young  lady</h1>");
			}
			else if(age<50) {
				if(ms.equalsIgnoreCase("married"))
			         pw.println("<h1 style='color:red;text-align:center'>Mrs::"+name+" you are a middle aged married  lady</h1>");
				else
					 pw.println("<h1 style='color:red;text-align:center'>Ms::"+name+" you are a middle aged lady</h1>");
		}	
			else {
				if(ms.equalsIgnoreCase("married"))
				    pw.println("<h1 style='color:red;text-align:center'>Mrs::"+name+" you are a old woman</h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'>Ms::"+name+" you are a old woman</h1>");
		}
	}	//else
		//display form data
		pw.println("<br><br><b>Form data :: </b><br>");
		pw.println("<br><b>name :: </b>"+name);
		pw.println("<br><b>age :: </b>"+age);
		pw.println("<br><b>Address :: </b>"+addrs);
		pw.println("<br><b>Gender :: </b>"+gender);
		pw.println("<br><b>Martial status :: </b>"+ms);
		pw.println("<br><b>Qualification :: </b>"+qlfy);
		pw.println("<br><b>Known languages :: </b>"+Arrays.toString(languages));
		pw.println("<br><b>Hobbies :: </b>"+Arrays.toString(hobbies));
		pw.println("<br><b>DOB :: </b>"+dob);
		pw.println("<br><b>TOB :: </b>"+tob);
		pw.println("<br><b>Month of birth :: </b>"+month);
		pw.println("<br><b>Week of birth :: </b>"+wdb);
		pw.println("<br><b>Favourite color :: </b>"+favColor);
		pw.println("<br><b>search string :: </b>"+favSS);
		pw.println("<br><b>Mobile number :: </b>"+mobileNo);
		pw.println("<br><b>Email :: </b>"+mail);
		pw.println("<br><b>Income :: </b>"+income);
		pw.println("<br><b>FBUrl :: </b>"+url);
		pw.println("<br><b>Favourite Number :: </b>"+favNumber);
	
		//add home hyperlink
		pw.println("<a href='all_comps_form.html'><h1 style='color:cyan;text-align:center'>Home</h1></a>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
