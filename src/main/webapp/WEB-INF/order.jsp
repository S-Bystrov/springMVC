<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 06.03.2020
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.title}</td>
            <td>${order.price}</td>
            <td><a href="/delete/${order.id}">Delete this item</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add-new-order">Add new order</a>
</body>
</html>
