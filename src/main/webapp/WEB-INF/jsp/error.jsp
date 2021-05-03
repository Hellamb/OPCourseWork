<%--
  Created by IntelliJ IDEA.
  User: Hellamb
  Date: 30.04.2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>Щось пішло не так...</h1>
    <p>${message}</p>
    <form action="/">
        <input type="submit" value="Повернутися">
    </form>
</body>
</html>
