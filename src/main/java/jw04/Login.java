package jw04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("euc_kr");
		res.setContentType("text/html;charset=euc_kr");
		PrintWriter out = res.getWriter();	
		
		
		/* DB */
		String id= req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
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
				
				System.out.println("db���� Ȯ�� �� id, pwd = "+fromDbId+" : "+fromDbPwd);
			} else {
				System.out.println(String.format("db�� cliend�� �Է��� <%s>�� <%s>�� �����ϴ�.", id, pwd));
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
		
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title>  </title>");
		out.println("</head>");
		
		if (fromDbId != null && fromDbPwd != null 
				&& fromDbId.equals(id) && fromDbPwd.equals(pwd)) {
			
			out.println(id+"�� ȯ���մϴ�");
			
		} else {
			
			out.println("id, pwd �� Ȯ���ϼ���.");
			
		}
		
		out.println("<p><p><a href='/BitCamp_Class_Web/jw04/login.html'>�ڷ�</a>");
		out.println("<br><br><input type='button' value='�ڷΰ���' onclick='history.back()'>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

		
	}// service end

}
