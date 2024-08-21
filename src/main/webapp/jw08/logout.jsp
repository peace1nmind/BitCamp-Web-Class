<%@page import="jw.service.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>logout.jsp</title>
	</head>
	
	<body>
		
		<%
			UserVO userVO = (UserVO) session.getAttribute("userVO");
			
			if (userVO == null) {
				userVO = new UserVO();
			}
		%>
		
		<% 	if (!userVO.isActive()) { %>
				<jsp:include page="../jw07/login.html"/>
				<br/>
				<input type='button' value='ȸ������' onclick="window.location.href='../jw07/addUser.html'">
				
		<% 	} else { %>
				<%= userVO.getId() %> �� �α��� �ϼ̽��ϴ�. <br/><br/>
				<form action="<%= request.getRequestURL() %>" method="post">
					URL : <%= request.getRequestURL() %> <br/>
					URI : <%= request.getRequestURI() %> <br/><br/>
					<input type='submit' value='Logout'>
				</form>
				<br/><br/>
				
		<%	} %>
		
		<%
			if (request.getMethod().equals("POST")) {
				
				// logout ��� 3����
				
				// 1. session ����
				//session.invalidate();
				
				// 2. session���� userVO ����
				session.removeAttribute("userVO");
				
				// 3. userVO�� active�� false�� ����
				//userVO.setActive(false);
				
				response.sendRedirect("logout.jsp");
			}
		%>
		
	</body>
</html>