<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <form action="index.jsp">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
        <input type="hidden" name="command" value="delete"/>
        <div>
            <h1 class="mb-4">Are you sure to delete?</h1>
            <div class="d-flex justify-content-center gap-3">
                <button class="btn btn-primary px-3 py-2 fs-3" type="submit">Yes</button>
                <a href="index.jsp" class="btn btn-danger p-3 py-2 fs-3" type="button">No</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
