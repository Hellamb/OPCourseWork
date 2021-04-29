<%--
  Created by IntelliJ IDEA.
  User: Hellamb
  Date: 28.04.2021
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu 4 U</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Menu page</h1>
    <c:forEach var="menu" items="${menus}">
        <div class="menu">
            <p>${menu.name}</p>
            <c:forEach var="menuElement" items="${menu.menuElementsList}">
                <div class="menu-element">
                    <img src="${menuElement.imageUrl}" alt="missing image">
                    <p class="menu-element-name">${menuElement.name}</p>
                    <p class="menu-element-price">Price:${menuElement.price}</p>
                </div>
            </c:forEach>
        </div>
    </c:forEach>

    <%@include file="footer.jspf"%>
</body>
</html>
