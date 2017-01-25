<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page language="java" import="com.entity.*, com.dao.*, java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{ text-align:center} 
		/* css 注释：这样设置了对象divcss5宽度为300px样式 */ 
		.divcssTop{
					width:250px;
					height:80px;
					margin: 0 auto;
  					padding: 0;
  					background: #FF4040;}
		.divcssMiddle{
					width:250px;
					height:40px;
					margin: 0 auto;
  					padding: 0;
  					background: #FF6A6A;}
		.divcssBottom{
					width:250px;
					margin: 0 auto;
  					padding: 0;
  					background: #FAEBD7;}
	</style>
  </head>
  
  <body>
  	<%!
  		GoodDAO goodDAO = new GoodDAO();
  		UserDAO userDAO = new UserDAO();
  	 %>
    <div  class="divcssTop">二手交易网站</div>
    <div  class="divcssMiddle">
        <table width="250px" height="40px" border="1" cellspacing="0" cellpadding="0">
        	<tr>
			    <td >最新</td>
			    <td><jsp:include page="userLoginBar.jsp"></jsp:include></td>
			    
		  	</tr>
        </table>
    </div>
    <div  class="divcssBottom">
    
	    <%
    	    	ArrayList<Good> goodsList = (ArrayList<Good>)goodDAO.findAll();
    	    	Iterator<Good> goodsListIterator = goodsList.iterator(); 
    	    	Good eachGood;
    	    	String[] eachGoodPictures;
    	    	List<String> goodPicturesList = new ArrayList<String>();
    	    	// ownerName: Record the owner of the good.
    	    	int ownerId;
    	    	String ownerName;
    	    	        while(goodsListIterator.hasNext()){
    	    	        	eachGood = (Good) goodsListIterator.next();
    	    	        	// Get owner info.
    	    	        	ownerId = goodDAO.findById(eachGood.getGoodId()).getUser().getUserId();
    	    	        	//ownerId = UserOwnGoodsDAO.getUserIdByGoodsId(eachGood.getGoodId());
    	    	        	ownerName = userDAO.findById(ownerId).getUserName();
    	    	        	//Ensure each good own 2 pictures.
    	    	        	eachGoodPictures = eachGood.getPictures().split(", ");
    	    	        	Collections.addAll(goodPicturesList, eachGoodPictures);
    	    	        	//If the good only have one pictures.
    	    	        	if(eachGoodPictures.length < 2) {
    	    	        		goodPicturesList.add("noGoodPictures.jpg");
    	    	        	}
    	    	            //System.out.println(eachGood);
    	    %>
	     
	    <a href="servlet/OderInfoServlet?goodId=<%=eachGood.getGoodId()%>">    
	    <!-- 
	    <a href="goodInfo.jsp?goodId=<%=eachGood.getGoodId()%>">
	    -->
		<table width="250px" height="150px" border="1" cellspacing="0" cellpadding="0">
		  <tr height="20px">
		    <td >卖家昵称:<%=ownerName %></td>
		    <td>价格:<%=eachGood.getPrice() %></td>
		  </tr>
		  <tr>
		    <td width="125px"><img src="images/<%=goodPicturesList.get(0)%>" border="0" width="120px" height="90px" /></td>
		    <td><img src="images/<%=goodPicturesList.get(1)%>" border="0" width="120px" height="90px" /></td>
		  </tr>
		  <tr height="50px">
		    <td colspan="2">商品名:<%=eachGood.getName() %>, 商品详细介绍</td>
		  </tr>
		</table>
		</a>
		<% 
			//Remove all items in goodPicturesList, otherwise it can't use normally.
			goodPicturesList.clear();
		    }
	    %>
    
    </div>
  </body>
</html>
