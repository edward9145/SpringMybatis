<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Remove</title>
</head>
<body>
<div>
<p>${msg}</p>
	<form action="remove" method="get">
		<label>${user.username}</label>
		<input type="password" name="password">
		<input type="submit">
	</form>
</div>
</body>
</html>