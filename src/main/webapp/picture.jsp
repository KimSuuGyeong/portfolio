<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name=(String)session.getAttribute("name"); 
    if(name==null){
    	response.sendRedirect("login.jsp");
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시술사진</title>
<link href="css/NewFile.css" rel="stylesheet"/>
</head>

<body>
<form >
<div id="container">
<h3 style="text-align:right;"><%=name %> 님 환영합니다!! <br><a href="LogoutPro" style="text-decoration:none; color:navy; size:8px;">로그아웃</a></h3>
<table>
<tr><img src="image/1.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/2.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/3.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/4.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/6.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/7.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/8.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/10.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/11.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/12.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/13.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/14.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/15.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/16.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/17.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/18.jpg" width="33%" height="200" id="pic"></tr>
<tr><img src="image/19.jpg" width="33%" height="200" id="pic"></tr>
</table>
</div>
</form>
</body>

</html>