<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/25
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<a href="/testCookieValue">testCookieValue</a> <br>

<a href="/testModelAndView">testModelAndView</a> <br>

<a href="/testMap">testMap</a> <br>

<a href="/testSeesionAttributes">testSeesionAttributes</a> <br>

<form action="/testModelAttribute" method="post">
    <input type="hidden" name="id" value="1"/>
    username: <input type="text" name="username" value="Tom"/><br>
    email: <input type="text" name="email" value="Tom@qq.com"/><br>
    age: <input type="text" name="age" value="12"/><br>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
