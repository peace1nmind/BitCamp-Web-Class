import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletService extends HttpServlet
{	
	public void service(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {

		System.out.println(":: servlet service() ����");
		System.out.println(" Request Client IP : "+req.getRemoteAddr());
		
		res.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> hello Servlet </title>");
		out.println("</head>");
		
		out.println("English : HelloServlet");
		out.println("<p>");
		out.println("Korea : ��� ������");
		
		out.println("</body>");
		out.println("</html>");

		System.out.println(":: servlet service() ����\n");
		
	}// method end

}// class end
