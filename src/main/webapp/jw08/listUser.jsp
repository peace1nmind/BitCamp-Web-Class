<%@page import="jw.service.user.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="jw.service.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>listUser.jsp</title>
	</head>
	
	<body>
		
		<%
			UserVO usrVO = (UserVO) session.getAttribute("userVO");
			
			if (usrVO == null) {
				usrVO = new UserVO();
			}
		%>
		
		<%	if (!usrVO.isActive()) { %>
			<jsp:include page="../jw07/login.html"/>
			<br/><br/>
			<input type='button' value='ȸ������' onclick="window.location.href='../jw07/addUser.html'">
			
		<%	
			} else { 
				List<UserVO> userList = new UserDao().getUserList();
		%>
				<center><h1>ȸ�� ��ü ���</h1></center>
				
				<center>
					<table border="1" cellspacing="0" cellpadding="5">
					
						<tr style="background-color: #828282; color: #FFFFFF;">
							<th>��ȣ</th>
							<th>���̵�</th>
							<th>��й�ȣ</th>
						</tr>
				<%	for (UserVO userVO : userList) { %>
						<tr>
							<td><%= userVO.getNo() %></td>
							<td><%= userVO.getId() %></td>
							<td><%= userVO.getPwd() %></td>
						</tr>
				<%	}  %>
				
					</table>
				</center>
		<%	} %>
	</body>
</html>