<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <input type="text" placeholder="Name" name="depname" value="${requestScope.currentDepartment.name}"/>
    <input type="submit" value="Update department"/>
</form>

</body>
</html>
