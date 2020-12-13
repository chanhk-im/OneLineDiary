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

	<h1>일기쓰기</h1>
	<form action="addok" method="post">
		<table>
			<tr>
				<td>작성자: </td>
				<td><input type="text" name="writer" value="${login.username}" readonly/></td>
			</tr>
			<tr>
				<td>내용: </td>
				<td><textarea cols="50" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="확인"/></td>
			</tr>
		</table>
	</form>

</body>
</html>