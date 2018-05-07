<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("One");
	list.add("Two");
	list.add("Three");
	session.setAttribute("data1",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show ArrayList</title>
</head>
<body>

	ArrayListの中身は
	<br>${data1[0]}
	<br>${data1[1]}
	<br>${data1[2]}
	<br>です。

</body>
</html>