<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Products</title>
    <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"></script>
    <script src="/resources/js/product-list.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="row">
    <div class="col-2"></div>
    <div class="col">
        <div class="row">
            <c:forEach items="${products}" var="product">
                <div class="col-sm-3">
                    <div class="card">
                        <img class="card-img-top" src="resources/img/img.png" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <p class="card-text">${product.price}</p>
                            <button class="btn btn-secondary btn-block" onclick="buyNow(${product.id})">Buy now</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>

