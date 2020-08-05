<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="header.jsp"/>

<div class="container p-2">
    Profile Data:
    ${user.firstName}
</div>

<div class="container p-2">
    <form method="POST" action="${contextPath}/avatar" enctype="multipart/form-data">
        <div class="form-group">
            <label for="file">Choose avatar</label>
            <input type="file" class="form-control-file" id="file">
        </div>
        <div class="form-group">
            <input type="submit" value="Submit" class="form-control"/>
        </div>
    </form>
</div>

