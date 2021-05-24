package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcomeServlet")
public class Welcome extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    // This Method Is Called By The Servlet Container To Process A 'G' Request.
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    	System.out.println("Welcome.doGet()");
    	handleRequest(req, resp);
    }
 
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    	System.out.println("Welcome.handleRequest()");
        resp.setContentType("text/html");
 
        // Post Parameters From The Request
        String param1 = (String) req.getSession().getAttribute("uname");
 
        System.out.println("Username----: "+param1);
        
        PrintWriter out = resp.getWriter();
        
        if(param1!=null && param1.equals("admin")) {
	       
	        out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
	        out.write("<h2>Servlet Request Dispatcher Example</h2>");
	        out.write("<p style='color: green; font-size: large;'>Congratulations! <span style='text-transform: capitalize;'>" + param1 + "</span>, You are an authorised login!</p>");
	        out.write("</div></body></html>");
	        out.close();
        }else {
        	System.out.println("something went wrong!");
        	resp.sendRedirect(req.getContextPath() + "/");

        }        
    }
}
