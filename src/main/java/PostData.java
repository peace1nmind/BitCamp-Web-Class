import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class PostData extends HttpServlet
{	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {

		//  request 인코딩
		req.setCharacterEncoding("EUC_KR");
		
		// 한글처리
		res.setContentType("text/html;charset=EUC_KR");
//		PrintWriter out = new PrintWriter(new OutputStreamWriter(res.getOutputStream()));
		PrintWriter out = res.getWriter();

		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		System.out.println(clientName+" : "+clientAddr);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>  </title>");
		out.println("</head>");
		
		out.println("<h2>Get Test</h2>");
		out.println("<li> 이름 : "+clientName);
		out.println("<li> 주소 : "+clientAddr);

		out.println("<p><p><a href='/edu/postData.html'>뒤로</a>");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}// method end

}// class end
