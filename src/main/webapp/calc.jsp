<%--
  Created by IntelliJ IDEA.
  User: Герман
  Date: 11.06.2022
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <form action="/calc" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Number1</label>
                    <input type="number" name="num1" class="form-control" id="exampleInputEmail1" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail2" class="form-label">Number2</label>
                    <input type="number" name="num2" class="form-control" id="exampleInputEmail2" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Operation</label>
                    <select name="operation" id="exampleInputPassword1" class="form-select" aria-label="Default select example">
                        <option>Open this select menu</option>
                        <option value="sum" selected>+</option>
                        <option value="diff">-</option>
                        <option value="mul">*</option>
                        <option value="div">/</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary w-100">Submit</button>
            </form>
            <c:if test="${requestScope.result!=null}">
                <div class="alert alert-danger" role="alert">
                    <p>Result = ${result} </p>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
