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
import java.util.List;

@WebServlet(name = "indexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    private final StudentRepo repo = new StudentRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleStudentListRequest(request);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String command = ParamUtil.get(request.getParameter("command"));
        if (command == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Command is required");
            return;
        }

        switch (command.toLowerCase()) {
            case "insert" -> handleInsert(request, response);
            case "update" -> handleUpdate(request, response);
            case "delete" -> handleDelete(request, response);
            default -> response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid command: " + command);
        }
    }

    private void handleStudentListRequest(HttpServletRequest request) {
        String name = ParamUtil.get(request.getParameter("firstname"));
        String surname = ParamUtil.get(request.getParameter("surname"));
        String email = ParamUtil.get(request.getParameter("email"));
        String university = ParamUtil.get(request.getParameter("university"));
        String password = ParamUtil.get(request.getParameter("password"));
        Integer age = ParamUtil.parseInt(request.getParameter("age"));

        List<Student> students = repo.getList(name, surname, age, email, university, password);

        request.setAttribute("studentsList", students);
        request.getSession().setAttribute("students", students);
    }

    private void handleInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = extractStudentFromRequest(request);
        repo.insert(student);
        response.sendRedirect("index");
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = ParamUtil.parseInt(request.getParameter("id"));
        if (id == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Student ID is required for update");
            return;
        }

        Student student = extractStudentFromRequest(request);
        student.setId(id);
        repo.update(student);
        response.sendRedirect("index");
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = ParamUtil.parseInt(request.getParameter("id"));
        if (id == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Student ID is required for deletion");
            return;
        }

        repo.delete(id);
        response.sendRedirect("index");
    }

    private Student extractStudentFromRequest(HttpServletRequest request) {
        String name = ParamUtil.get(request.getParameter("firstname"));
        String surname = ParamUtil.get(request.getParameter("surname"));
        String email = ParamUtil.get(request.getParameter("email"));
        String university = ParamUtil.get(request.getParameter("university"));
        Integer age = ParamUtil.parseInt(request.getParameter("age"));

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setUniversity(university);
        student.setAge(age);

        return student;
    }
}
