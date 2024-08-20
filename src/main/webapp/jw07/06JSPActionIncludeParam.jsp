<%@ page contentType="text/html;charset=euc-kr" %>

<html>
<head>
	<title>06JSPActionIncludeParam.jsp</title>
</head>
<body>

::  06JSPActionIncludeParam.jsp ���� <br/><br/>

<%
	// Scriptlet tag ���� ���� :: service() Method  local variable
	String value = "local variable";

	// request,session,application  ObjectScope  Data ����
	request.setAttribute("aaa",new String("request ObjectScope ����� ���ڿ�"));
	session.setAttribute("bbb",new String("session ObjectScope ����� ���ڿ�"));
	application.setAttribute("ccc",new String("application ObjectScope ����� ���ڿ�"));
%>

<strong>Dynamic Include</strong>
 
<jsp:include  page="07JSPActionIncludeParam.jsp">
	<jsp:param value="<%= value %>" name="str"/>
</jsp:include>

<strong>Static Include</strong>
<%@ include file="./07JSPActionIncludeParam.jsp" %>

::  06JSPActionIncludeParam.jsp �� <br/>

</body>
</html>