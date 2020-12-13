<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄일기</title>
<style>
	img, label { display: inline-block; }
	label { width: 130px; }
	button { background-color: blue; color: white; font-size: 15px; }
</style>
</head>
<body>
	<div style='width: 100%; text-align: center; padding-top: 100px'>
		<form method="post" action="loginOK">
			<div><label>User ID: </label><input type="text" name="userid" /></div>
			<div><label>Password: </label><input type="password" name="password" /></div>
			<button type="submit">로그인</button>
		</form>
		<button onclick="location.href='signin'">회원 가입</button>
	</div>
</body>
</html>