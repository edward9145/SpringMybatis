<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>
<div>
<p>${msg}</p>
	<form action="register" method="get">
		username: <input type="text" name="username">
		password: <input type="password" name="password">
		age: <input type="text" name="age">
		height: <input type="text" name="height">
		<input type="submit">
	</form>
</div>
</body>
</html>