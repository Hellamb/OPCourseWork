package com.kpi.acts.OPCourseWork.web;

import com.kpi.acts.OPCourseWork.model.*;
import com.kpi.acts.OPCourseWork.service.*;
import java.io.*;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FrontControllerServlet", urlPatterns = "/control/*")
public class FrontControllerServlet extends HttpServlet {

    OrderService orderService;
    MenuService menuService;
    Boolean isTestData;

    public void init(ServletConfig config) throws ServletException {
        orderService = (OrderService) config.getServletContext().getAttribute("orderService");
        menuService = (MenuService) config.getServletContext().getAttribute("menuService");

        isTestData = false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try
        {
            switch (pathInfo)
            {
                case "/adminLogin":
                    adminLogin(request, response);
                    break;
                case "/adminLogout":
                    adminLogout(request, response);
                    break;
                case "/toMenuEditor":
                    toMenuEditor(request, response);
                    break;
                case "/sendOrder":
                    sendOrder(request, response);
                    break;
                case "/addMenu":
                    addMenu(request, response);
                    break;
                case "/removeMenu":
                    removeMenu(request, response);
                    break;
                case "/addMenuElement":
                    addMenuElement(request, response);
                    break;
                case "/removeMenuElement":
                    removeMenuElement(request, response);
                    break;
                case "/toMyOrder":
                    toMyOrder(request, response);
                    break;
                case "/toCustomerOrders":
                    toCustomerOrders(request, response);
                    break;
                case "/deleteOrder":
                    deleteOrder(request, response);
                case "/setTable":
                    setTable(request, response);
                    break;
                case "/":
                case "/menu":
                    menu(request, response);
                    break;
                default:
                    response.sendError(404);
                    break;

            }
        }catch (RuntimeException ex)
        {
            menu(request, response);
        }

    }

    protected void menu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Collection<Menu> menus = menuService.getAllMenus();
        if(menus != null) {
            request.setAttribute("menus", menus);
        }
//        if(! isTestData){
//            isTestData = true;
//            menuService.addMenu("Dishes");
//            for (Menu menu: menus)
//            {
//                menuService.addMenuElement(menu,"Potato", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiOh-exQ8yWBtkDCv0MTjTbHboqkRDwJOtnQ&usqp=CAU", 3,"Delicious fried potatoes are an incredibly popular recipe. And this is more true than ever, because the recipe for fried potatoes is simple, always delicious and infinitely varied. Fried potatoes with onions and fried potatoes with bacon, fried young potatoes with garlic, fried potatoes with an egg and fried potatoes with stew are recipes familiar and loved from childhood, when fried potatoes appeared on the table so often. A recipe with a photo will remind you of the options for its preparation and offer new ones, no less tasty.\n");
//                menuService.addMenuElement(menu,"Pizza", "https://media.dominos.ua/__sized__/menu/product_osg_image_category/2020/12/28/Vetchina_i_griby_-thumbnail-960x960-70.jpg", 5,"Pizza is a national Italian dish, which is a round open flatbread topped with melted cheese (usually mozzarella) and tomatoes. Cheese is by far the main ingredient in pizza. The rest of the ingredients differ depending on the type of pizza. Today, pizza is one of the most popular dishes in the world.\n");
//                menuService.addMenuElement(menu,"Soup", "https://www.fifteenspatulas.com/wp-content/uploads/2016/02/Chicken-Noodle-Soup-Fifteen-Spatulas-3-640x427.jpg", 4,"This quick Chicken Noodle Soup recipe is perfect when you want a hot bowl of comfort but don’t want to slave over the stove for hours. It has the simple, clean flavors you expect from this classic soup.");
//            }
//        }
        request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
    }

    protected void adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String password = request.getParameter("adminPassword");
        if(!password.equals("admin")) {
            error(request,response,"Password incorrect");
        }
        else{
            request.getSession().setAttribute("isAdmin", true);
        }
        response.sendRedirect(".");
    }

    protected void adminLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().invalidate();
        response.sendRedirect(".");
    }

    protected void toMenuEditor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(!(boolean)request.getSession().getAttribute("isAdmin"))
        {
            error(request, response,"Please, login as admin");
        }
        else
        {
            Collection<Menu> menus = menuService.getAllMenus();
            if(menus != null) {
                request.setAttribute("menus", menus);
            }
            request.getRequestDispatcher("/WEB-INF/jsp/menuEditor.jsp").forward(request, response);
        }
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String tableNumber = request.getParameter("tableNumber");
        request.getSession().setAttribute("tableNumber",tableNumber);
        Map<String,String[]> params = request.getParameterMap();
        try {
            orderService.addOrder(params);
        }
        catch (IllegalArgumentException err)
        {
            error(request,response, err.getMessage());
        }

        //toMyOrder(request, response);
        response.sendRedirect("toMyOrder");
    }

    protected void addMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Please, login as admin");
        }
        else {
            String name = request.getParameter("name");
            menuService.addMenu(name);
//            toMenuEditor(request, response);
            response.sendRedirect("toMenuEditor");
        }
    }

    protected void removeMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Please, login as admin");
        }
        else {
            Integer menuId = Integer.parseInt(request.getParameter("menuId"));
            Menu menu = menuService.getMenuById(menuId);
            menuService.removeMenu(menu);
//            toMenuEditor(request, response);
            response.sendRedirect("toMenuEditor");
        }
    }

    protected void addMenuElement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Please, login as admin");
        }
        else {
            String name = request.getParameter("name");
            Integer price = Integer.parseInt(request.getParameter("price"));
            String imageUrl = request.getParameter("imageUrl");
            String description = request.getParameter("description");
            Integer menuId = Integer.parseInt(request.getParameter("menuId"));
            Menu menu = menuService.getMenuById(menuId);
            menuService.addMenuElement(menu, name, imageUrl, price, description);
//            toMenuEditor(request, response);
            response.sendRedirect("toMenuEditor");
        }
    }

    protected void removeMenuElement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Please, login as admin");
        }
        else {
            Map<String,String[]> params = request.getParameterMap();
            menuService.removeMenuElement(params);
//            toMenuEditor(request, response);
            response.sendRedirect("toMenuEditor");
        }
    }

    protected void toMyOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        Collection<Order> orders = orderService.getAllOrders();
        if(orders != null){
            request.setAttribute("orders", orders);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/myOrder.jsp").forward(request, response);
    }

    protected void toCustomerOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Please, login as admin");
        }
        else{
            Collection<Order> orders = orderService.getAllOrders();
            if(orders != null){
                request.setAttribute("orders", orders);
            }
            request.getRequestDispatcher("/WEB-INF/jsp/customerOrders.jsp").forward(request, response);
        }

    }

    protected void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(!(boolean)request.getSession().getAttribute("isAdmin"))
        {
            error(request, response,"Please, login as admin");
        }
        else{
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));
            Order order = orderService.getOrderById(orderId);
            orderService.removeOrder(order);
            toCustomerOrders(request, response);
        }
    }

    protected void setTable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().setAttribute("tableNumber",request.getParameter("tableNumber"));
        //toMyOrder(request, response);
        response.sendRedirect("toMyOrder");
    }

    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}