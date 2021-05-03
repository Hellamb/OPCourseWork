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
                case "":
                default:
                    menu(request, response);
                    break;

            }
        }catch (RuntimeException ex)
        {
            //response.sendError(401,ex.getMessage());
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
        if(! isTestData){
            isTestData = true;
            menuService.addMenu("My menu 1");
            menuService.addMenu("My menu 2");
            for (Menu menu: menus)
            {
                menuService.addMenuElement(menu,"Dish for 10", "url", 10,"Description for 10");
                menuService.addMenuElement(menu,"Dish for 15", "url", 15,"Description for 15");
                menuService.addMenuElement(menu,"Dish for 20", "url", 20,"Description for 20");
                menuService.addMenuElement(menu,"Dish for 25", "url", 25,"Description for 25");
            }
        }
        request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
    }

    protected void adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String password = request.getParameter("adminPassword");
        if(!password.equals("admin")) {
            error(request,response,"Пароль не вірний");
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
            error(request, response,"Ви не адміністратор");
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

        toMyOrder(request, response);
    }

    protected void addMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Ви не адміністратор");
        }
        else {
            String name = request.getParameter("name");
            menuService.addMenu(name);
            toMenuEditor(request, response);
        }
    }

    protected void removeMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Ви не адміністратор");
        }
        else {
            Integer menuId = Integer.parseInt(request.getParameter("menuId"));
            Menu menu = menuService.getMenuById(menuId);
            menuService.removeMenu(menu);
            toMenuEditor(request, response);
        }
    }

    protected void addMenuElement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Ви не адміністратор");
        }
        else {
            String name = request.getParameter("name");
            Integer price = Integer.parseInt(request.getParameter("price"));
            String imageUrl = request.getParameter("imageUrl");
            String description = request.getParameter("description");
            Integer menuId = Integer.parseInt(request.getParameter("menuId"));
            Menu menu = menuService.getMenuById(menuId);
            menuService.addMenuElement(menu, name, imageUrl, price, description);
            toMenuEditor(request, response);
        }
    }

    protected void removeMenuElement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        boolean isAdmin = (boolean)request.getSession().getAttribute("isAdmin");
        if(!isAdmin)
        {
            error(request, response,"Ви не адміністратор");
        }
        else {
            Map<String,String[]> params = request.getParameterMap();
            menuService.removeMenuElement(params);
            toMenuEditor(request, response);
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
            error(request, response,"Ви не адміністратор");
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
            error(request, response,"Ви не адміністратор");
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
        toMyOrder(request, response);
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