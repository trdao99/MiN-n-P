<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACE HELIOS
  Date: 5/9/2024
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>edit employee</h1>
<form action="/BooksServlet" method="post">
    <table border="1">

        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${name1}"></td>
        </tr>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${id1}" readonly></td>
        </tr>
        <tr>
            <th>price</th>
            <td><input type="text" name="price" value="${price1}"></td>
        </tr>
        <tr>
            <th>stock</th>
            <td><input type="text" name="stock" value="${stock1}"></td>
        </tr>
        <tr>
            <th>author</th>
            <td><input type="text" name="author" value="${author1}"></td>
        </tr>
        <tr>
            <th>totalPages</th>
            <td><input type="text" name="totalPages" value="${totalPages1}"></td>
        </tr>
        <tr>
            <th>yearCreated</th>
            <td><input type="text" name="yearCreated" value="${yearCreated1}"></td>
        </tr>

        <tr>
            <th>Status</th>
            <td>
                <input type="radio" ${status1 ? 'checked' : ''} name="status" value="true"><span>con</span><br>
                <input type="radio" ${!status1 ? 'checked' : ''} name="status" value="false"><span>het</span>
            </td>
        </tr>
        <tr>
            <th>Category</th>
            <td>
                <select name="category">
                    <c:forEach items="${categories}" var="cate">
                        <option value="${cate.id}">${cate.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="action" value="UPDATE"></td>
        </tr>
    </table>
</form>
</body>
</html>
