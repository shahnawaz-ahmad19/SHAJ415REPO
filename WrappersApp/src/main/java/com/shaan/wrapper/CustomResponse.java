package com.shaan.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomResponse extends HttpServletResponseWrapper {
    private HttpServletResponse response;
    private CharArrayWriter writer;
	public CustomResponse(HttpServletResponse response) {
		super(response);
		System.out.println("CustomResponse:: 1-param constructor");
		this.response=response;
		writer=new CharArrayWriter(); //internally create buffer and takes it  as destination
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter pw=new PrintWriter(writer); // Here indirectly PrintWriter stream is taking buffer as destination
		return pw;
	}
	
	@Override
	public String toString() {
		return writer.toString(); //content collected from buffer is returned as custom response obj content
	}

}
