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
	地区ID：${area.areaid}<br/>
	地区名称：${area.aname}<br/>
	<hr/>
	属于该地区的作家：<br/>
	<table width = "800" border = "1">
		<tr>
			<th>作者ID</th>
			<th>作者姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>电话</th>
		</tr>
		<c:forEach var="i" items = "${area.alist}">
			<tr>
				<th>${i.authorid}</th>
				<th>${i.aname}</th>
				<th>${i.sex}</th>
				<th>${i.birthday}</th>
				<th>${i.tel}</th>
			</tr>
		
		</c:forEach>
	</table>
	</table>
</body>
</html>