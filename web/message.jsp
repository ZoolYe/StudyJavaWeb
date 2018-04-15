<%--
  Created by IntelliJ IDEA.
  User: ZOOL
  Date: 2018/4/15
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This Message Page</title>
</head>
<body>

<h1>
    <%
        String message = (String) application.getAttribute("message");
        out.write(message);
    %>
</h1>


</body>
</html>
