<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page</title>
</head>


<body>
<h1>Users</h1>
<c:forEach var="user" items="${requestScope.userList}">
    <ul>
        <li>Name: <c:out value="${user.name}"></c:out></li>
        <li>Age: <c:out value="${user.age}"></c:out></li>
        <li>Email: <c:out value="${user.email}"></c:out></li>

        <form method="post" action="/delete">
            <input type="number" hidden name="user" value="${user}"/>
            <input type="submit" value="Delete user"><br>
        </form>
    </ul>
    <hr/>
</c:forEach>

<h2>New User</h2>
<form method="get" action="/add">
    <input type="submit" value="Addition user in list"><br>
</form>

</body>
</html>

