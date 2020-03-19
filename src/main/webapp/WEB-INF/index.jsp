<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 20.03.2020
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"  %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<jsp:include page="./language.jsp"></jsp:include>
<h3>
    <security:authorize access="isAnonymous()"><spring:message code="index.title"/></security:authorize>
    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username"/>
    </security:authorize>
</h3>
<security:authorize access="isAnonymous()">
    Login as <a href="user">User</a> or <a href="/admin">Admin</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
    <security:authorize access="hasRole('USER')">
        <a href="user">My Profile</a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a href="admin">My Profile</a>
    </security:authorize>
    <a href="logout">Logout</a>
</security:authorize>

</body>
</html>
