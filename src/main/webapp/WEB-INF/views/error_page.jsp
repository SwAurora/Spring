<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ERROR PAGE</h1>
<h4>${ex.message}</h4>
<ul>
    <c:forEach items="${ex.getStackTrace()}" var="stack">
        <li>
            <c:out value="${stack}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>
