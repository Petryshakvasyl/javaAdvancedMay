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
        <input class="btn btn-primary" type="submit" value="Create">
    </form>
</div>
<body>
</html>