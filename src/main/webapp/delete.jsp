<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link href="css/NewFile.css" rel="stylesheet"/>
</head>
<body>
	<h3>회원탈퇴</h3>
	<hr>
	<form action="DeletePro" method="get">
		<div id="container">
			<table>
				<tr>
					<td><input type="text" name="id" class="idInput" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><input type="text" name="name" class="pwInput" placeholder="회원이름"></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center;">
						<button type="submit">삭제</button>
						<button type="reset">
							<a href="adminPage.jsp" style="color:white;" href="adminPage.jsp">취소 </a>
						</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>