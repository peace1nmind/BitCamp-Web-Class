<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>03RequestScopeTest.jsp</title>
	</head>
	
	<body>
		
	<%
		Integer count = (Integer) request.getAttribute("count");
		
		if (count == null) { %>
			:: 1 번째 Request ::
	<%		request.setAttribute("count", new Integer(1));
			
		} else {
			int changeCount = count.intValue() + 1; %>
			:: <%= changeCount %> 번째 Request ::
			
	<%		request.setAttribute("count", new Integer(changeCount));
		}
	%>
		
	</body>
</html>