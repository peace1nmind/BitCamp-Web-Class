<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("EUC-KR"); %>

<%	
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("32JSTLMultiCheck.html");
	}
	
	else {
	request.setCharacterEncoding("euc-kr");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>32 JSTL c:forEach</title>
	</head>
	
	<body>
		
		1. <br>
		<c:forEach var="i" items="${paramValues.sw }" varStatus="status">
			o sw = paramValues.sw[${status.index }] = ${i }	<br>
		</c:forEach>
		
		3.
		<c:forEach var="i" items="${param }">
			o ${i.key } : ${i.value }	<br>
		</c:forEach>
		
		5.
		
		<c:forEach var="i" items="${param }">
			<c:if test="${i.value==param.name }">
				o ${i.value }씨 ${(param.age > 31)? "밥사주세요" : "밥 사드릴게요" }
			</c:if>
		</c:forEach>
		
		
		
	</body>
</html>

<%	} %>