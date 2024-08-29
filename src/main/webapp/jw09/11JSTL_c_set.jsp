<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>11 JSTL c:set</title>
	</head>
	
	<body>
		
		<c:set var="num1" value="100" scope="page"></c:set>
		<c:set var="num2"></c:set>
		
		<%
			String abc = (String) pageContext.getAttribute("num2");
		%>
		
		_+abc+_ = <%=	"_"+abc+"_" %>	<br>
		
		num1 + num2 = ${num1+num2 }	<br>
		
		<c:set var="num2" value="${num1+num2 }"></c:set>
		
		num1 + num2 = ${num1+num2 }	<br>
		
		<c:remove var="num1"></c:remove>
		
		num1 = ${empty num1 }, ${num1 }	<br>
		num2 = ${empty num2 }, ${num2 }
		
		
	</body>
</html>