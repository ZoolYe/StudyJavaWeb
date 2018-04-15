<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    <font color="#ff1493">
        <%
            String data = (String) application.getAttribute("rd");
            out.write(data);
        %>
    </font>
</h1>

</body>
</html>
