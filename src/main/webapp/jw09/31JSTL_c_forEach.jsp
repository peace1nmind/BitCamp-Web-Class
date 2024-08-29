<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>31 JSTL c:forEach</title>
	</head>
	
	<body>
		
		<%	List<String> list = Arrays.asList(new String[] {"aaa", "bbb", "ccc", "ddd"}); %>
		<%	pageContext.setAttribute("list", list); %>
		<c:forEach var="str" items="${list }" varStatus="status">
			str= ${str } <br>
			current = ${status.current } <br>
			index=${status.index } <br>
			first=${status.first } <br>
			last=${status.last } <br>
			begin=${status.begin } <br>
			end=${status.end } <br>
			step=${status.step } <br>
			========================================
		</c:forEach>
		
	</body>
</html>