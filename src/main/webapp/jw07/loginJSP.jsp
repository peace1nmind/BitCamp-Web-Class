<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title> loginJSP.jsp </title>
	</head>
	
	<body>
		
		<%
			request.setCharacterEncoding("euc_kr");
			//response.setContentType("text/html;charset=euc_kr");
			//PrintWriter out = response.getWriter();	
			
			
			/* DB */
			String id= request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			String fromDbId = null;
			String fromDbPwd = null;
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// DB Conn, PreparedStatement Open
			try {
				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
				Class.forName(driver);
		
				String sql = "SELECT id, pwd FROM users WHERE id=?";
		
				con = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					fromDbId = rs.getString("id");
					fromDbPwd = rs.getString("pwd");
					
					System.out.println("db에서 확인 한 id, pwd = "+fromDbId+" : "+fromDbPwd);
				} else {
					System.out.println(String.format("db에 cliend가 입력한 <%s>와 <%s>가 없습니다.", id, pwd));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					// DB Conn, PreparedStatement Close
					if (rs!=null) {
						rs.close();
					}
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
		%>
		
		
		
		<% if (fromDbId != null && fromDbPwd != null 
				&& fromDbId.equals(id) && fromDbPwd.equals(pwd)) { %>
			
			<%= id %> 님 환영합니다
			
		<% } else { %>
			
			id, pwd 를 확인하세요.
			
		<% } %>
		
		<p><p><a href='./loginJSP.html'>뒤로</a>
		<br><br><input type='button' value='뒤로가기' onclick="window.location.href='./loginJSP.html'">
			
	</body>
</html>