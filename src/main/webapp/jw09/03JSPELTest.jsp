<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%	
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("03ELMultiCheck.html");
	}
	
	else {
	request.setCharacterEncoding("euc-kr");
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>03 JSP EL Test</title>
	</head>
	
	<body>
	
		<%= request.getMethod() %><br>
		URI= ${pageContext.request.requestURI } <br>
		sessionId= ${pageContext.session.id } <br>
		
		<br>
		
		name= ${param.name } <br>
		addr= ${param.addr } <br>
		
		<br>
		
		empty sw = ${empty paramValues.sw }<br>
		sw.length = ${paramValues.sw } <%= request.getParameterValues("sw").length %><br>
		** EL 표기법 자체에서는 length를 구할수 없어서 JSTL을 사용하거나 java문을 통해서 얻어야한다 <br>
		sw0 = ${paramValues.sw[0] } <br>
		sw1 = ${paramValues.sw[1] } <br>
		sw2 = ${paramValues.sw[2] } <br>
		sw3 = ${paramValues.sw[3] } <br>
		
		<br>
		
		cookie JSESSIONID name = ${cookie.JSESSIONID.name }<br>
		cookie JSESSIONID value = ${cookie.JSESSIONID.value }
		
	</body>
</html>

<% } %>