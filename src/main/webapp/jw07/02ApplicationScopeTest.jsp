<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>02ApplicationScopeTest.jsp</title>
	</head>
	
	<body>
		
	<%
		Integer count = (Integer) application.getAttribute("count");
		
		if (count == null) { %>
			:: 해당 페이지 1 번째 방문 ::
	<%		application.setAttribute("count", new Integer(1));
			
		} else {
			int changeCount = count.intValue() + 1; %>
			:: 해당 페이지 <%= changeCount %> 번째 방문 ::
			
	<%		application.setAttribute("count", new Integer(changeCount));
		}
	%>
		
	</body>
</html>