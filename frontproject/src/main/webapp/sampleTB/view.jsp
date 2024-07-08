<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="frontproject.vo.SampleTBVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	SampleTBVO svo = (SampleTBVO)request.getAttribute("svo");
%>  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sampleTB 상세페이지</h2>
	<table>
		<tbody>
			<tr>
				<th align="right">글번호</th>
				<%-- <td><%=svo.getSno() %></td> --%>
				<td>${svo.sno}</td>
			</tr>
			<tr>
				<th align="right">제목</th>
				<%-- <td><%=svo.getTitle() %></td> --%>
				<td>${svo.title}</td>
			</tr>
			<tr>
				<th align="right">작성자</th>
				<%-- <td><%=svo.getWriter() %></td> --%>
				<td>${svo.writer}</td>
			</tr>
			<tr>
				<th align="right">작성일</th>
				<%-- <td><%=svo.getRdate() %></td> --%>
				<td>${svo.rdate}</td>
			</tr>
			<tr>
				<th align="right">내용:</th>
				<%-- <td><%=svo.getBody() %></td> --%>
				<td>${svo.body}</td>
			</tr>
		</tbody>
	</table>
	<%-- <button onclick="location.href='modify.do?sno=<%=svo.getSno()%>'">수정</button> --%>
	<button onclick="location.href='modify.do?sno=${svo.sno}'">수정</button>
	<!-- 서블릿을 사용하여 수정페이지 만들기. 제목, 작성자, 내용 변경가능 -->
</body>
</html>