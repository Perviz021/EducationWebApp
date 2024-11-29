<%@ page import="org.example.educationwebapp.teacher.entity.Teacher" %>
<%@ page import="org.example.educationwebapp.teacher.repo.TeacherRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.educationwebapp.student.repo.StudentRepo" %>
<%@ page import="org.example.educationwebapp.student.entity.Student" %>
<%@ page import="org.example.educationwebapp.util.ParamUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Education</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container">
<h1 class="pb-4 pt-3">Students</h1>
<%
    String name = ParamUtil.get(request.getParameter("firstname"));
    String surname = ParamUtil.get(request.getParameter("surname"));
    String email = ParamUtil.get(request.getParameter("email"));
    String university = ParamUtil.get(request.getParameter("university"));
    Integer age = ParamUtil.parseInt(request.getParameter("age"));

%>
<form>
    <div class="row mb-4">

        <div class="col-auto">
            <label for="firstname" class="form-label">Name:</label>
            <input class="form-control" type="text" placeholder="Name" id="firstname" name="firstname"
                   value="<%=name%>">
        </div>

        <div class="col-auto">
            <label for="surname" class="form-label">Surname:</label>
            <input class="form-control" type="text" placeholder="Surname" id="surname" name="surname"
                   value="<%=surname%>">
        </div>

        <div class="col-auto">
            <label for="age" class="form-label">Age:</label>
            <input class="form-control" type="text" placeholder="Age" id="age" name="age" value="<%=age!=null?age:""%>">
        </div>

        <div class="col-auto">
            <label for="email" class="form-label">Email:</label>
            <input class="form-control" type="email" placeholder="Email" id="email" name="email" value="<%=email%>">
        </div>

        <div class="col-auto">
            <label for="university" class="form-label">University:</label>
            <select class="form-select" id="university" name="university">
                <option value="BDU" <%=university != null && university.equals("BDU") ? "selected" : ""%> >BDU</option>
                <option value="ADNSU" <%=university != null && university.equals("ADNSU") ? "selected" : ""%>>ADNSU
                </option>
                <option value="AzTU" <%=university != null && university.equals("AzTU") ? "selected" : ""%>>AzTU
                </option>
                <option value="Khazar" <%=university != null && university.equals("Khazar") ? "selected" : ""%>>Khazar
                </option>
            </select>
        </div>

        <div class="col-auto pt-4" style="display:flex; justify-content: center; align-items: center">
            <button class="btn btn-primary" type="submit">Search</button>
        </div>
        <div class="col-auto pt-4" style="display:flex; justify-content: center; align-items: center">
            <a href="insert.jsp" class="btn btn-success">Insert</a>
        </div>

    </div>
</form>


<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Email</th>
        <th>University</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = (List<Student>) request.getAttribute("studentsList");

        for (Student student : students) {
    %>
    <tr>
        <th scope="row"><%=student.getId()%>
        </th>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getSurname()%>
        </td>
        <td><%=student.getAge()%>
        </td>
        <td><%=student.getEmail()%>
        </td>
        <td><%=student.getUniversity()%>
        </td>
        <td>
            <a href="delete.jsp?id=<%=student.getId()%>" class="btn btn-danger">Delete</a>
            <a href="update.jsp?id=<%=student.getId()%>" class="btn btn-warning">Update</a>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>