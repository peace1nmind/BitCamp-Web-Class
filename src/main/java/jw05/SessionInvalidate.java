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
public class SessionInvalidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionInvalidate() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(false);
		
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> SessionInvalidate.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='./'\" style='height: 30px'>");
		out.println("<br><br><input type='button' value='Session Home' "
				+ "onclick=\"window.location.href='./jw05/SeesionUseCookie.html'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='Session1' "
				+ "onclick=\"window.location.href='./SessionUseCookieOne'\" style='height: 30px'>");
		out.println("<input type='button' value='Session2' "
				+ "onclick=\"window.location.href='./SessionUseCookieTwo'\" style='height: 30px'><br><br>");
		
		if (session==null) {
			out.println("지울 Session이 없습니다.");
		} else {
			session.invalidate();
			out.println("Session을 삭제했습니다.");
		}

		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}

}
