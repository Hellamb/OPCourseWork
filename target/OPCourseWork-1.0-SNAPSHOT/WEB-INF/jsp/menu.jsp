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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Menu 4 U</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Menu</h1>
    <c:set value="1" var="menuIncrement"></c:set>
    <form action="sendOrder" method="post" class="order-form">
        <c:forEach var="menu" items="${menus}">
            <div class="container-lg">
                <p class="h2">${menu.name}</p>
                <c:forEach var="menuElement" items="${menu.menuElementsList}">
                    <div class="container-fluid menu-element">
                        <div class="container-fluid menu-element-main">
                            <div class="row">
                                <div class="col col-auto">
                                    <img class="menu-img img-fluid img-thumbnail" src="${menuElement.imageUrl}" alt="missing image">
                                </div>
                                <div class="col col-auto">
                                    <p class=" h3 menu-element-name">${menuElement.name}</p>
                                    <p class="menu-element-price">Price: ${menuElement.price} $</p>
                                    <button class="btn btn-success" type="button" data-bs-toggle="collapse"
                                            data-bs-target="#more-menu-${menuIncrement}"
                                            aria-expanded="false" aria-controls="more-menu-${menuIncrement}">
                                        More...
                                    </button>
                                    &nbsp;
                                    <span class="h4">Count to order: </span>
                                    <button type='button' class=' btn btn-danger order-minus-button'>&nbsp;–&nbsp;</button>
                                    &nbsp;
                                    <span class=' h4 menu-element-count-decor'>0</span>
                                    &nbsp;
                                    <button type='button' class=' btn btn-success order-plus-button'>&nbsp;+&nbsp;</button>
                                </div>
                            </div>
                            <div class="collapse" id="more-menu-${menuIncrement}">
                                <p class='menu-element-description' ><strong>Description:</strong> <br>${menuElement.description}</p>
                            </div>
                            <c:set value="${menuIncrement+1}" var="menuIncrement"></c:set>
                            <input class="menu-element-count" type='hidden' name='elementCount' value='0'/>
                            <input type='hidden' name='menuID' value='${menu.menuId}'/>
                            <input type='hidden' name='price' value='${menuElement.price}'/>
                            <input type='hidden' name='name' value='${menuElement.name}'/>
                            <input type='hidden' name='imageUrl' value='${menuElement.imageUrl}'/>
                            <input type='hidden' name='description' value='${menuElement.description}'/>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
        <div class="container-fluid px-4">
            <button type="button" class="send-order-button btn btn-warning btn-lg" data-bs-toggle="modal" data-bs-target="#orderModal">Send Order</button>
        </div>
        <div class="modal fade" id="orderModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirm order</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="form-floating">
                            <input type='text' id="floatingInput-1" class='form-control table-number-input' name='customerName' required placeholder='Your name'>
                            <label for="floatingInput-1">Your name</label>
                        </div>
                        <br>
                        <div class="form-floating">
                            <input type='number' id="floatingInput-2" class='form-control' name='tableNumber' required placeholder='Table number'>
                            <label for="floatingInput-2">Table number</label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type='submit' class='confirm-order-button btn btn-outline-success'>Confirm order</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <%@include file="footer.jspf"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/menu.js"></script>
</body>
</html>