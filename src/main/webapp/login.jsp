<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="css/NewFile.css" rel="stylesheet" />

</head>
<body>
	<form name="loginForm">
		<div id="container" style="width: 400px">
			<label for="id"> <input type="text" id="id"
				placeholder="아이디 " name="id" class="idInput"></label> <br> <label
				for="pw"> <input type="password" id="pw" placeholder="비밀번호"
				name="pw" class="pwInput"></label> <br>
			<button type="button" onclick="login();return false;">로그인</button>
			<button type="button">
				<a href="index.jsp" style="text-decoration: none; color: white;">홈으로</a>
			</button>
		</div>
	</form>
</body>


<script type="text/javascript">
function login(){
	var id=document.getElementById('id').value;
	var pw=document.getElementById('pw').value;
	
	if(id=="" || id.length==0){
		alert('ID 입력하세요.');
		document.getElementById('id').focus();
	}else if(pw=="" || pw.length==0){
		alert('패스워드 입력하세요.');
		document.getElementById('pw').focus();
	}else{
		loginForm.method="post";
		loginForm.action="LoginPro";
		loginForm.submit();
	}
	
}
</script>
</body>
</html>