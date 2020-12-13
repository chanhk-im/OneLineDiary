<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄일기</title>
</head>
<body>

	<h1>회원가입</h1>
	<form action="signinok" method="post">
		<table>
			<tr>
				<td>ID: </td>
				<td><input type="text" name="userid"/></td>
			</tr>
			<tr>
				<td>비밀번호: </td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>이름: </td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="확인"/></td>
			</tr>
		</table>
	</form>

</body>
</html>