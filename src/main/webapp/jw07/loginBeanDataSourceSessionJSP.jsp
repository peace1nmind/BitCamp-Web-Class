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
			System.out.println("Session�� ����� UserVO ���� : "+userVO);
			System.out.println();
			
			if (!(id==null || id.equals(""))) {
				userVO = new UserVO(id, pwd);
				
				UserDataSourceDao dao = new UserDataSourceDao();
				dao.getUser(userVO);
			}
		%>
			
		<h2>LoginBeanDataSourceSession Post ȭ��</h2>
		
		<%	if (userVO!=null && userVO.isActive()) { %>
				<%=	userVO.getId() %> �� ȯ���մϴ�.
				<%	session.setAttribute("userVO", userVO);
				
			} else { %>
				Login ���� id, pwd�� Ȯ���ϼ���
				
		<%	} %>
			
		<br><br>
		<input type='button' value='Home' onclick="window.location.href='../'" style='height: 30px'>
		&nbsp;&nbsp;&nbsp;
		<input type='button' value='�α���' 
			onclick="window.location.href='loginBeanDataSourceSessionJSP.html'" style='height: 30px'>
		
	</body>
</html>