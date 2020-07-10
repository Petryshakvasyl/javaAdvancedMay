<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="header.jsp"/>

<div class="container p-4 my-2 border">
    <ul>
       <li> Name: ${category.name}</li>
       <li> type: ${category.type}</li>
    </ul>
</div>

</body>
</html>

