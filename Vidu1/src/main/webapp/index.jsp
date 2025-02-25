<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<%= new Date().toString()%>
<%
  int x;
  x = 5;
  int y = x+99;
%>
<hr>
<%= y %>
<hr>
<%
  out.print(y);
%>
</body>
</html>