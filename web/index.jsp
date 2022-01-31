<!DOCTYPE HTML>
<%@ page import="java.util.List" %>
<%@ page import="kz.mun.m2.model.Blog" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.mun.m2.db.DBManager" %>
<%@ page import="kz.mun.m2.model.Comment" %><%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 27.01.2022
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body>
<div class="container">
    <%@include file="header.jsp" %>
    <%
        List<Blog> blogs = (ArrayList) request.getAttribute("blogs");
    %>
    <div class="row">
        <div class="col-lg-8">
            <%
                for (Blog blog : blogs) {
            %>
            <div class="blog-item bg-white p-3 mb-3">
                <h3><%=blog.getTitle()%>
                </h3>
                <p><%=blog.getContent()%>
                </p>
                <p class="fw-bold">автор: <%=DBManager.authorNameByBlogId(blog.getId())%>
                </p>
<%--                <a href="/comments?blogId=<%=blog.getId()%>">Комментарии</a>--%>
                <a id="getCommentsButton" href="javascript:void(0)" onclick="getAllCommentsByBlogId(<%=blog.getId()%>)">Комментарии</a>

<%--                <%--%>
<%--                    if (request.getAttribute("comments") != null) {--%>
<%--                        ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");--%>
<%--                        for (Comment comment : comments) {--%>
<%--                            if (blog.getId() == comment.getBlogId()) {--%>
<%--                %>--%>
<%--                <p><%=comment.getComment()%>--%>
<%--                </p>--%>
<%--                <%--%>
<%--                            }--%>
<%--                        }--%>
<%--                    }--%>
<%--                %>--%>
            </div>
            <%
                }
            %>
        </div>
        <div class="col-lg-4">
            <%
                for (Blog blog : blogs) {
            %>
            <div class="blog-item bg-white p-3">
                <h6><a href="" class="text-decoration-none text-dark"><%=blog.getTitle()%>
                </a></h6>
                <p class="fw-bold">автор: <%=DBManager.authorNameByBlogId(blog.getId())%>
                </p>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
