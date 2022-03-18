<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int maxNum = (int) request.getAttribute("maxNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="css/NewFile.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<form action="input" method="post" name="memberForm">
		<div id="container">
			<table border="1">
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" name="custno" value="<%=maxNum%>"></td>
				</tr>
				<tr>
					<th>아이디
						<button type="button" onclick="ajaxIdCheck();return false;"
							style="width: 80px; height:20px; float: right; ">ID중복확인</button>
					</th>
					<td><input type="text" name="id" id="id"> <br> 
					<b><div id="idCheckResult" style="font-size: 10px"></div></b></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="date" name="joindate"></td>
				</tr>
				<tr>
					<th>고객등급(A:회원,B:비회원,C:직원)</th>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
					<input type="button" value="등록" onclick="memberInsert();return false;"> &nbsp;
					<input type="button" value="취소" 	onclick="location.href='index.jsp'">
					</td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function ajaxIdCheck() {
			var _id = $("#id").val();

			if (_id.length == 0 || _id == "") {
				alert('검색할 ID입력');
			} else {
				$.ajax({
						type : "get", //통신 타입을 설정  get,post 등의 방식 지정.
						url : "http://localhost:8081/administration/IdCheck",//요청 URL(Uniform Resource Locator 자원고유위치)..
						async : true, // 기본값은 false. 비동기 전송 여부 
						data : {
					    	id : _id
						},
						success : function(data) {
							if (data == "yes") {
								/* 	alert('해당 ID 사용할 수 없습니다.'); */
								$("#idCheckResult")
								.html(
									"이미 존재하는 ID입니다. <button onclick='useOtherId();return false;'>다른 아이디 사용 </button>");
							} else {
									/* alert('해당 ID 사용할 수 있습니다.'); */
								$("#idCheckResult")
								.html(
									"해당 ID는 사용가능합니다. <button onclick='useThisId();return false;' >아이디 사용 </button>");
							}

						}, //요청 응답에 성공했을 때 처리할 구문
							error : function(result) {
								alert('실패');
						}//요청 응답에 실패했을 때 처리할 구문
				});
			}
		}

		function useThisId() {
			console.log('useThisId');
			$("#idCheckResult").empty(); //idCheckResult 하위 값을 비운다.
			$("#pw").focus(); //커서를 PW 박스 위치에 가게 한다.
		}

		function useOtherId() {
			console.log('useOtherId');
			$("#id").val(''); //아이디 텍스트 박스 값을 비우겠다.(새로운 값을 입력받기 위해)
			$("#id").focus(); //커서를 ID 텍스트 박스 위치에 가게 한다.
			$("#idCheckResult").empty(); //idCheckResult 하위 값을 비운다.

		}

		var p;
		function memberInsert() {
			console.log('event');
			var id =memberForm.id.value;
			var pw = memberForm.pw.value;
			var name = memberForm.name.value;
			var phone = memberForm.phone.value;
			var joindate=memberForm.joindate.value;
			var grade=memberForm.grade.value;

			if (id == "" || id.length == 0) {
				alert('ID를 입력하세요.');
				document.getElementById('id').focus();
			} else if (pw == "" || pw.length == 0) {
				alert('패스워드 입력하세요.');
				document.getElementById('pw').focus();
			} else if (name == "" || name.length == 0) {
				alert('이름을 입력하세요.');
				document.getElementById('name').focus();
			} else if (phone == "" || phone.length == 0) {
				alert('전화번호를 입력하세요.');
				document.getElementById('phone').focus();
			}else if (joindate == "" || joindate.length == 0) {
				alert('가입일자를 선택하세요.');
				document.getElementById('joindate').focus();
			}else if (grade == "" || grade.length == 0) {
				alert('등급을 입력하세요.');
				document.getElementById('grade').focus();
			}else {
				memberForm.action = "JoinPro";
				memberForm.method = "post";
				memberForm.submit();
			}
		}
	</script>
</body>
</html>