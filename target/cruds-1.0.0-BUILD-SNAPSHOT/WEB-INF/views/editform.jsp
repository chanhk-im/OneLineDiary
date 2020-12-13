<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄일기</title>
</head>
<body>

	<h1>일기 내용 수정</h1>
	<form:form commandName="u" action="../editok" method="post">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="seq" /></td>
			</tr>
			<tr>
				<td>작성자: </td>
				<td><form:input path="writer" readonly="true"/></td>
			</tr>
			<tr>
				<td>내용: </td>
				<td><form:textarea cols="50" rows="5" path="content" /></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="확인"/>
			<input type="button" value="취소" onclick="history.back()"/></td></tr>
		</table>
	</form:form>

</body>
</html>