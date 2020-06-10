<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h2>Message: ${message}</h2>

<form action="registration" method="post">

    <label for="firstName">First Name :</label> <input name="firstName">
    <br>
    <label for="lastName">Last Name :</label> <input name="lastName">
    <br>
    <label for="email">Email :</label> <input name="email">
    <br>
    <label for="password">Password : </label> <input name="password">
    <br>
    <input type="submit" value="submit">
</form>

</body>
</html>