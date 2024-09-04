<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User1::list</title>
</head>
<body>
	<h3>User1 목록</h3>
	
	<a href="/ch04/user1/list">처음으로</a>
	<a href="/ch04/user1/register">등록</a>
	
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>휴대폰</th>
			<th>나이</th>
			<th>관리</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<th>${user.uid}</th>
				<th>${user.name}</th>
				<th>${user.birth}</th>
				<th>${user.hp}</th>
				<th>${user.age}</th>
				<td>
					<a href="/ch04/user1/modify?uid=${user.uid}">수정</a>
					<a href="/ch04/user1/delete?uid=${user.uid}">삭제</a>
				</td>
			</tr>

		</c:forEach>

	</table>
	
	
</body>
</html>