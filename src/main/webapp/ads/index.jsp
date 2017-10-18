<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />

<c:forEach var = "ad" items="${ads}">
    <div>
        <h3>${ad.title}</h3>
        <p>${ad.description}</p>
    </div>
</c:forEach>

</body>
</html>
