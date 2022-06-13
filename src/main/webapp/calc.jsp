<%--
  Created by IntelliJ IDEA.
  User: Герман
  Date: 11.06.2022
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
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
                                "                </li>"+
                                "                <li class=\"nav-item\">\n" +
                                "                    <a class=\"nav-link\" href=\"/findHistory\">My history</a>\n" +
                                "                </li>\n");
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
            <%
                if (request.getAttribute("result") != null) {
                    out.println("<div class=\"alert alert-primary\" role=\"alert\">\n" +
                            "        Result= " + request.getAttribute("result") + "\n" +
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
