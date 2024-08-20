<%@ page contentType="text/html;charset=euc-kr" %>

<html>
<head>
	<title>04JSPActionInclude.jsp</title>
</head>
<body>

::  04JSPActionInclude.jsp ���� <br/><br/>

<%
	// Scriptlet tag ���� ���� :: service() Method  local variable
	String value = "local variable";

	// request,session,application  ObjectScope  Data ����
	request.setAttribute("aaa",new String("request ObjectScope ����� ���ڿ�"));
	session.setAttribute("bbb",new String("session ObjectScope ����� ���ڿ�"));
	application.setAttribute("ccc",new String("application ObjectScope ����� ���ڿ�"));
	request.setAttribute("value", value);
%>

<strong>Dynamic Include</strong>
<jsp:include  page="05JSPActionInclude.jsp"/>

<strong>Static Include</strong>
<%@ include file="./05JSPActionInclude.jsp" %>

::  04JSPActionInclude.jsp �� <br/>

</body>
</html>