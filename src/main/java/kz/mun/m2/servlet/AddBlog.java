package kz.mun.m2.servlet;

import kz.mun.m2.db.DBManager;
import kz.mun.m2.model.Author;
import kz.mun.m2.model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddBlog", value = "/add-blog")
public class AddBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String blogTitle = request.getParameter("blogTitle");
        String blogContent = request.getParameter("blogContent");
        HttpSession session = request.getSession();
        Author currentAuthor = (Author) session.getAttribute("CURRENT_AUTHOR");
        DBManager.addBlog(new Blog(null, blogTitle, blogContent, currentAuthor.getId()));
        response.sendRedirect("/main");
    }
}
