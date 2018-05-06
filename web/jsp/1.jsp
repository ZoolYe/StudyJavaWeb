<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ZOOL
  Date: 2018/5/6
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp入门(输出时间)</title>
</head>
<body>

    <%
        Date date = new Date();
        String time = date.toLocaleString();
    %>

    <%--脚本表达式，它的作用就是用于向浏览器输出数据--%>
    <%=time %>

</body>
</html>
