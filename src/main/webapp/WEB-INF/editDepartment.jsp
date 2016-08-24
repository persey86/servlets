<%--
  Created by IntelliJ IDEA.
  User: Anastasia
  Date: 25.08.2016
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Department</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Edit department with id = ${requestScope.currentDepartment.id}</h1>

<form method="post" action="<c:url value='/departments' />">
    <input type="hidden" name="id" value="${requestScope.currentDepartment.id}">
    <input type="text" placeholder="Name" name="name" value="${requestScope.currentDepartment.name}"/>
    <%--<input type="date" placeholder="created" name="created" value="${requestScope.currentUser.created}" />--%>
    <input type="submit" value="Update department"/>
</form>

</body>
</html>
