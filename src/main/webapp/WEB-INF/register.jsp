
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <%@include file="/WEB-INF/partials/head.jsp"%>
</head>
<body>
<%@include file="/WEB-INF/partials/navbar.jsp"%>
<div class="container">
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="form-control">
        </div>
        <button class="btn btn-primary">Register</button>
    </form>
</div>
</body>
</html>
