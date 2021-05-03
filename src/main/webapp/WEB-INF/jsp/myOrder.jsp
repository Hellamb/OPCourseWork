<%--
  Created by IntelliJ IDEA.
  User: Hellamb
  Date: 28.04.2021
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My order</title>
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>My order</h1>
    <c:choose >
        <c:when test="${not empty tableNumber}">
            <div class="orders-div">
                <p  class="oredered-table-text">Замовлення ${tableNumber} столику</p>
                <form action="setTable" method="post">
                    <p>Обрати інший столик:</p>
                    <input type="number" name="tableNumber" placeholder="Номер столику">
                    <input type="submit" value="Відправити">
                </form>
                <c:forEach var="order" items="${orders}">
                    <c:if test="${order.tableNumber == tableNumber}">
                        <p  class="oredered-name">Ім'я замовника : ${order.customerName}</p>
                        <c:forEach  var="elem" items="${order.orderedElements}">
                            <div class="order-element-main">
                                <img src="${elem.key.imageUrl}" alt="missing image">
                                <p class="menu-element-name">${elem.key.name}</p>
                                <p class="menu-element-price">Ціна: ${elem.key.price} грн</p>
                                <p class='menu-element-description' >Опис: ${elem.key.description}</p>
                                <p class='menu-element-count' >Кількість: ${elem.value}</p>
                            </div>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </div>
        </c:when>
        <c:when test="${empty tableNumber}">
            <form action="setTable" method="post">
                <p>Обрати столик:</p>
                <input type="number" name="tableNumber" placeholder="Номер столику">
                <input type="submit" value="Відправити">
            </form>
        </c:when>
    </c:choose>

    <%@include file="footer.jspf"%>
</body>
</html>
