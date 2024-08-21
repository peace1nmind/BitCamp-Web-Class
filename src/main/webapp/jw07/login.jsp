<%@page import="jw.service.user.dao.UserDao"%>
<%@page import="jw.service.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>login.jsp</title>
	</head>
	
	<body>
		<% 
			if (request.getMethod().equals("GET")) { %>
				<jsp:forward page="login.html"/>
		<%		
			}
		%>
		
		<%
			request.setCharacterEncoding("euc_kr");
			
			String id = request.getParameter("id").trim();
			String pwd = request.getParameter("pwd");
			
			//HttpSession session = request.getSession(true);
			
			UserVO userVO = new UserVO(id, pwd);
			System.out.println("생성된 UserVO : "+userVO);
			
			UserDao userDao = new UserDao();
			userDao.getUser(userVO);
		%>
			
		<h2>Login 화면</h2>
		
		<%	if (userVO.isActive()) { %>
				<%=	id %> 님 환영합니다.
				<%	session.setAttribute("userVO", userVO); %>
				
		<%	} else { %>
				Login 실패 id, pwd를 확인하세요
				
		<%	} %>
			
		<br><br>
		
		<input type='button' value='Home' onclick="window.location.href='../'" style='height: 30px'>
		<input type='button' value='뒤로' onclick="window.location.href='login.html'" style='height: 30px'>
		&nbsp;&nbsp;&nbsp;
		<%	if (userVO.isActive()) { %>
			<input type='button' value='Logout' onclick="window.location.href='../jw08/logout.jsp'" style='height: 30px'>
			<input type='button' value='전체 회원보기' onclick="window.location.href='../jw08/listUser.jsp'" style='height: 30px'>
		<%	} %>
	</body>
</html>