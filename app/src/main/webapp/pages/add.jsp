<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page</title>
</head>


<body>
<h2>New User</h2>
<form method="post" action="/add">
    <label><input type="text" name="name"></label>Name<br>
    <label><input type="number" name="age"></label>Age<br>
    <label><input type="text" name="email"></label>Email<br>
    <input type="submit" value="Ok"><br>
</form>
</body>
</html>