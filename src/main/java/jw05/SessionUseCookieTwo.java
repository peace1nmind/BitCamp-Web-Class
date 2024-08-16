package jw05;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/SessionUseCookieOne")
public class SessionUseCookieTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionUseCookieTwo() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		Cookie[] cookies = req.getCookies();
		
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				System.out.print("\nCookie에 저장된 정보 : ");
				System.out.println(cookie.getName()+" = "+cookie.getValue());
				System.out.println();
			}
		} else {
			System.out.println("\nCookie에 저장된 정보 : Null");
		}
		
		HttpSession session = req.getSession(false);
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> SessionUseCookieTwo.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='./'\" style='height: 30px'>");
		out.println("<br><br><input type='button' value='Session Home' "
				+ "onclick=\"window.location.href='./jw05/SeesionUseCookie.html'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='Session 1' "
				+ "onclick=\"window.location.href='./SessionUseCookieOne'\" style='height: 30px'>");
		out.println("<br><br><input type='button' value='Session 삭제' "
				+ "onclick=\"window.location.href='./SessionInvalidate'\" style='height: 30px'><br><br>");
		
		if (session != null) {
			out.println("<hr> JSESSIONID = "+session.getId()+"<hr>");
			String name = (String) session.getAttribute("name");
			out.println("이름 : "+name);
		} else {
			out.println("처음이십니다.");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}

}
