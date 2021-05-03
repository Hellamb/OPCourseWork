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
    <title>Menu editing page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/menuEditor.css">
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Menu editing page</h1>
    <c:forEach var="menu" items="${menus}">
        <p>${menu.name}</p>
        <form action="removeMenu" method="post">
            <input type="hidden" name="menuId" value="${menu.menuId}">
            <input type="submit" value="Видалити меню" class="delete-menu-button">
        </form>
        <div class="menu-elements-div">
            <c:forEach var="menuElement" items="${menu.menuElementsList}" >
                <img src="${menuElement.imageUrl}" alt="missing image">
                <p class="menu-element-name">${menuElement.name}</p>
                <p class="menu-element-price">Price: ${menuElement.price} грн</p>
                <p class='menu-element-description' >Description: ${menuElement.description}</p>
                <form action="removeMenuElement">
                    <input type='hidden' name='menuId' value='${menu.menuId}'/>
                    <input type='hidden' name='name'  value='${menuElement.name}'/>
                    <input type='hidden' name='price' value='${menuElement.price}'/>
                    <input type='hidden' name='imageUrl'  value='${menuElement.imageUrl}'/>
                    <input type='hidden' name='description' value='${menuElement.description}'/>
                    <input type="submit" value="Видалити елемет меню">
                </form>
            </c:forEach>
            <div class="add-new-menu-element">
                <form action="addMenuElement" method="post">
                    <input type='hidden' name='menuId' value='${menu.menuId}'/>
                    <input type='text' placeholder="name" name='name' required/>
                    <input type='number' placeholder="price" name='price' required/>
                    <input type='text' placeholder="image URL" name='imageUrl' required/>
                    <input type='text' placeholder="description" name='description' required/>
                    <input type="submit" value="Add menu element">
                </form>
            </div>
        </div>
    </c:forEach>
    <div class="add-new-menu">
        <form action="addMenu" method="post">
            <input type="text" name="name" placeholder="name">
            <input type="submit" value="Add menu">
        </form>
    </div>

    <%@include file="footer.jspf"%>
</body>
</html>
