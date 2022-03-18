<%@page import="com.company.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 ArrayList<MemberVO> memberList=new ArrayList<MemberVO>();
 memberList=(ArrayList<MemberVO>) request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회/수정</title>
<link href="css/NewFile.css" rel="stylesheet"/>
</head>
<body>
<div id="container">
	<h1>회원목록조회/수정</h1> <br>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>회원성명</th>
				<th>회원전화</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>비고 </th>
			</tr>
			<%
			for (int i = 0; i < memberList.size(); i++) {
				MemberVO vo = memberList.get(i);
				String grade=null;
				if(vo.getGrade().equals("A") || vo.getGrade().equals("a")){
					grade="회원";
				}else if(vo.getGrade().equals("B") || vo.getGrade().equals("b")){
					grade="비회원";
				}else if(vo.getGrade().equals("C") || vo.getGrade().equals("c")){
					grade="직원";
				}
			%>
			<tr>
				<td><a href="Update?custno=<%=vo.getCustno()%>" style="color:gray;"><%=vo.getCustno()%></a></td>
				<td><%=vo.getId()%></td>
				<td><%=vo.getPw()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getPhone()%></td>s
				<td><%=vo.getJoindate()%></td>
				<td><%=grade%></td>
			 	<td><%=vo.getNote()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<br> <button> <a href="adminPage.jsp" style="color:white;">관리자페이지로 이동</a></button>
		</div>
</body>
</html>