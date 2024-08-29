<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("21JSTLMultiCheck.html");
	}
	
	else {
	request.setCharacterEncoding("euc-kr");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>21 JSTL c:if</title>
	</head>
	
	<body>
		
		이름 : ${param.name }	<br>
		나이	: ${param.age }		<br>
		<br>
		SW	: 
		<c:forEach items="${paramValues.sw }" var="swV">
			${swV }	<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
		<br>
		구분	: 
		<c:choose>
			<c:when test="${param.age > 80 }"> 어르신 </c:when>
			<c:when test="${param.age > 30 }"> 어른 </c:when>
			<c:when test="${param.age > 20 }"> 성인 </c:when>
			<c:otherwise> 청소년 </c:otherwise>
		</c:choose>
		
	</body>
</html>

<%	} %>