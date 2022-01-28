<%@ page import="kz.mun.m2.model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="bg-white mb-3 p-2">
    <%
        Author currentAuthor = (Author) session.getAttribute("CURRENT_AUTHOR");
        if (currentAuthor != null) {
    %>
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link text-dark" href="#">Все блоги</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-dark" href="#" data-bs-toggle="modal" data-bs-target="#addNewBlog">Добавить блог</a>
        </li>
        <div class="ms-auto d-flex">
            <li class="nav-item">
                <a class="nav-link text-dark" href="#"><%=currentAuthor.getName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-dark" href="/logout">Выйти</a>
            </li>
        </div>
    </ul>
    <%
        } else {
    %>
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link text-dark" href="/main">Все блоги</a>
        </li>
        <li class="nav-item ms-auto">
            <a class="nav-link text-dark" href="/login">Войти</a>
        </li>
    </ul>
    <%
        }
    %>
</header>

<!-- Modal add new Blog -->
<div class="modal fade" id="addNewBlog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Написать блог</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/add-blog" method="post">
                    <div class="mb-3">
                        <label for="blogTitle" class="form-label">Наименование</label>
                        <input type="text" class="form-control" id="blogTitle" name="blogTitle">
                    </div>
                    <div class="mb-3">
                        <label for="blogContent" class="form-label">Текст</label>
                        <textarea name="blogContent" id="" cols="30" rows="10" id="blogContent"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Добавить блог</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
