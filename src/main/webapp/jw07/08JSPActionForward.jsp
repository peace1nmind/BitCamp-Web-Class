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
			: request를 그대로 가져감,
			  URL 변화없이 지정한 location으로 Navigation 기능을 함
		--%>
		
		:: 08JSPActionForward.jsp 시작 <br/>
		
		<% request.setAttribute("aaa", new String("연결됨")); %>
		
		<jsp:forward page="09JSPActionForward.jsp"/>
		
		:: 08JSPActionForward.jsp 끝 <br/>
		
	</body>
</html>