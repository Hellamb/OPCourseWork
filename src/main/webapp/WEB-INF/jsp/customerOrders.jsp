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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Customer Orders Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Customer Orders</h1>

    <div class="container-lg">
    <c:forEach var="order" items="${orders}">
        <p  class="h2">Customer name : ${order.customerName}</p>
        <p  class="h4">Order from table: ${order.tableNumber}</p>
            <c:set value="0" var="allPrice" ></c:set>
            <c:forEach  var="elem" items="${order.orderedElements}">
                <c:set value="${allPrice+elem.key.price*elem.value}" var="allPrice" ></c:set>
                <div class="container-fluid">
                    <div class="container-fluid menu-element-main">
                        <div class="row">
                            <div class="col col-auto">
                                <img class="menu-img img-fluid img-thumbnail" src="${elem.key.imageUrl}" alt="missing image">
                            </div>
                            <div class="col col-auto">
                                <p class="h3">${elem.key.name}</p>
                                <p class="h5">Price for 1: ${elem.key.price} $</p>
                                <p class="h5">Count: ${elem.value}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="row">
                <div class="col col-auto">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="h4 bg-warning">Price for order: ${allPrice} $</span>
                </div>
                <div class="col col-auto">
                    <form action="deleteOrder" method="post">
                        <input type="hidden" name="orderId" value="${order.orderId}">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-sm btn-danger">Delete order</button>
                    </form>
                </div>
            </div>
            <br><br>
    </c:forEach>
    </div>

    <%@include file="footer.jspf"%>

</body>
</html>
