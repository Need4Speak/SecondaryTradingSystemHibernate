package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    
	    HttpSession session = request.getSession(false);
	    String userName = request.getParameter("userName").trim();
	    // preBasePath store the page path who call this servlet.
	    //String preBasePath = request.getParameter("basePath");
	    String preBasePath = "../index.jsp";
	    
        if(session == null){  
        	System.out.println("session is null in Logout Servlet."); 
            return;  
        } 
        else {
			session.invalidate();
			
		}
	    
        response.sendRedirect(preBasePath);  
	}

}
