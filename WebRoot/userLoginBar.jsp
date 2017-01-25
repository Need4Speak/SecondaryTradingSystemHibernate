<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.entity.*, com.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String fileName=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
fileName = "index.jsp";
System.out.println("fileName: " + fileName);
%>
  	<%!
  		User userLogin = new User();
  		UserDAO userDAO = new UserDAO();
  	%>
  	<% 
  		String userNameInSession;
  		if(session.getAttribute("userName")!=null){
  			userNameInSession = (String)request.getSession().getAttribute("userName");
  			// Get log in user's obejct.
  			userLogin = userDAO.findByUserName(userNameInSession);
  		}
  		else {
  			userNameInSession = null;
  		}
  	%>
  	<!-- Set jstl var userNameInSession -->
  	<c:set var="userNameInSession" value="<%=userNameInSession %>"/>
    <c:choose>
	    <c:when test="${userNameInSession == null}">
	    	<a href="login.jsp">登录</a>
	    </c:when>
	    <c:otherwise>
	    	<%=userLogin.getUserName() %>已登录，<a href="<%=basePath%>servlet/LogoutServlet?userName=<%=userNameInSession %>&fileName=<%=fileName %>">注销</a>
	    </c:otherwise>
	</c:choose>  		
