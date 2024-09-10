<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User1::modify</title>
</head>
<body>
	<h3>User1 수정</h3>
	
	<a href="/ch05/">처음으로</a>
	<a href="/ch05/user1/list">목록</a>

	<form action="/ch5/user1/modify" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" value="${user1Dto.uid}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user1Dto.name}"/></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" value="${user1Dto.birth}"/></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" value="${user1Dto.hp}"/></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age" value="${user1Dto.age}"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기"/>
				</td>
			</tr>		
		</table>
	
	</form>
	
	
</body>
</html>