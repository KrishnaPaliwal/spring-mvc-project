<!DOCTYPE html>
<html>
<head>
    <title>Edit Registration Form</title>
</head>
<body>
    <h1>Edit Registration Form</h1>
    <form action="/student/saveForm" method="post">        
        <label>Subject:</label>
        <input type="text" name="subject" required><br>

        <label>Data:</label>
        <textarea name="data" rows="5" cols="50" required></textarea><br>

        <input type="submit" value="Save Form">
    </form>
</body>
</html>
