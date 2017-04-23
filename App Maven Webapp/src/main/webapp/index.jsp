<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	<form action="api/baidu/face/add" method="post" enctype="multipart/form-data">
		<input type="file" name="file" multiple="multiple">
		<input type="submit" value="提交">
	</form>
	</body>
</html>
