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
public class LoginBeanVODao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginBeanVODao() {
        super();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("euc_kr");
		res.setContentType("text/html;charset=euc_kr");
		PrintWriter out = res.getWriter();	
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		UserVO userVO = new UserVO(id, pwd);
		UserDao userDao = new UserDao();
		userDao.getUser(userVO);
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title>  </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>Login ȭ��</h2>");
		
		if (userVO.isActive()) {
			out.println(id+"�� ȯ���մϴ�.");
		} else {
			out.println("Login ���� id, pwd�� Ȯ���ϼ���");
		}
		
		out.println("<p><p><a href='/BitCamp_Class_Web/jw04/loginBeanVODao.html'>�ڷ�</a>");
		out.println("<br><br><input type='button' value='�ڷΰ���' onclick='history.back()'>");
		out.println("<br><br><input type='button' value='Home' "
				+ "onclick=\"window.location.href='/BitCamp_Class_Web/'\">");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

	}// service end

}// class end
