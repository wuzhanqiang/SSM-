<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML-1</title>
</head>
<body>
	<table width = "800" border = "1">
		<tr>
			<th>作者ID</th>
			<th>作者姓名</th>
			<th>国籍</th>
			<th>性别</th>
			<th>生日</th>
			<th>电话</th>
		</tr>
		<c:forEach var="i" items = "${alist}">
			<tr>
				<th>${i.authorid}</th>
				<th>${i.aname}</th>
				<th>${i.area.aname}</th>
				<th>${i.sex}</th>
				<th>${i.birthday}</th>
				<th>${i.tel}</th>
			</tr>
		
		</c:forEach>
	</table>
	<hr/>
		<table width = "800" border = "1">
		<tr>
			<th>作者ID</th>
			<th>作者姓名</th>
			<th>国籍</th>
			<th>性别</th>
			<th>生日</th>
			<th>电话</th>
		</tr>
		<c:forEach var="i" items = "${alist2}">
			<tr>
				<th>${i.authorid}</th>
				<th>${i.aname}</th>
				<th>${i.areaname}</th>
				<th>${i.sex}</th>
				<th>${i.birthday}</th>
				<th>${i.phone}</th>
			</tr>
		
		</c:forEach>
	</table>
</body>
</html>