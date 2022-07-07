<%--
  Created by IntelliJ IDEA.
  User: Герман
  Date: 11.06.2022
  Time: 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <form action="/reg" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="exampleInputEmail1" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail2" class="form-label">Username</label>
                    <input type="text " name="username" class="form-control" id="exampleInputEmail2" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Submit</button>
            </form>
            <c:if test="${requestScope.message!=null}">
                <div class="alert alert-danger" role="alert">
                    ${message}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
