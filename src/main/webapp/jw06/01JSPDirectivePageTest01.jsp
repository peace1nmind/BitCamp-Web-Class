<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.util.*" %>

<%@ page language="java" %>
<%@ page info="ó�� �ۼ��ϴ� JSP" %>

<%@ page session="true" %>
<%@ page isThreadSafe="true" %>

<%--
	<%@ page extends="java.util.Vector" >
--%>

<%
	String value = "��������";
	System.out.println(":: "+value);

	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH)+1;
	int day = calendar.get(Calendar.DATE);
	
	System.out.println(":: "+year+"��"+month+"��"+day+"��");

	String info = getServletInfo();
	System.out.println(":: informaiton : "+info);
%>

<html>
	<head>
		<title>01JSPDirectivePageTest01.jsp</title>
	</head>
	
	<body>
	
		�ȳ��ϼ��� html ���� <br/>
		<%= ":: "+value %> <br/>
		<%= ":: "+year+"��"+month+"��"+day+"��" %> <br/>
		<%= ":: informaiton : "+info %> <br/>
		<hr/>
		�ȳ��ϼ��� html �� <br/>
		
	</body>
</html>