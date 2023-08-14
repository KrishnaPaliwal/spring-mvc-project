<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>
    <h1>Student Registration Form</h1>
    <form action="${pageContext.request.contextPath}/student/register" method="post">
        <label>Name:</label>
        <input type="text" name="name" required><br>

        <label>Age:</label>
        <input type="number" name="age" required><br>

        <!-- Add other form fields here as needed -->

        <input type="submit" value="Register">
    </form>
</body>
</html>
