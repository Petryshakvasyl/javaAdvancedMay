<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create product</title>
</head>
<div class="center">
    <h3> Create product </h3>
    <form action="/admin/product" method="post">
        <div>
            <label>Name: </label>
            <input type="text" name="name">
        </div>
        <div>
            <label> Description: </label>
            <input type="text" name="description">
        </div>
        <div>
            <label>Price</label>
            <input name="price">
        </div>
        <div>
            <label>Count </label>
            <input type="number" name="count">
        </div>
        <input type="submit" value="Create">
    </form>
</div>
<body>
</html>