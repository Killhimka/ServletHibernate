<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.05.2023
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit animal</title>
</head>
<body>
<form method="post">
    <input type="hidden" value="${pets.id}" name="id"/>
    <label>Name</label><br>
    <input name="animal" value="${pets.animal}"/><br>
    <label>Price</label><br>
    <input name="age" value="${pets.age}" type="number"/><br><br>
    <input type="submit" value="Send">
</form>
</body>
</html>
