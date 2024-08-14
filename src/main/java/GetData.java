import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetData extends HttpServlet
{	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException,IOException {
				
		// 茄臂贸府
		res.setContentType("text/html;charset=EUC-KR");
		
//		OutputStream outputStream = res.getOutputStrema();
//		Writer writer = new OutputStreamWriter(outputStream);
//		PrintWriter out = new PrintWriter(writer);
		
		PrintWriter out = res.getWriter();

		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		System.out.println(clientName+" : "+clientAddr);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> GetData.java </title>");
		out.println("</head>");
		
		out.println("<h2>Get Test</h2>");
		out.println("<li> 捞抚 : "+clientName);
		out.println("<li> 林家 : "+clientAddr);

		out.println("<p><p><a href='/edu/getData.html'>第肺</a>");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
	}// method end

}// class end
