<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Devcolibri.com</title>
</head>
<body>
    <h1>Hello ${requestScope.name}</h1>
    <table>
        <tr>
            <td>id</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Created</td>
        </tr>
        <c:forEach var="u" items="${requestScope.users}">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td>${u.created}</td>
            </tr>
        </c:forEach>
    </table>

    <form method="post" action="<c:url value='/users' />">
        <input type="text" placeholder="Name" name="userName" value="${userName}" />
        <input type="text" placeholder="Surname" name="userSurname" value="${userSurname}" />
        <%--<input type="date" placeholder="created" name="created" value="${created}" />--%>
        <%--<input type="text" placeholder="dep_id" name="dep_id" value="${dep_id}" />--%>
        <input type="submit" value="Create user" />
    </form>

</body>
</html>