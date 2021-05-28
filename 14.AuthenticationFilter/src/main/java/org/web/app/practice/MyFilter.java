package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Init method Called....");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("doFilter method Called....");
		PrintWriter out = resp.getWriter();

		String password = req.getParameter("password");
		System.out.println("PassWord---: "+password);
		
		if (password.equals("admin")) {
			chain.doFilter(req, resp);// sends request to next resource
		} else {
			out.print("username or password error!");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, resp);
		}

	}

	public void destroy() {
		System.out.println("Destroy method Called....");
	}

}