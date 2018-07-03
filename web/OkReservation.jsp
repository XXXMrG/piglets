<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/7/3
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建预约成功</title>
</head>
<body>

<%
    String T_id = (String) session.getAttribute("T_id");
    String R_id = (String) session.getAttribute("R_id");
%>

<p align="center">新预约顾客的预约号：<%= R_id%></p>
<p align="center">新预约顾客的餐桌号：<%= T_id%></p>

</body>
</html>
