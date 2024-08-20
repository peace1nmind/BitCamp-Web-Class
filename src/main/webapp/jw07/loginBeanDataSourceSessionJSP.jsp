<%@page import="jw04.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>loginBeanDataSourceSessionJSP.jsp</title>
	</head>
	
	<body>
		
		<%
			request.setCharacterEncoding("euc_kr");
			//response.setContentType("text/html;charset=euc_kr");
			//PrintWriter out = response.getWriter();
			
			session = request.getSession((request.getMethod().equals("POST"))? true : false);
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			//HttpSession session = request.getSession(true);
			
			UserVO userVO = (UserVO) session.getAttribute("userVO");
			System.out.println("Session에 저장된 UserVO 유무 : "+userVO);
			System.out.println();
			
			if (!(id==null || id.equals(""))) {
				userVO = new UserVO(id, pwd);
				
				UserDataSourceDao dao = new UserDataSourceDao();
				dao.getUser(userVO);
			}
		%>
			
		<h2>LoginBeanDataSourceSession Post 화면</h2>
		
		<%	if (userVO!=null && userVO.isActive()) { %>
				<%=	userVO.getId() %> 님 환영합니다.
				<%	session.setAttribute("userVO", userVO);
				
			} else { %>
				Login 실패 id, pwd를 확인하세요
				
		<%	} %>
			
		<br><br>
		<input type='button' value='Home' onclick="window.location.href='../'" style='height: 30px'>
		&nbsp;&nbsp;&nbsp;
		<input type='button' value='로그인' 
			onclick="window.location.href='loginBeanDataSourceSessionJSP.html'" style='height: 30px'>
		
	</body>
</html>