import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class PostData extends HttpServlet
{	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {

		//  request ���ڵ�
		req.setCharacterEncoding("EUC_KR");
		
		// �ѱ�ó��
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
		out.println("<li> �̸� : "+clientName);
		out.println("<li> �ּ� : "+clientAddr);

		out.println("<p><p><a href='/edu/postData.html'>�ڷ�</a>");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}// method end

}// class end
