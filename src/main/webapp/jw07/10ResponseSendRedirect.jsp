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
			: 10ResponseSendRedirect.jsp ���� �߰��� response�� �ϰ� location�� �ٽ� ���ο� request�� ����
			  URL ��ȭ�� ���� (���ο� request�� ������ ����)
			  
			  ex) java.sun.com
		--%>
		
		:: 10ResponseSendRedirect.jsp ���� <br/>
		
		<% request.setAttribute("aaa", "�����"); %>
		
		<% response.sendRedirect("09JSPActionForward.jsp"); %>
		
		:: 10ResponseSendRedirect.jsp �� <br/>
		
	</body>
</html>