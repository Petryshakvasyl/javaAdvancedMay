<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<div class="container-sm">
    <div class="card mx-auto" style="width: 23rem;">
        <div class="card-body">
            <h4>
                <div class="card-title text-center">Sign Up</div>
            </h4>
            <div class="card-text">
                <form action="registration" method="post">
                    <div class="form-group">
                        <input type="text" name="firstName" class="form-control" placeholder="First name">
                    </div>
                    <div class="form-group">
                        <input type="text" name="lastName" class="form-control" placeholder="Last name">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-secondary btn-block">Sign Up</button>
                    </div>
                </form>
                <div><a href="/login">Back to log in</a></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

