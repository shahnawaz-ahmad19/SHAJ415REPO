package com.shaan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO UPLOAD_EMPLOYEE VALUES(EMP_SEQ.NEXTVAL,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//read special request object
			MultipartFormDataRequest nreq=new MultipartFormDataRequest(req);
			//read form data
			String name=nreq.getParameter("ename");
			String addrs=nreq.getParameter("eadd");
			//create uploadBean class object
			UploadBean upb=new UploadBean();
			upb.setFolderstore("D:/Store");
			upb.setOverwrite(false);
			upb.setFilesizelimit(100*1024);
			upb.store(nreq);
			pw.println("<b> files uploaded successfully</b>");
			//get the names of the uploaded files
				Vector<UploadParameters> vector=upb.getHistory();
				ArrayList<String> filesList=new ArrayList();
				vector.forEach(up->{
					filesList.add("D:/store/"+up.getFilename()); //folder location in the server machine file location 
				});
				//write jdbc code to form data and files location to db table as record
				    //load JDBC driver class
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//establish the Connection
				 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
				//Create prepared statement object
				 ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);
				//set values to query param
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setString(3, filesList.get(0));
				ps.setString(4, filesList.get(1));
				//execute the query
				int count=ps.executeUpdate(); 
				if(count==1)
					pw.println("<h1 style='color:red;text-align:center'>Employee registered</h1>");
				else
					pw.println("<h1 style='color:red;text-align:center'>Employee  is not registered</h1>");
	
				
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<b> Problem in file uploading</b>"+e.getMessage());
		}
		finally {
			//close JDBC  object
			try {
			if(ps!=null)
				ps.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				}
				catch (SQLException se) {
					se.printStackTrace();
				}
		}//finally
		//add home hyperlink
		pw.println("<a href='employee_register.html'>HOME</a>");
		//close stream
		pw.close();
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
