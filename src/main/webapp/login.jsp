<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="login" method="POST">
        <div class="row mb-4">

            <div class="col-auto">
                <label for="email" class="form-label">Email:</label>
                <input class="form-control" type="email" placeholder="email" id="email" name="email">
            </div>

            <div class="col-auto">
                <label for="password" class="form-label">Password:</label>
                <input class="form-control" type="password" placeholder="password" id="password" name="password">
            </div>

            <input type="hidden" name="command" value="insert"/>

            <div class="col-auto pt-4" style="display:flex; justify-content: center; align-items: center">
                <button class="btn btn-primary" type="submit">Login</button>
            </div>

        </div>
    </form>
</div>
</body>
</html>
