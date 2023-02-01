package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	private static final String  CUSTOMER_INSERT_QUERY="INSERT INTO SERVLET_CUSTOMER VALUES(CUST_CNO.NEXTVAL,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data(req param values)
		String name=req.getParameter("cname");
		String addrs=req.getParameter("cadd");
		float billAmt=Float.parseFloat(req.getParameter("billAmt"));
		long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		//get pooled JDBC Con object
		try(Connection con=getPooledConnection();
				PreparedStatement ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
			){
			//SET VALUES TO QUERY PARAMETER
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setFloat(3, billAmt);
			ps.setLong(4, mobileNo);
			//execute the Query
			int result=ps.executeUpdate();
			//process the results
			if(result==1)
				pw.println("<h1 style='color:green'>Customer is registered</h1>");
			else
				pw.println("<h1 style='color:green'>Customer is not registered</h1>");
		    //add hyperlink
			pw.println("<br><br><a href='customer_register.html'>HOME<a/>");
			//close stream
			pw.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red'>Internal problem has occured-Try again"+se.getMessage()+"</h1>");
			//add hyperlink
			pw.println("<br><br><a href='customer_register.html'>HOME<a/>");
		}
		catch (Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red'>Internal problem has occured-Try again::  "+e.getMessage()+"</h1>");
			//add hyperlink
			pw.println("<br><br><a href='customer_register.html'>HOME<a/>");
		}
		
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
	//helper method
	private Connection getPooledConnection()throws Exception {
		//create initial context object
		InitialContext ic=new InitialContext();
		//get DataSource object ref through lookup operation ==>for GlassFish server
		//DataSource ds=(DataSource) ic.lookup("DsJndi");
		//get Ds Jndi name from servlet init param ==>for Tomcat server
		String jndiName=getServletConfig().getInitParameter("Jndi");
		DataSource ds=(DataSource) ic.lookup(jndiName);
		//get pooled JDBC connection
		Connection con=ds.getConnection();
		return con;
		
		
		
	}

}
