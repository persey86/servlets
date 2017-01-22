<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit user</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Edit user with id = ${requestScope.currentUser.id}</h1>


<form method="post" action="<c:url value='/users' />">
    <input type="hidden" name="id" value="${requestScope.currentUser.id}">
    <input type="text" placeholder="Name" name="userName" value="${requestScope.currentUser.name}"/>
    <input type="text" placeholder="Surname" name="userSurname" value="${requestScope.currentUser.surname}"/>
    <input type="text" placeholder="Email" name="userEmail" value="${requestScope.currentUser.email}"/>
    <input type="text" placeholder="departmentId" name="departmentId" value="${requestScope.currentUser.departmentId}" />
    <input type="submit" value="Update user"/>
</form>


</body>
</html>