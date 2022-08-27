<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 20/08/22
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student Form</title>
</head>
<body>

<form action="/add-student" method="post">
    <label for="firstName">First Name</label>
    <input  type="text" id="firstName" name="firstName" >

    <br>
    <label for="lastname">Lastname</label>
    <input type="text" name="lastName" id="lastname">
    <br>
    <label for="email">Email</label>
    <input type="text" name="email" id="email">

    <br>
    <label for="course">Course</label>
    <input name="course" type="number" id="course">
    <br>

    <button type="reset">Reset</button>
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
