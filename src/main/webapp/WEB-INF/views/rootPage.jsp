<%--
  Created by IntelliJ IDEA.
  User: juse
  Date: 18.01.2018
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${contextPath}/resources/css/rootPage.css" rel="stylesheet">
</head>
<body>
    <form>
        <input type="button" onclick='location.href="http://localhost:8080/panel/client/"' value="Перейти к списку пользователей" class="btn-primary" style="location:absolute; right:100px;left:100px;">
        <input type="button" onclick='location.href="http://localhost:8080/panel/#"' value="Перейти к списку заказов" class="btn-primary" style="location:absolute; right:250px;left:100px;">
        <input type="button" onclick='location.href="http://localhost:8080/panel/#"' value="Перейти к списку товаров" class="btn-primary" style="location:absolute; right:400px;left:100px;">
    </form>
</body>
</html>
