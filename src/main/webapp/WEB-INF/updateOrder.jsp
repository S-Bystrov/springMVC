<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 06.03.2020
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="update.title"/></title>
</head>
<body>
<jsp:include page="./language.jsp"></jsp:include>
<caption><h4><spring:message code="update.title"/></h4></caption>
<form action="/update/${id}" method="POST">
    <label><spring:message code="orders.order"/></label>
    <input type="text" name="title" minlength="1">
    <label><spring:message code="orders.price"/></label>
    <input type="number" name="price" minlength="1">
    <input type="submit" value="Ok">
</form>
</body>
</html>
