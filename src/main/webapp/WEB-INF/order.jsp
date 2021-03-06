<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 06.03.2020
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="orders.title"/></title>
</head>
<body>
<jsp:include page="./language.jsp"></jsp:include>
<table border="1" cellpadding="1" cellspacing="1" style="width: 500px">
    <caption><h4><spring:message code="orders.title"/></h4></caption>
    <tr>
        <th><spring:message code="orders.order"/></th>
        <th><spring:message code="orders.price"/></th>
        <th><spring:message code="orders.delete"/></th>
        <th><spring:message code="orders.update"/></th>
    </tr>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.title}</td>
            <td>${order.price}</td>
            <td><a href="/delete/${order.id}">Delete</a></td>
            <td><a href="/update/${order.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add-new-order"><spring:message code="orders.new"/></a>
</body>
</html>
