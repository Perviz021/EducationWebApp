<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="logout" method="POST">
        <div class="row mb-4">
            <div>
                <h1 class="mb-4">Are you sure to logout?</h1>
                <div class="d-flex justify-content-center gap-3">
                    <button class="btn btn-primary px-3 py-2 fs-3" type="submit">Yes</button>
                    <a href="login" class="btn btn-danger p-3 py-2 fs-3">No</a>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
