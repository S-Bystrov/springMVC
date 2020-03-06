<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 06.03.2020
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add-new-order" method="POST">
    <label>Title</label>
    <input type="text" name="title">
    <label>Price</label>
    <input type="text" name="price">
    <input type="submit" value="Add new order">
</form>
</body>
</html>
