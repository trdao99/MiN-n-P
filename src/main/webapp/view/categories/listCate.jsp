<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACE HELIOS
  Date: 5/9/2024
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach category</h1>
<a href="/CategoryServlet?action=ADD">Them moi</a>
<table border="5" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="em" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td >${em.name}</td>
            <td >${em.status?"con":"het"}</td>
            <td><a href="/CategoryServlet?action=EDIT&id=${em.id}&name=${em.name}&status=${em.status}">Edit</a></td>
            <td><a href="/CategoryServlet?action=DEL&id=${em.id}" onclick="return confirm('sure?')">Delete</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
