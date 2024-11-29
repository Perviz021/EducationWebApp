<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <form action="index" method="POST">
        <div class="row mb-4">

            <div class="col-auto">
                <label for="firstname" class="form-label">Name:</label>
                <input class="form-control" type="text" placeholder="Name" id="firstname" name="firstname">
            </div>

            <div class="col-auto">
                <label for="surname" class="form-label">Surname:</label>
                <input class="form-control" type="text" placeholder="Surname" id="surname" name="surname">
            </div>

            <div class="col-auto">
                <label for="age" class="form-label">Age:</label>
                <input class="form-control" type="text" placeholder="Age" id="age" name="age">
            </div>

            <div class="col-auto">
                <label for="email" class="form-label">Email:</label>
                <input class="form-control" type="email" placeholder="Email" id="email" name="email">
            </div>

            <div class="col-auto">
                <label for="university" class="form-label">University:</label>
                <select class="form-select" id="university" name="university">
                    <option value="BDU">BDU
                    </option>
                    <option value="ADNSU">ADNSU
                    </option>
                    <option value="AzTU">AzTU
                    </option>
                    <option value="Khazar">Khazar
                    </option>
                </select>
            </div>

            <input type="hidden" name="command" value="insert"/>

            <div class="col-auto pt-4" style="display:flex; justify-content: center; align-items: center">
                <button class="btn btn-primary" type="submit">Save</button>
            </div>

        </div>
    </form>
</div>
</body>
</html>
