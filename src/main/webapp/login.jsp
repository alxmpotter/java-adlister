<%--
  Created by IntelliJ IDEA.
  User: alexpotter
  Date: 10/17/17
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="partials/style.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp" %>

<form method="Post" action="/login.jsp">

    <label for="username">username</label>
    <input id="username" name="username" type="text">
    <br>

    <label for="password">Password</label>
    <input id="password" name="password" type="paswword">
    <br>

    <input type="Submit">

</form>


<c:choose>
    <c:when test="${ param.username.equals('admin')&& param.password.equals('password') }">
       <% response.sendRedirect("/profile.jsp"); %>
    </c:when>

</c:choose>

<%@include file="partials/scripts.jsp"%>

</body>
</html>
