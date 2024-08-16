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

//@WebServlet("/CookieWriterToClient")
public class CookieReaderToServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieReaderToServer() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		// Client로부터 Cookie받기
		Cookie[] cookies = req.getCookies();
		String userName = null;
		
//		System.out.println(cookies);
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> CookieReaderToServer.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		if (cookies!=null) {
			out.println("Client에서 전송된 Cookie 있습니다.<br><br>");
			
			for (Cookie cookie : cookies) {
				System.out.println("Client로 부터 전송된 cookie : "+cookie.getName()+" = "+URLDecoder.decode(cookie.getValue()));
				
				if (cookie.getName().equals("name")) {
					userName = URLDecoder.decode(cookie.getValue());
				}
			}
			
		}else {
			out.println("Client에서 전송된 Cookie 없습니다.>br>");
		}
		
		if (userName==null) {
			out.println("처음입니다");
		}else {
			out.println(userName+"님 환영합니다.");
		}
		
		out.println("<br><br><table><tr><td>");
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='./'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='쿠키생성' "
				+ "onclick=\"window.location.href='/edu/CookieWriterToClient'\" style='height: 30px'>");
		out.println("</td></tr></table>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}

}
