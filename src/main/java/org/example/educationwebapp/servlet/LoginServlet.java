package org.example.educationwebapp.servlet;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.educationwebapp.student.entity.Student;
import org.example.educationwebapp.student.repo.StudentRepo;
import org.example.educationwebapp.util.ParamUtil;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final StudentRepo studentRepo = new StudentRepo();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = ParamUtil.get(request.getParameter("email"));
        String password = ParamUtil.get(request.getParameter("password"));

        List<Student> list = studentRepo.getList(null, null, null, email, null, password);
        if (!list.isEmpty()) {
            Student student = list.get(0);
            request.getSession().setAttribute("loggedInUser", student);
        }
        response.sendRedirect("index");

        List<Student> students = (List<Student>) request.getSession().getAttribute("students");

        PrintWriter out = response.getWriter();
        out.println(students);
    }
}