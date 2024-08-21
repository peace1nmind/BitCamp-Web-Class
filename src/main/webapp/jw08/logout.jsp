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
				<input type='button' value='회원가입' onclick="window.location.href='../jw07/addUser.html'">
				
		<% 	} else { %>
				<%= userVO.getId() %> 님 로그인 하셨습니다. <br/><br/>
				<form action="<%= request.getRequestURL() %>" method="post">
					URL : <%= request.getRequestURL() %> <br/>
					URI : <%= request.getRequestURI() %> <br/><br/>
					<input type='submit' value='Logout'>
				</form>
				<br/><br/>
				
		<%	} %>
		
		<%
			if (request.getMethod().equals("POST")) {
				
				// logout 방법 3가지
				
				// 1. session 종료
				//session.invalidate();
				
				// 2. session에서 userVO 제거
				session.removeAttribute("userVO");
				
				// 3. userVO의 active를 false로 변경
				//userVO.setActive(false);
				
				response.sendRedirect("logout.jsp");
			}
		%>
		
	</body>
</html>