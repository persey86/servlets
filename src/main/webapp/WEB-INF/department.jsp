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
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>

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
            <c:forEach var="departments" items="${requestScope.departments}">
                <tr>
                    <td>${departments.id}</td>
                    <td>${departments.name}</td>
                    <td>${departments.created}</td>
                    <td><a href="/department/edit/${departments.id}">Edit</a></td>
                    <td>
                        <form method="post" action="<c:url value='/department/delete' />">
                            <input type="hidden" name="id" value="${departments.id}">
                            <input type="submit" value="Delete user"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <div class="row">
        <form method="post" action="<c:url value='/department' />">
            <input type="text" placeholder="Name" name="name"/>
            <%--<input type="date" placeholder="created" name="created" />--%>
            <input type="text" placeholder="id" name="id" value="1"/>
            <input type="submit" value="Add user"/>
        </form>

    </div>



</div>


<footer>Footer</footer>

</body>
</html>
