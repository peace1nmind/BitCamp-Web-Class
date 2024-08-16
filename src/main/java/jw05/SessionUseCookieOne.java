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
public class SessionUseCookieOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionUseCookieOne() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(true);
		
		if (session.isNew()) {
			session.setAttribute("name", "홍길동");
		}
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> SessionUseCookieOne.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='./'\" style='height: 30px'>");
		out.println("<br><br><input type='button' value='Session Home' "
				+ "onclick=\"window.location.href='./jw05/SeesionUseCookie.html'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='Session2' "
				+ "onclick=\"window.location.href='./SessionUseCookieTwo'\" style='height: 30px'>");
		out.println("<br><br><input type='button' value='Session 삭제' "
				+ "onclick=\"window.location.href='./SessionInvalidate'\" style='height: 30px'><br><br>");
		
		System.out.println("\n UNIQUE한 JSESSIONID = "+session.getId());;
		
		if (session.isNew()) {
			out.println("New Session<br>");
		} else {
			out.println("\n UNIQUE한 JSESSIONID = "+session.getId()+" 사용중");;
		}

		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}

}
