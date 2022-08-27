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
    <title>UPDATE STUDENT</title>
<%--   <%@include file="basa.jsp"%>--%>
    <link rel="stylesheet" href="stylee.css">
</head>
<body>

<h1 class="text-center mb-3">UPDATE STUDENT</h1>
<c:if test="${students != null}">
    <form action="/edit-student" method="post">

        <div style="margin-top: 30px; margin-bottom: 400px; margin-right: 400px; margin-left: 400px">
            <input type="hidden" value="${students.id}" name="id">
            <div class="form-group">
                <label for="exampleInputfirstName">First Name</label>
                <input type="text" class="form-control" id="exampleInputfirstName"   value="${students.firstName}" name="firstName" >
            </div>
            <div class="form-group">
                <label for="exampleInputLastName">LAST NAME</label>
                <input type="text" class="form-control" id="exampleInputLastName" value="${students.lastName}" name="lastName" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail">EMAIL</label>
                <input type="text" class="form-control" id="exampleInputEmail"  value="${students.email}" name="email" >
            </div>
            <div class="form-group">
                <label for="exampleInputCourse">COURSE</label>
                <input type="text" class="form-control" id="exampleInputCourse"  value="${students.course}" name="course">
            </div>


<%--    style="text-align: center"--%>
            <div >
                <button class="btn btn-outline-warning">UPDATE</button>
<%--                <a href="/show-student" class="btn btn-outline-danger">BACK</a>--%>
            </div>
        </div>

    </form>
</c:if>


</body>
</html>

