<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Option</title>
</head>
<body>
<div>
<p>${msg}</p>
	<form action="update" method="get">
		<input type="hidden" name="id" value="${user.id}">
		username: <label>${user.username}</label> 
		password: <input type="password" name="password">
		new password: <input type="password" name="new_password">
		confirm new password: <input type="password" name="">
		age: <input type="text" name="age" value="${user.age}">
		height: <input type="text" name="height" value="${user.height}">
		<input type="submit">
	</form>
</div>
</body>
</html>