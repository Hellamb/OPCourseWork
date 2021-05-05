<%--
  Created by IntelliJ IDEA.
  User: Hellamb
  Date: 28.04.2021
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Menu editing page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Menu editing</h1>

    <c:set value="0" var="menuIncrement"></c:set>
    <c:set value="0" var="floatingIncrement"></c:set>
    <c:set value="0" var="modalIncrement"></c:set>
    <div class="container-lg">
        <c:forEach var="menu" items="${menus}">
            <form action="removeMenu" method="post">
                <span class="h2">${menu.name}</span>
                <input type="hidden" name="menuId" value="${menu.menuId}">
                <button type="submit" class="btn btn-danger " > Delete menu</button>
            </form>
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
                                <form action="removeMenuElement" method="post">
                                <button class="btn btn-success" type="button" data-bs-toggle="collapse"
                                        data-bs-target="#more-menu-${menuIncrement}"
                                        aria-expanded="false" aria-controls="more-menu-${menuIncrement}">
                                    More...
                                </button>
                                        <input type='hidden' name='menuId' value='${menu.menuId}'/>
                                        <input type='hidden' name='name'  value='${menuElement.name}'/>
                                        <input type='hidden' name='price' value='${menuElement.price}'/>
                                        <input type='hidden' name='imageUrl'  value='${menuElement.imageUrl}'/>
                                        <input type='hidden' name='description' value='${menuElement.description}'/>
                                        <button type="submit" class="btn btn-danger" > Delete dish</button>
                                    </form>
                            </div>
                        </div>
                        <div class="collapse" id="more-menu-${menuIncrement}">
                            <p class='menu-element-description' ><strong>Description:</strong> <br>${menuElement.description}</p>
                        </div>
                        <c:set value="${menuIncrement+1}" var="menuIncrement"></c:set>
                    </div>
                </div>
            </c:forEach>
            <div class="container-fluid px-4">
                <button type="button" class="send-order-button btn btn-info btn-lg" data-bs-toggle="modal" data-bs-target="#addDishModal${modalIncrement}">Add new dish</button>
            </div>
            <br><br>
            <div class="modal fade" id="addDishModal${modalIncrement}" tabindex="-1">
                <c:set value="${modalIncrement+1}" var="modalIncrement"></c:set>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Add new dish</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action="addMenuElement" method="post">
                            <div class="modal-body">
                                <input type='hidden' name='menuId' value='${menu.menuId}'/>
                                <div class="form-floating">
                                    <input type='text' id="floatingInput${floatingIncrement}" class='form-control table-number-input' name='name' required placeholder='Dish name'>
                                    <label for="floatingInput${floatingIncrement}">Dish name</label>
                                </div>
                                <c:set value="${floatingIncrement+1}" var="floatingIncrement"></c:set>
                                <br>
                                <div class="form-floating">
                                    <input type='number' id="floatingInput${floatingIncrement}" class='form-control' name='price' required placeholder='Price'>
                                    <label for="floatingInput${floatingIncrement}">Price</label>
                                </div>
                                <c:set value="${floatingIncrement+1}" var="floatingIncrement"></c:set>
                                <br>
                                <div class="form-floating">
                                    <input type='text' id="floatingInput${floatingIncrement}" class='form-control' name='imageUrl' required placeholder='Image URL'>
                                    <label for="floatingInput${floatingIncrement}">Image URL</label>
                                </div>
                                <c:set value="${floatingIncrement+1}" var="floatingIncrement"></c:set>
                                <br>
                                <div class="form-floating">
                                    <textarea type='text' rows="5" id="floatingInput${floatingIncrement}" class='form-control' name='description' required placeholder='Description'></textarea>
                                    <label for="floatingInput${floatingIncrement}">Description</label>
                                </div>
                                <c:set value="${floatingIncrement+1}" var="floatingIncrement"></c:set>
                            </div>
                            <div class="modal-footer">
                                <button type='submit' class='confirm-order-button btn btn-outline-success'>Confirm</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
        <br><br>
        <div class="container-fluid px-4">
            <button type="button" class="send-order-button btn btn-info btn-lg" data-bs-toggle="modal" data-bs-target="#addMenuModal">Add new menu</button>
        </div>
        <div class="modal fade" id="addMenuModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Add new menu</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="addMenu" method="post">
                        <div class="modal-body">
                            <div class="form-floating">
                                <input type='text' id="floatingInput" class='form-control table-number-input' name='name' required placeholder='Menu name>'>
                                <label for="floatingInput">Menu name</label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type='submit' class='confirm-order-button btn btn-outline-success'>Confirm</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%@include file="footer.jspf"%>
</body>
</html>
