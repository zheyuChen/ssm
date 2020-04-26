<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/26
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success page</title>
</head>
<body>

time : ${requestScope.time} <br>
names : ${requestScope.name} <br>
request user : ${requestScope.user} <br>
session user : ${sessionScope.user} <br>

</body>
</html>
