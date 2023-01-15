package com.shaan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 {
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		try {
			//read inputs
			sc= new Scanner(System.in);
			int dno=0;
			if(sc!=null) {
				System.out.println("Enter dept number::");
				dno=sc.nextInt();	// gives 1
			}
			
			//Load jdbc driver
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			//create connection object
			if(con!=null)
				st=con.createStatement();
			//prepare sql query
			    //select * from emp where deptno=40
			String query="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO="+dno;
			System.out.println(query);
			
			//send and execute SQL query
			if(st!=null)
				rs=st.executeQuery(query);
			
			//process the ResultSet (0 or 1 record)
			if(rs!=null) {
				if(rs.next())
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				else
					System.out.println("No record found!!");
			}//if

		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close JDBC objects
			try {
				if(rs!=null)
					rs.close();
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try {
				if(st!=null)
					st.close();
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se){
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}//try
			catch(Exception e){
				e.printStackTrace();
			}
			
		}//finally
		
	}//main

}//class
