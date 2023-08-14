<!DOCTYPE html>
<html>
<head>
    <title>Student Results</title>
</head>
<body>
    <h1>Student Results</h1>
    <h2>Student Name: ${student.name}</h2>

    <table>
        <tr>
            <th>Subject</th>
            <th>Score</th>
        </tr>
        <c:forEach items="${results}" var="result">
            <tr>
                <td>${result.subject}</td>
                <td>${result.score}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
