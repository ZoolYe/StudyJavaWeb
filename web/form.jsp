<%--
  Created by IntelliJ IDEA.
  User: ZOOL
  Date: 2018/5/5
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/dofrom">
        <input type="hidden" name="token" value="${token}">
        用户名：<input type="text" name="username">
        <input type="submit" value="提交">
    </form>

</body>
</html>
