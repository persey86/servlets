<%--
  Created by IntelliJ IDEA.
  User: Anastasia
  Date: 24.08.2016
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department</title>
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
                <li class="active"><a href="/">Home</a></li>
                <li><a href="/departments">Departments</a></li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="main container">

    <div class="row">
        <h1>Department ${requestScope.name}</h1>


    </div>

    <div class="row">
        <table>
            <tr>
                <td>id</td>
                <td>Name</td>
                <td>Created</td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach var="u" items="${requestScope.users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.created}</td>
                    <td><a href="/user/edit/${u.id}">Edit</a></td>
                    <td>
                        <form method="post" action="<c:url value='/user/delete' />">
                            <input type="hidden" name="departmentId" value="${u.id}">
                            <input type="submit" value="Delete user"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <div class="row">
        <form method="post" action="<c:url value='/users' />">
            <input type="text" placeholder="Name" name="userName"/>
            <%--<input type="date" placeholder="created" name="created" />--%>
            <input type="text" placeholder="departmentId" name="departmentId" value="4"/>
            <input type="submit" value="Add user"/>
        </form>

    </div>



</div>


<footer>Footer</footer>

</body>
</html>