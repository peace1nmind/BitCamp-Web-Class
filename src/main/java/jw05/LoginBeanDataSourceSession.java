package jw05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jw04.UserDataSourceDao;
import jw04.UserVO;


//@WebServlet("/Login")
public class LoginBeanDataSourceSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Field
    
	// Construct
    public LoginBeanDataSourceSession() {
        super();
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("euc_kr");
		res.setContentType("text/html;charset=euc_kr");
		PrintWriter out = res.getWriter();	
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		HttpSession session = req.getSession(false);
		
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		System.out.println("Session에 저장된 UserVO 유무 : "+userVO);
		System.out.println();
		
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> LoginBeanDataSourceSession.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>LoginBeanDataSourceSession Get 화면</h2>");
		
		if (userVO!=null && userVO.isActive()) {
			out.println(userVO.getId()+"님 환영합니다.");
			session.setAttribute("userVO", userVO);
			
		} else {
			out.println("Login 된 아이디가 없습니다");
			
		}
		
		out.println("<br><br>");
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='/edu/'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='로그인' onclick=\"window.location.href='./jw05/loginBeanDataSourceSession.html'\" style='height: 30px'>");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("euc_kr");
		res.setContentType("text/html;charset=euc_kr");
		PrintWriter out = res.getWriter();	
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		HttpSession session = req.getSession(true);
		
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		System.out.println("Session에 저장된 UserVO 유무 : "+userVO);
		System.out.println();
		
		if (!(id==null || id.equals(""))) {
			userVO = new UserVO(id, pwd);
			
			UserDataSourceDao dao = new UserDataSourceDao();
			dao.getUser(userVO);
		}
		
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> LoginBeanDataSourceSession.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h2>LoginBeanDataSourceSession Post 화면</h2>");
		
		if (userVO!=null && userVO.isActive()) {
			out.println(userVO.getId()+"님 환영합니다.");
			session.setAttribute("userVO", userVO);
			
		} else {
			out.println("Login 실패 id, pwd를 확인하세요");
			
		}
		
		out.println("<br><br>");
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='/edu/'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='로그인' onclick=\"window.location.href='./jw05/loginBeanDataSourceSession.html'\" style='height: 30px'>");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

	}// service end

}// class end
