<%--
  Created by IntelliJ IDEA.
  User: ACE HELIOS
  Date: 5/9/2024
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add employee</h1>
<form action="/CategoryServlet" method="post">
    <table border="1">

        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${id1}" readonly></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${name1}"></td>
        </tr>

        <tr>
            <th>Status</th>
            <td>
                <input type="radio" ${status1 ? 'checked' : ''} name="status" value="true"><span>con</span><br>
                <input type="radio" ${!status1 ? 'checked' : ''} name="status" value="false"><span>het</span>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="action" value="UPDATE"></td>
        </tr>
    </table>
</form>
</body>
</html>
