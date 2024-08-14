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
public class LoginBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginBean() {
        super();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("euc_kr");
		res.setContentType("text/html;charset=euc_kr");
		PrintWriter out = res.getWriter();	
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		DbBean dbBean = new DbBean();
		dbBean.setId(id);
		dbBean.setPwd(pwd);
		
		boolean isLogin = dbBean.getUser();
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title>  </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>Login 화면</h2>");
		
		if (isLogin) {
			out.println(id+"님 환영합니다.");
		} else {
			out.println("Login 실패 id, pwd를 확인하세요");
		}
		
		
		
		out.println("<p><p><a href='/BitCamp_Class_Web/jw04/loginBean.html'>뒤로</a>");
		out.println("<br><br><input type='button' value='뒤로가기' onclick='history.back()'>");
		out.println("<br><br><input type='button' value='Home' "
				+ "onclick=\"window.location.href='/BitCamp_Class_Web/'\">");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

		
	}// service end

}
