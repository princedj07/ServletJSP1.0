package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {

		System.out.println("Filter Init");

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("doFilter");

		PrintWriter out = resp.getWriter();
		out.print("filter is invoked before");

		chain.doFilter(req, resp);// sends request to next resource

		out.print("filter is invoked after");
	}

	public void destroy() {

		System.out.println("Filter destroy");

	}
}