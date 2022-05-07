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
    </ul>
    <hr/>
</c:forEach>

<h2>New User</h2>
<form method="post" action="/home">
    <label><input type="text" name="name"></label>Name<br>
    <label><input type="number" name="age"></label>Age<br>
    <label><input type="text" name="email"></label>Email<br>
    <input type="submit" value="Ok"><br>
</form>

</body>
</html>

