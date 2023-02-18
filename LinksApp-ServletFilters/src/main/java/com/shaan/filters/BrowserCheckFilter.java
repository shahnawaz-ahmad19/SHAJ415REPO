package com.shaan.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserCheckFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BrowserCheckFilter.doFilter()");
	    //get PrintWriter obj
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get browser name
		String browser=req.getHeader("user-agent");
		System.out.println(browser);
		if(browser.contains("Chrome")) {
			chain.doFilter(req, res); //executes next filter or destination web component
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Request must be given from chrome browser</h1>");
			return;
		}
		//close the stream
		pw.close();
	}
	
}
