<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.util.*" %>

<%@ page language="java" %>
<%@ page info="처음 작성하는 JSP" %>

<%@ page session="true" %>
<%@ page isThreadSafe="true" %>

<%--
	<%@ page extends="java.util.Vector" >
--%>

<%
	String value = "지역변수";
	System.out.println(":: "+value);

	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH)+1;
	int day = calendar.get(Calendar.DATE);
	
	System.out.println(":: "+year+"년"+month+"월"+day+"일");

	String info = getServletInfo();
	System.out.println(":: informaiton : "+info);
%>

<html>
	<head>
		<title>01JSPDirectivePageTest01.jsp</title>
	</head>
	
	<body>
	
		안녕하세요 html 시작 <br/>
		<%= ":: "+value %> <br/>
		<%= ":: "+year+"년"+month+"월"+day+"일" %> <br/>
		<%= ":: informaiton : "+info %> <br/>
		<hr/>
		안녕하세요 html 끝 <br/>
		
	</body>
</html>