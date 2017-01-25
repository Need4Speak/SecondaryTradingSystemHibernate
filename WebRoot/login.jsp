<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	body{ text-align:center} 
	.divcssTop{
					width:250px;
					margin: 0 auto;
  					padding: 0;
  					background: #FF4040;}
</style>
<title>登录</title>
</head>
<body>
	<div class=".divcssTop">
		<form action="servlet/LoginServlet" method="post">
		   	用户名:<input type="text" name="userName"/> <br/>
		   	密码：<input type="password" name="password"/> <br/>
		   <input type="submit" value="登录"/>
		</form>
	</div>
</body>
</html>