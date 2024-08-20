<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>01SessionScopeTest.jsp</title>
	</head>
	
	<body>
		
	<%
		Integer count = (Integer) session.getAttribute("count");
		
		if (count == null) { %>
			:: Browser 켜고 1 번째 방문 ::
	<%		session.setAttribute("count", new Integer(1));
			
		} else {
			int changeCount = count.intValue() + 1; %>
			:: Browser 켜고 <%= changeCount %> 번째 방문 ::
			
	<%		session.setAttribute("count", new Integer(changeCount));
		}
	%>
		
	</body>
</html>