<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
</head>
<jsp:include page="header.jsp"/>
<div class="container">
    <h3> Create product </h3>
    <form action="/admin/product" method="post">
       <div class="row">
           <div class="col form-group">
               <label>Name: </label>
               <input class="form-control" type="text" name="name">
               <div class="invalid-feedback">
                   Please provide a valid city.
               </div>
           </div>
           <div class="col form-group">
               <label> Description: </label>
               <input class="form-control" type="text" name="description">
           </div>
       </div>
        <div class="form-group">
            <label>Price</label>
            <input class="form-control" name="price">
        </div>
        <div class="form-group">
            <label>Count </label>
            <input class="form-control" type="number" name="count">
        </div>
        <input type="submit" value="Create">
    </form>
</div>
<body>
</html>