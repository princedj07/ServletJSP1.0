package org.web.app.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class Login extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    // This Method Is Called By The Servlet Container To Process A 'POST' Request.
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
   
    	System.out.println("Login.doPost()");
    	handleRequest(req, resp);
    }
 
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

    	System.out.println("Login.handleRequest()");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
 
        // Post Parameters From The Request
        String param1 = req.getParameter("username").trim(); 
        String param2 = req.getParameter("password").trim();
 
        System.out.println("Username----: "+param1);
        System.out.println("Password----: "+param2);
        
        // Creating The 'RequestDispatcher' Object For Forwading The HTTP Request       
        RequestDispatcher rdObj = null;
 
        // Checking For Null & Empty Values
        if(param1 == null || param2 == null || "".equals(param1) || "".equals(param2)) {
         
        	out.write("<h1 id='errMsg' style='color: red; font-size: larger;'>Please Enter Both Username & Password... !</h1>");
            rdObj = req.getRequestDispatcher("/index.jsp");
            rdObj.include(req, resp);
        
        } else if(param1.equalsIgnoreCase("admin") && param2.equals("admin123")) {
        
        	req.getSession().setAttribute("uname", param1);
            resp.sendRedirect("welcomeServlet");
        
        } else {
        
        	out.write("<h1 id='errMsg' style='color: red; font-size: larger;'>You are not an authorised user! Please check with administrator!</h1>");
            rdObj = req.getRequestDispatcher("/index.jsp");
            rdObj.include(req, resp);
       
        }
        
        out.write("</div></body></html>");
        out.close();
        
    }
}