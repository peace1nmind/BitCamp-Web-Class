<%@ page contentType="text/html;charset=euc-kr" %>

<html>
<head>
	<title>06JSPActionIncludeParam.jsp</title>
</head>
<body>

::  06JSPActionIncludeParam.jsp 시작 <br/><br/>

<%
	// Scriptlet tag 변수 선언 :: service() Method  local variable
	String value = "local variable";

	// request,session,application  ObjectScope  Data 저장
	request.setAttribute("aaa",new String("request ObjectScope 저장된 문자열"));
	session.setAttribute("bbb",new String("session ObjectScope 저장된 문자열"));
	application.setAttribute("ccc",new String("application ObjectScope 저장된 문자열"));
%>

<strong>Dynamic Include</strong>
 
<jsp:include  page="07JSPActionIncludeParam.jsp">
	<jsp:param value="<%= value %>" name="str"/>
</jsp:include>

<strong>Static Include</strong>
<%@ include file="./07JSPActionIncludeParam.jsp" %>

::  06JSPActionIncludeParam.jsp 끝 <br/>

</body>
</html>