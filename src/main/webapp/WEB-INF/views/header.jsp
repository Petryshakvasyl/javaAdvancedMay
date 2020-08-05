<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="margin-bottom: 15px">--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"--%>
<%--            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
<%--    <a class="navbar-brand" href="/">Money-b</a>--%>
<%--    <div class="collapse navbar-collapse">--%>
<%--        <ul class="navbar-nav mr-auto">--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="${contextPath}/transactions/list?type=INCOME">Income</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="${contextPath}/transactions/list?type=EXPENSE">Expense</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="${contextPath}/balance">Balance</a>--%>
<%--            </li>--%>

<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="${contextPath}/categories/list">Categories</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="margin-bottom: 15px">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">Money-b</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/transactions/list?type=INCOME&size=3"><spring:message
                        code="navbar.income"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/transactions/list?type=EXPENSE&size=3"><spring:message
                        code="navbar.expense"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextPath}/balance"><spring:message code="navbar.balance"/></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <spring:message code="change.language"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="?language=en">EN</a>
                    <a class="dropdown-item" href="?language=ua">UA</a>
                </div>
            </li>
        </ul>
        <sec:authorize access="isAuthenticated()">
            <a class="navbar-brand" rel="home" href="${contextPath}/profile" title="">
                <img style="max-width:70px; margin-top: -7px; border-radius:50%;"
                     src="${contextPath}/avatar">
            </a>
            <div class="navbar-text">
                <a class="navbar-text nav-link" href="/logout"><spring:message
                        code="navbar.logout"/></a>
            </div>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <div class="navbar-text">
                <a class="navbar-text nav-link" href="/login"><spring:message
                        code="navbar.login"/></a>
            </div>
        </sec:authorize>
    </div>
</nav>
