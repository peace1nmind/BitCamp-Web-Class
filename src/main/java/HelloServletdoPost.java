import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletdoPost extends HttpServlet
{	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {
		this.doPost(req, res);
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {

		System.out.println(":: servlet doPost() ����");
		System.out.println(" Request Client IP : "+req.getRemoteAddr());
		
		// �ѱ�ó��
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
		out.println("Korea : ��� ����");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

		System.out.println(":: servlet doPost() ����\n");
		
	}// method end

}// class end
