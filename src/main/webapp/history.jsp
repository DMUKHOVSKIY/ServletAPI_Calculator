<%@ page import="tms.servlet.entity.Operation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Герман
  Date: 11.06.2022
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <ul class="list-group">
            <c:if test="${empty operations}">
                <div class="alert alert-danger" role="alert">
                    <p>There are no operations yet</p>
                </div>
            </c:if>

            <c:if test="${not empty operations}">
                <c:forEach items="${operations}" var="operation">
                    <li class="list-group-item">${operation}</li>
            </c:forEach>
            </c:if>
        </ul>
    </div>
</div>
</body>
</html>
