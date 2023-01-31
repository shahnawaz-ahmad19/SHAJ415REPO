package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet  extends HttpServlet{
	private static final String GET_EMP_BY_ENO="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWritter
		PrintWriter pw=res.getWriter();
		
		//set contentType
		res.setContentType("text/html");
		
		//get access to ServletConfig object
		ServletConfig cg=getServletConfig();
		System.out.println("EmpSearchServlet's ServletConfig obj::"+cg.hashCode());
		
		//read servlet init parameter values
		String driver=cg.getInitParameter("driverClass");
		String url=cg.getInitParameter("url");
		String user=cg.getInitParameter("dbuser");
		String pwd=cg.getInitParameter("dbpwd");
		
		//read form data
		int no=Integer.parseInt(req.getParameter("eno"));
		//write JDBC code
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}	
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			       PreparedStatement ps=con.prepareStatement(GET_EMP_BY_ENO)){
			if(ps!=null)
				ps.setInt(1, no);		
			try(ResultSet rs=ps.executeQuery()){		    
			    if(rs!=null) {
			    	if(rs.next()) {
			    		pw.println("<h1 style='color:blue;text-align:center'>Employee Details are</h1>");
			    		
			    		pw.println("<p style='text-align:center'><b>Employee number:: "+rs.getInt(1)+"</b><br>");
			    		pw.println("<b>Employee name:: "+rs.getString(2)+"</b><br>");		
			    		pw.println("<b>Employee Desg:: "+rs.getString(4)+"</b><br>");
			    		pw.println("<b>Employee Salary:: "+rs.getFloat(3)+"</b><br>");
			    		pw.println("<b>Employee Dept number:: "+rs.getInt(5)+"</b><br>");
			    	}//if
			    	else {
			    		pw.println("<h1 style='color:blue;text-align:center'>Employee not found</h1>");
			    	}//else
			    }//if
			    pw.println("<br><br><p style='text-align:center'><a href='search.html'>HOME</a>");
		        //close the stream
			    pw.close();
			}//try with resource2
	}//	try with resource1	
	catch (SQLException se) {
			se.printStackTrace();
	}
		
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
