<%-- 
    Document   : allusers.jsp
    Created on : 9 d’oct. 2019, 18:03:26
    Author     : gabalca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users</title>
    </head>
    <body>
        <h1>Tots els usuaris</h1>
        <ul>
            <c:forEach items="${requestScope.users}" var="currentUser">
                <li><c:out value="${currentUser.username}"/></li>
            </c:forEach>
        </ul>
    </body>
</html>
