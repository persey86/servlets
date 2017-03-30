<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Department</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value='/departments' />">Home</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="main container">

    <div class="row">
        <h1>Personal List of Department </h1>
    </div>

    <div class="row">
        <table class="table table-bordered">
            <c:forEach var="dep" items="${departments}">
                <tr>
                    <td>${dep.id}</td>
                    <td>${dep.name}</td>
                    <td><a class="btn btn-primary" href="/department/edit/${department.id}">Edit</a></td>
                    <td>
                        <form method="post" action="<c:url value='/department/delete' />">
                            <input type="hidden" name="departmentId" value="${dep.id}">
                            <input class="btn btn-primary" type="submit" value="Delete department"/>
                        </form>
                    </td>
                    <td><a class="btn btn-primary" href="/users/departmentId/${dep.id}">Show users</a></td>
                </tr>

            </c:forEach>
        </table>
    </div>

    <div class="row">
        <form method="post" action="<c:url value='/departments' />">
            <input type="text" placeholder="Name" name="departmentName"/>
            <input class="btn btn-success" type="submit" value="Add department"/>
        </form>
    </div>


</body>
</html>