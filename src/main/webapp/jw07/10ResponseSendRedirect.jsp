<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>10ResponseSendRedirect.jsp</title>
	</head>
	
	<body>
	
		<%--
			<% response.sendRedirect("09JSPActionForward.jsp"); %>
			: 10ResponseSendRedirect.jsp 에서 중간에 response를 하고 location에 다시 새로운 request를 보냄
			  URL 변화가 있음 (새로운 request가 들어오기 때문)
			  
			  ex) java.sun.com
		--%>
		
		:: 10ResponseSendRedirect.jsp 시작 <br/>
		
		<% request.setAttribute("aaa", "연결됨"); %>
		
		<% response.sendRedirect("09JSPActionForward.jsp"); %>
		
		:: 10ResponseSendRedirect.jsp 끝 <br/>
		
	</body>
</html>