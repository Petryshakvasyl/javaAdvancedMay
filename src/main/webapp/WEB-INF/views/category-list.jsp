<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="header.jsp"/>

<div class="container p-4 my-2 border">
    <ul>
        <c:forEach items="${categories}" var="category">
            <li>${category.name}</li>
        </c:forEach>
    </ul>
</div>

</body>
</html>

