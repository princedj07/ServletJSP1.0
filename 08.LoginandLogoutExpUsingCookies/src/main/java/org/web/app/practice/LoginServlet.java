package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.jsp").include(request, response);

		String name = request.getParameter("userName");
		String password = request.getParameter("password");

		if (password.equals("admin123")) {
			out.print("You are successfully logged in!");
			out.print("<br>Welcome, " + name);

			Cookie ck = new Cookie("uname", name);
			ck.setMaxAge(1800);
			response.addCookie(ck);
			
		} else {
			out.print("sorry, username or password error!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

		out.close();
	}

}
