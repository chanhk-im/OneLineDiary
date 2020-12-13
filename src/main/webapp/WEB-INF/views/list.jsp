<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.chan.old.dao.DiaryDAO,com.chan.old.vo.DiaryVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>한줄일기</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@400;800&display=swap" rel="stylesheet" />
<link href="${path}/resources/css/styles.css" type="text/css" rel="stylesheet" />
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deleteok/' + id;
	}
	function test() {
		console.log("${path}");
	}
</script>
</head>
<body>
	<div id="container">
		<div id="top">
			<h1 id="title">한줄일기</h1>
			<div id="user">
				${login.username}  <a href="../duser/logout">로그아웃</a>
			</div>
		</div>
		<div id="contents">
			<div id="leftbar">
				<div id="innerbar">
					<a href="add" id="menubar">일기쓰기</a>
				</div>
			</div>
			<div id="main">
				<table id="list" width="90%">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일자</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				
				<c:forEach items="${list}" var="u">
					<tr>
						<td>${u.seq}</td>
						<td>${u.writer}</td>
						<td>${u.content}</td>
						<td>${u.regdate}</td>
						<td><a href="editform/${u.seq}">수정</a></td>
						<td><a href="javascript:delete_ok('${u.seq}')">삭제</a></td>
					</tr>
				</c:forEach>
				</table>
				
				<br/>
			</div>
		</div>
		<div id="bottom">
			<div id="innerbottom">
				Developer: 21900318 박찬영, 21900617 임찬혁
			</div>
			
		</div>
	</div>
</body>
</html>