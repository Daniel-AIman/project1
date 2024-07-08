<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글 작성자</th>
			<th>글 작성일</th>
		</tr>
		<c:forEach items="${vo}" var="bvo">
			<tr>
				<td>${bvo.sno}</td>
				<td><a href='<c:url value="/board/post.do?sno=${bvo.sno}"></c:url>'>${bvo.title}</a></td>
				<td>${bvo.writer}</td>
				<td>${bvo.rdate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href='<c:url value="/board/write.do"/>'></a>
</body>
</html>