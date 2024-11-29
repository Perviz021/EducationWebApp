package org.example.educationwebapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.educationwebapp.student.entity.Student;
import org.example.educationwebapp.student.repo.StudentRepo;
import org.example.educationwebapp.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    private final StudentRepo studentRepo = new StudentRepo();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("logout.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("login");
    }
}