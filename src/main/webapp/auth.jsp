<%--
  Created by IntelliJ IDEA.
  User: Герман
  Date: 11.06.2022
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    if (session.getAttribute("currentUser") == null) {
                        out.println(" <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"/reg\">Registration</a>\n" +
                                "                </li>\n" +
                                "                <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"/auth\">Authorization</a>\n" +
                                "                </li>");
                    } else {
                        out.println("  <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"/calc\">Calculator</a>\n" +
                                "                </li>\n" +
                                "                <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"/logout\"\n" +
                                "                    >Logout</a>\n" +
                                "                </li>");
                    }
                %>

            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
            <form action="/auth" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail2" class="form-label">Username</label>
                    <input name="username" type="text " class="form-control" id="exampleInputEmail2">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary w-100">Submit</button>
            </form>
            <%
                if (request.getAttribute("message") != null) {
                    out.println("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                            "      " + request.getAttribute("message") + "\n" +
                            "      </div>");
                }
            %>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</html>
