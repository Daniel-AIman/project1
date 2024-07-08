<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="frontproject.vo.SampleTBVO" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="msg" value="{param.msg}"></c:set>

<c:if test="${!empty msg}">
	<c:if test="${msg eq 'fail'}">
		<script>
			alert("수정에 실패했습니다.");
		</script>
	</c:if>
</c:if>

<%-- <%
	SampleTBVO svo = (SampleTBVO)request.getAttribute("svo");
	
	String msg = request.getParameter("msg");
	if(msg  != null){
		if(msg.equals("fail")){
	%>
	<script>
		alert("수정에 실패했습니다.");
	</script>
	<%.
		}
	}
%>  --%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>sampleTB 수정페이지!</h2>
<form action="modify.do" method="post">
<%-- <input type="hidden" name="sno" value="<%=svo.getSno()%>"> --%>
<input type="hidden" name="sno" value="${svo.sno}">
	<table>
		<tbody>
			<tr>
				<th align="right">글번호:</th>
				<%-- <td><%=svo.getSno() %></td> --%>
				<td>${svo.sno}</td>
			</tr>
			<tr>
				<th align="right">제목:</th>
				<%-- <td><input type="text" name="title" value="<%=svo.getTitle() %>"></td> --%>
				<td><input type="text" name="title" value="${svo.title}"></td>
			</tr>
			<tr>
				<th align="right">작성자:</th>
				<%-- <td><input type="text" name="writer" value="<%=svo.getWriter() %>"></td> --%>
				<td><input type="text" name="writer" value="${svo.writer}"></td>
			</tr>
			<tr>
				<th align="right">작성일:</th>
				<%-- <td><%=svo.getRdate() %></td> --%>
				<td>${svo.rdate}</td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<%-- <td><textarea name="body"><%=svo.getBody() %></textarea></td> --%>
				<td><textarea name="body">${svo.body}</textarea></td>
			</tr>
		</tbody>
	</table>
	<button>저장</button>
</form>
</body>
</html>