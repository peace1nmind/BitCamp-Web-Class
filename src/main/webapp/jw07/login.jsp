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
			System.out.println("������ UserVO : "+userVO);
			
			UserDao userDao = new UserDao();
			userDao.getUser(userVO);
		%>
			
		<h2>Login ȭ��</h2>
		
		<%	if (userVO.isActive()) { %>
				<%=	id %> �� ȯ���մϴ�.
				<%	session.setAttribute("userVO", userVO); %>
				
		<%	} else { %>
				Login ���� id, pwd�� Ȯ���ϼ���
				
		<%	} %>
			
		<br><br>
		
		<input type='button' value='Home' onclick="window.location.href='../'" style='height: 30px'>
		<input type='button' value='�ڷ�' onclick="window.location.href='login.html'" style='height: 30px'>
		&nbsp;&nbsp;&nbsp;
		<%	if (userVO.isActive()) { %>
			<input type='button' value='Logout' onclick="window.location.href='../jw08/logout.jsp'" style='height: 30px'>
			<input type='button' value='��ü ȸ������' onclick="window.location.href='../jw08/listUser.jsp'" style='height: 30px'>
		<%	} %>
	</body>
</html>