package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.jsp").include(request, response);

		Cookie ck[] = request.getCookies();
		String name = "";

		for (int i = 0; i < ck.length; i++) {
			out.print("<br>Result---: " + ck[i].getName().equals("uname") + " <br>");
			if (ck[i].getName().equals("uname")) {
				System.out.println("foreach");
				name = ck[i].getValue();
				System.out.println("UserName---: " + name);
				break;
			}
		}

		if (name != null) {
			out.print("<br><br><b>Welcome to Profile</b>");
			out.print("<br>Welcome, " + name);
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

		out.close();
	}

}
