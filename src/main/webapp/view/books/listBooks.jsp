<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACE HELIOS
  Date: 5/9/2024
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach category</h1>
<a href="/BooksServlet?action=ADD">Them moi</a>
<table border="5" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>price</th>
        <th>stock</th>
        <th>author</th>
        <th>totalPages</th>
        <th>yearCreated</th>
        <th>category</th>
        <th>status</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="em" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${em.name}</td>
            <td>${em.price}</td>
            <td>${em.stock}</td>
            <td>${em.author}</td>
            <td>${em.totalPages}</td>
            <td>${em.yearCreated}</td>
            <td>${em.category.name}</td>
            <td>${em.status?"con":"het"}</td>
            <td>
                <a href="/BooksServlet?action=EDIT&id=${em.id}&name=${em.name}&price=${em.price}&stock=${em.stock}&author=${em.author}&totalPages=${em.totalPages}&yearCreated=${em.yearCreated}&categoryID=${em.category.id}&status=${em.status}">Edit</a>
            </td>
            <td><a href="/BooksServlet?action=DEL&id=${em.id}" onclick="return confirm('sure?')">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
