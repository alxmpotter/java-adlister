<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
