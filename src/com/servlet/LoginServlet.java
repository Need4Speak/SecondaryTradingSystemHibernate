package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

public class LoginServlet extends HttpServlet {

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
	    PrintWriter out = response.getWriter();
	    String userName = request.getParameter("userName").trim();
	    String password = request.getParameter("password").trim();
	    UserDAO userDAO = new UserDAO();
	    boolean loginCondition = userDAO.tryLogin(userName, password);
	    if (loginCondition) {
			request.getSession().setAttribute("userName", userName);
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			response.sendRedirect("../index.jsp");
		}
	    else {
	    	out.println("登录失败!<br>");
	    	out.println("<a href='../login.jsp'>返回登录界面</a><br>");
	    	out.println("<a href='../index.jsp'>返回首页</a><br>");
	    	out.close();
		}
	    
	}

}
