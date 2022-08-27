
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>STUDENTS VIEW PAGE</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

    <%--  =========== SCRIPTS ===========--%>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
            integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
            integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
            crossorigin="anonymous"></script>

</head>
<body>
<table class="table">
<thead>
<tr>
<th scope="col">№</th>
    <th scope="col">First name</th>
    <th scope="col">Last name</th>
    <th scope="col">Email</th>
    <th scope="col" >Course</th>
</tr>


</thead>
    <tbody>
<c:forEach items="${students}" var="student">
<tr>
<%--    <th scope="row">${student.getId()}</th>--%>
    <td>${student.getId()}</td>
    <td>${student.getFirstName()}</td>
    <td>${student.getLastName()}</td>
    <td>${student.getEmail()}</td>
    <td>${student.getCourse()}</td>
<td><a href="/edit-student?id=${student.getId()}" class="btn btn-warning" >EDIT</a>
    <a href="/delete-student?id=${student.getId()}" class="btn btn-danger">DELETE</a>
</td>
</tr>



</c:forEach>
<a href="/add-student" class="btn btn-primary">+ yangi student qo'shish</a>

    </tbody>
</table>



</body>
</html>
