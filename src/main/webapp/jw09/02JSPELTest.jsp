<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.util.*" %>

<%
	//pageContext.setAttribute("aaa", "page ObjectScope ����");
	
	//request.setAttribute("aaa", "request ObjectScope ����");
	
	session.setAttribute("aaa", new ArrayList());
	
	ArrayList arrayList = new ArrayList();
	arrayList.add("arrayList ����");
	session.setAttribute("def", arrayList);
	
	HashMap hashMap = new HashMap();
	hashMap.put("zzz", "hashMap ����");
	application.setAttribute("map", hashMap);
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>02 JSP EL Test</title>
	</head>
	
	<body>
		
		sessionScope.def[0] = ${sessionScope.def[0] }<br>
		applicationScope.abc.zzz = ${applicationScope.abc.zzz }<br>
		
		<br>
		
		aaa = ${aaa }<br>
		aaa.size() = ${aaa.size()}<br>
		empty aaa = ${empty aaa}<br>
		def= ${def }<br>
		def[0] = ${def[0] }<br>
		map.zzz = ${map.zzz }<br>
		map = ${map }<br>
		map.size() = ${map.size() }<br>
		map.zzz.length() = ${map.zzz.length() }<br>
		
	</body>
</html>