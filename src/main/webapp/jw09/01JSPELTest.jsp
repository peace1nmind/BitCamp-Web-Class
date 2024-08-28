<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>01 JSP EL Test</title>
	</head>
	
	<body>
		<% String s = "11"; %>
		<% request.setAttribute("s", s); %>
		${3 }<br>
		${s+3}<br>
		${1 < 8? "참" : "거짓"}<br>
		${"4"*3 < 8  → 거짓<br>
		${3*3}<br>
		${8 == 8 }
		
		
	</body>
</html>