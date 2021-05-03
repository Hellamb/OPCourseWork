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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/menu.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Menu page</h1>
    <form action="sendOrder" method="post" class="order-form">
        <c:forEach var="menu" items="${menus}">
            <div class="menu">
                <p class="menu-name">${menu.name}</p>
                <c:forEach var="menuElement" items="${menu.menuElementsList}">
                    <div class="menu-element" extended="false">
                        <div class="menu-element-main">
                            <img src="${menuElement.imageUrl}" alt="missing image">
                            <p class="menu-element-name">${menuElement.name}</p>
                            <p class="menu-element-price">Ціна: ${menuElement.price} грн</p>
                            <p class='menu-element-description' >Опис: ${menuElement.description}</p>
                            <input type='hidden' name='menuID' value='${menu.menuId}'/>
                            <input type='hidden' name='price' value='${menuElement.price}'/>
                            <input type='hidden' name='name' value='${menuElement.name}'/>
                            <input type='hidden' name='imageUrl' value='${menuElement.imageUrl}'/>
                            <input type='hidden' name='description' value='${menuElement.description}'/>
                            <input class="menu-element-count" type='hidden' name='elementCount' value='0'/>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
        <button type="button" class="send-order-button" onclick="confirmOrder()">Send Order</button>
    </form>
    <%@include file="footer.jspf"%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/menu.js"></script>
</body>
</html>