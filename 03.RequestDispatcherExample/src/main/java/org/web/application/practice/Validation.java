package org.web.application.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Login Servlet Called......");
		response.setContentType("text/html");
		
		PrintWriter pwriter = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		System.out.println("Username---: "+name);
		System.out.println("Password---: "+pass);
		
		if (name.equals("user") && pass.equals("pass")) {
			RequestDispatcher dis = request.getRequestDispatcher("welcome");
			dis.forward(request, response);
		} else {
			pwriter.print("<p style=color:red;\"><b>User name or password is incorrect!<b><p></body>");
			RequestDispatcher dis = request.getRequestDispatcher("index.html");
			dis.include(request, response);
		}
		
	}
}
