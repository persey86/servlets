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
                <li class="active"><a href="<c:url value='/' />">Home</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="main container">

    <div class="row">
        <h1>Personal List of Department: ${departmentById.name} </h1>
    </div>




    <div class="row">
        <table class="table table-bordered">

            <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.surname}</td>
                    <td>${u.email}</td>
                    <td>${u.created}</td>
                    <td>${u.age}</td>
                    <td><a class="btn btn-primary" href="/user/edit/${u.id}">Edit</a></td>
                    <td>
                        <form method="post" action="<c:url value='/user/delete' />">
                            <input type="hidden" name="departmentId" value="${u.id}">
                            <input class="btn btn-primary" type="submit" value="Delete user"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <div class="row">
        <form method="post" action="<c:url value='/users' />">
            <input type="text" placeholder="Name" name="userName"/>
            <input type="text" placeholder="Surname" name="userSurname"/>
            <input type="text" placeholder="Email" name="userEmail"/>
            <input type="date" placeholder="Date" name="userDate"/>
            <input type="text" placeholder="Age" name="userAge"/>
            <select name='departmentId'>
                <option value="${selected}" selected>${selected}</option>
                <c:forEach items="${departments}" var="department">
                    <option value="${department.id}">${department.name}</option>
                </c:forEach>
            </select>
            <input class="btn btn-primary" type="submit" value="Add user"/>
        </form>

    </div>


</div>


</body>
</html>