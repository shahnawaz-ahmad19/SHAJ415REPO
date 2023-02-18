package com.shaan.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shaan.wrapper.CustomRequest;
import com.shaan.wrapper.CustomResponse;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//create Custom Request Object
		CustomRequest creq=new CustomRequest(req);
		
		//create custom response object
		CustomResponse cres=new CustomResponse(res);
		
		chain.doFilter(creq, cres);
		//collect content from custom response object
		String output=cres.toString();
		//modify the content
		output=output+"<br> <b>Naresh IT<b>";
		//get print writer pointing to container created response object
		PrintWriter pw=res.getWriter();
		pw.println(output); //writes container created obj ---> container ----> server ---->browser window
		
		//close stream
		pw.close();
	}

}
