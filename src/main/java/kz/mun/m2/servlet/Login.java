package kz.mun.m2.servlet;

import kz.mun.m2.db.DBManager;
import kz.mun.m2.model.Author;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorEmail = request.getParameter("authorEmail");
        String authorPassword = request.getParameter("authorPassword");
        Author author = DBManager.getAuthorByEmail(authorEmail);

        String redirect = "/login.jsp?emailError";

        if (author != null) {

            redirect = "/login.jsp?passwordError";

            if (author.getPassword().equals(authorPassword)) {
                request.getSession().setAttribute("CURRENT_AUTHOR", author);
                response.sendRedirect("/main");
            } else {
                request.getRequestDispatcher(redirect).forward(request, response);
            }

        } else {
            request.getRequestDispatcher(redirect).forward(request, response);
        }
    }
}
