<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	session.setAttribute("client", new jw09.Client());
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>04 JSP EL Test</title>
	</head>
	
	<body>
		
		name= ${client.name }<br>
		info = ${client.info }<br>
		info0 = ${client.info[0] }<br>
		info1 = ${client.info[1] }
		
	</body>
</html>