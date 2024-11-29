<%@ page import="org.example.educationwebapp.util.ParamUtil" %>
<%@ page import="org.example.educationwebapp.student.repo.StudentRepo" %>
<%@ page import="org.example.educationwebapp.student.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    Integer id = ParamUtil.parseInt(request.getParameter("id"));
    StudentRepo repo = new StudentRepo();
    Student foundStudent = repo.findById(id);
%>

<div class="container mt-4">
    <form action="index" method="POST">
        <div class="row mb-4">

            <div class="col-auto">
                <label for="firstname" class="form-label">Name:</label>
                <input class="form-control" type="text" placeholder="Name" id="firstname" name="firstname"
                       value="<%=foundStudent.getName()%>">
            </div>

            <div class="col-auto">
                <label for="surname" class="form-label">Surname:</label>
                <input class="form-control" type="text" placeholder="Surname" id="surname" name="surname"
                       value="<%=foundStudent.getSurname()%>">
            </div>

            <div class="col-auto">
                <label for="age" class="form-label">Age:</label>
                <input class="form-control" type="text" placeholder="Age" id="age" name="age"
                       value="<%=foundStudent.getAge()%>">
            </div>

            <div class="col-auto">
                <label for="email" class="form-label">Email:</label>
                <input class="form-control" type="email" placeholder="Email" id="email" name="email"
                       value="<%=foundStudent.getEmail()%>">
            </div>

            <div class="col-auto">
                <label for="university" class="form-label">University:</label>
                <select class="form-select" id="university" name="university">
                    <option value="BDU" <%=foundStudent.getUniversity().equalsIgnoreCase("BDU") ? "selected" : ""%>>BDU
                    </option>
                    <option value="ADNSU" <%=foundStudent.getUniversity().equalsIgnoreCase("ADNSU") ? "selected" : ""%>>
                        ADNSU
                    </option>
                    <option value="AzTU" <%=foundStudent.getUniversity().equalsIgnoreCase("AzTU") ? "selected" : ""%>>
                        AzTU
                    </option>
                    <option value="Khazar" <%=foundStudent.getUniversity().equalsIgnoreCase("Khazar") ? "selected" : ""%>>
                        Khazar
                    </option>
                </select>
            </div>

            <input type="hidden" name="command" value="update"/>
            <input type="hidden" name="id" value="<%=foundStudent.getId()%>">

            <div class="col-auto pt-4" style="display:flex; justify-content: center; align-items: center">
                <button class="btn btn-primary" type="submit">Save</button>
            </div>

        </div>
    </form>
</div>
</body>
</html>
