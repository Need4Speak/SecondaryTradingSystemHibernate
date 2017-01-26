<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.entity.*, com.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ text-align:center} 
	.divcssTop{
					width:250px;
					margin: 0 auto;
  					padding: 0;
  					background: #FF4040;}
</style>
<title>商品详情</title>
</head>
<body>
	<%!
		GoodDAO goodDAO = new GoodDAO();
	 %>
	<div>
		<jsp:include page="userLoginBar.jsp"></jsp:include>
	</div>
	<div class="divcssTop">
		<%
			Good good = new Good();
			String[] goodPictures = null;
			if (request.getParameter("goodId") != null) {
				int goodId = Integer.parseInt(request.getParameter("goodId"));
				good = goodDAO.findById(goodId);
				goodPictures = good.getPictures().split(", ");		 
			}
		%>
		<table width="250px" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="159px">商品名称: <%=good.getName() %></td>
		    <td width="91px">价格: <%=good.getPrice() %></td>
		  </tr>
		  <% 
		  	for(int arrIndex=0; arrIndex < goodPictures.length;arrIndex++) {
		  %>
		  	<tr>
		    	<td colspan="2"><img src="<%=basePath %>/images/<%=goodPictures[arrIndex]%>" border="0" width="120px" height="90px" /></td>
		  	</tr>
		  <%
		  	}
		   %>
	
		  <tr>
		    <td width="125px"><a href="<%=basePath %>/index.jsp">返回</a></td>
		    <td width="125px"><a href="<%=basePath %>servlet/PlaceOrderServlet?goodId=<%=good.getGoodId()%>">购买</a></td>
		  </tr>
		
		</table>
	</div>
</body>
</html>