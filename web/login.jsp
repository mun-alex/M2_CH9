<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container">
    <%@include file="header.jsp"%>

    <div class="row">
        <div class="col-lg-5 mt-5 m-auto">
            <form action="/login" method="post">
                <h3 class="text-white">Вход</h3>
                <%
                    if (request.getParameter("emailError") != null) {
                %>
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Such Email does not exist!
                    </div>
                </div>
                <%
                    }
                %>

                <%
                    if (request.getParameter("passwordError") != null) {
                %>
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Password is wrong!
                    </div>
                </div>
                <%
                    }
                %>
                <div class="mb-3">
                    <label for="authorEmail" class="form-label text-white">Email:</label>
                    <input type="text" class="form-control" name="authorEmail" id="authorEmail">
                </div>
                <div class="mb-3">
                    <label for="authorPassword" class="form-label text-white">Пароль:</label>
                    <input type="password" class="form-control" name="authorPassword" id="authorPassword">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Войти</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
