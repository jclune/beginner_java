<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="UserDao.*" %>
<!--taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  -->

<% String ft = (String) request.getAttribute("form_test"); %>
<% String t = (String) request.getAttribute("test"); %>
<% String st = (String) session.getAttribute("test"); %>
<% User u = (User) session.getAttribute("user"); %>
<% String welcome = null; %>
<% if (u != null){ %>
<% 		if (u.getName() == null){ %>
<% 			welcome = "Login error"; %>
<% 		} else {%>
<% 			welcome = "Welcome "+ u.getName() + "!"; %>
<% 		} %>
<%	} else { welcome = "Sorry, wrong email or password"; %>
<% }%>

<html>
<head>
  <meta charset="utf-8" />
  <title>計算結果</title>
</head>
<body>
<h2><%=welcome %>!</h2>
<br>
<h2>User Table</h2>
</body>
</html>