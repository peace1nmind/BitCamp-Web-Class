<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>08JSPActionForward.jsp</title>
	</head>
	
	<body>
		
		<%-- 
			<jsp:forward page="09JSPActionForward.jsp"/>
			: request�� �״�� ������,
			  URL ��ȭ���� ������ location���� Navigation ����� ��
		--%>
		
		:: 08JSPActionForward.jsp ���� <br/>
		
		<% request.setAttribute("aaa", new String("�����")); %>
		
		<jsp:forward page="09JSPActionForward.jsp"/>
		
		:: 08JSPActionForward.jsp �� <br/>
		
	</body>
</html>