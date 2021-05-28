package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.jsp").include(request, response);

		HttpSession session = request.getSession(false);

		System.out.println("condition1---: "+session != null);
		System.out.println("condition2---: "+Objects.nonNull(session));
		System.out.println("conditon3----: "+session.getId());
		
		String name = (String) session.getAttribute("name");
		
		if (name != null) {
			out.print("Hello, " + name + " Welcome to Profile");
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		out.close();
	}
}