import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletdoGet extends HttpServlet
{	

	public void service(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {

		System.out.println(":: servlet service() Ω√¿€");
		System.out.println(" Request Client IP : "+req.getRemoteAddr());
		
		res.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> hello Servlet </title>");
		out.println("</head>");
		
		out.println("English : HelloServlet");
		out.println("<p>");
		out.println("Korea : «Ô∑Œ º≠∫Ì∏¥");
		
		out.println("</body>");
		out.println("</html>");

		System.out.println(":: servlet service() ¡æ∑·\n");
		
	}// method end


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {
		
		System.out.println(":: servlet doGet() Ω√¿€");
		System.out.println(" Request Client IP : "+req.getRemoteAddr());
		
		res.setContentType("text/html;charset=EUC-KR");
		
//		OutputStream outputStream = res.getOutputStrema();
//		Writer writer = new OutputStreamWriter(outputStream);
//		PrintWriter out = new PrintWriter(writer);
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>  </title>");
		out.println("</head>");
		
		out.println("English : HelloServlet");
		out.println("<p>");
		out.println("Korea : «Ô∑Œ º≠∫Ì∏¥");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

		System.out.println(":: servlet doGet() ¡æ∑·\n");
		
	}// method end

}// class end
