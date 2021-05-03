<%--
  Created by IntelliJ IDEA.
  User: Hellamb
  Date: 28.04.2021
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Orders Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/customerOrders.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Customer Orders Page</h1>

    <c:forEach var="order" items="${orders}">

        <div class="order-header" >
            <p class="order-table">Столик: ${order.tableNumber}</p>
            <p class="order-table">Ім'я замовника: ${order.customerName}</p>
            <form action="deleteOrder" method="post">
                <input type="hidden" name="orderId" value="${order.orderId}">
                <input type="submit" value="Видалити замовлення" class="delete-order-button">
            </form>
        </div>
        <div class="order-main">
            <c:forEach var="elem" items="${order.orderedElements}">
                <div class="order-element">
                    <img src="${elem.key.imageUrl}" alt="missing image">
                    <p class="menu-element-name">${elem.key.name}</p>
                    <p class="menu-element-price">Ціна: ${elem.key.price} грн</p>
                    <p class="menu-element-count">Кількість: ${elem.value}</p>
                </div>
            </c:forEach>
        </div>
    </c:forEach>

    <%@include file="footer.jspf"%>

</body>
</html>
