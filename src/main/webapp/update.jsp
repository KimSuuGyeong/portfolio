<%@page import="com.company.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   MemberVO vo=new MemberVO();
   vo=(MemberVO)request.getAttribute("vo");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link href="css/NewFile.css" rel="stylesheet"/>
</head>
<body>
<div id="container">
	<form action="UpdatePro" method="post" name="memberForm">
		<table>
		 	<tr>
		 		<th>회원번호</th>
		 		<td> <input type="text" name="custno" value="<%=vo.getCustno()%>"> </td>
		 	</tr>
		 	<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value="<%=vo.getId()%>"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" value="<%=vo.getPw()%>"></td>
		</tr>
		<tr>
			<th>회원성명</th>
			<td><input type="text" name="name" value="<%=vo.getName()%>"></td>
		</tr>
		<tr>
			<th>회원전화</th>
			<td><input type="text" name="phone" value="<%=vo.getPhone()%>"></td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td><input type="date" name="joindate" value="<%=vo.getJoindate()%>"></td>
		</tr>
		<tr>
			<th>고객등급(A:회원,B:비회원,C:직원)</th>
			<td><input type="text" name="grade" value="<%=vo.getGrade()%>"></td>
		</tr>
			<tr>
			<th>비고</th>
			<td><input type="text" name="note" value="<%=vo.getNote()%>"></td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align:center;">
			<input type="submit" value="수정">
			<input type="button" value="조회" onclick="location.href='SearchPro'"></td>
		</tr>
		</table>
	</form>
	</div>
</body>
</html>