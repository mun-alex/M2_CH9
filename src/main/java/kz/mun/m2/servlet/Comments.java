package kz.mun.m2.servlet;

import com.google.gson.Gson;
import kz.mun.m2.db.DBManager;
import kz.mun.m2.model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Comments", value = "/comments")
public class Comments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long blogId = Long.parseLong(request.getParameter("blogId"));
        List<Comment> comments = DBManager.getCommentsByBlogId(blogId);
        String commentsJson = new Gson().toJson(comments);
        PrintWriter out = response.getWriter();
        out.println(commentsJson);


//        request.setAttribute("blogs", DBManager.getAllBlogs());
//        request.setAttribute("comments", DBManager.getCommentsByBlogId(blogId));
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
