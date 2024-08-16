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
public class CookieWriterToClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieWriterToClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		// 같은 이름으로 value를 넣으면 덮어써진다
		Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동"));
//		Cookie cookie2 = new Cookie("name", URLEncoder.encode("이순신"));
		
		
		cookie.setMaxAge(60*60);
//		cookie.setMaxAge(-1);
//		cookie.setMaxAge(0);
		res.addCookie(cookie);
//		res.addCookie(cookie2);
		
		/* HTML */
		out.println("<html>");
		out.println("<head>");
		out.println("<title> CookieWriterToClient.java </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println(String.format("Cookie 저장 완료 : %s / %s", cookie.getName(), URLDecoder.decode(cookie.getValue())));
		out.println("<br>");
//		out.println(String.format("Cookie 저장 완료 : %s / %s", cookie2.getName(), URLDecoder.decode(cookie2.getValue())));
		
		out.println("<br><br><table><tr><td>");
		out.println("<input type='button' value='Home' "
				+ "onclick=\"window.location.href='./'\" style='height: 30px'>");
		out.println("&nbsp;&nbsp;&nbsp;<input type='button' value='쿠키확인' "
				+ "onclick=\"window.location.href='/edu/CookieReaderToServer'\" style='height: 30px'>");
		out.println("</td></tr></table>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}

}
