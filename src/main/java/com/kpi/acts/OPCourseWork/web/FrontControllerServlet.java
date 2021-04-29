package com.kpi.acts.OPCourseWork.web;

import com.kpi.acts.OPCourseWork.model.*;
import com.kpi.acts.OPCourseWork.service.*;
import java.io.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FrontControllerServlet", urlPatterns = "/control/*")
public class FrontControllerServlet extends HttpServlet {

    OrderService orderService;
    MenuService menuService;

    public void init(ServletConfig config) throws ServletException {
        orderService = (OrderService) config.getServletContext().getAttribute("orderService");
        menuService = (MenuService) config.getServletContext().getAttribute("menuService");

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
        menuService.addMenu("My menu 1");
        menuService.addMenu("My menu 2");
        for (Menu menu: menus) {
            menuService.addMenuElement(menu,"element 1", "url", menu.getMenuId());
            menuService.addMenuElement(menu,"element 2", "url", 15);
            menuService.addMenuElement(menu,"element 3", "url", 20);
            menuService.addMenuElement(menu,"element 4", "url", 25);

        }
        request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp").forward(request, response);
    }

    protected void adminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String password = request.getParameter("adminPassword");
        if(password.equals("admin")) {
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
        if((boolean)request.getSession().getAttribute("isAdmin"))
        {
            request.getRequestDispatcher("/WEB-INF/jsp/menuEditor.jsp").forward(request, response);
        }
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    protected void addMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    protected void removeMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    protected void addMenuElement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    protected void removeMenuElement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    protected void toMyOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/myOrder.jsp").forward(request, response);
    }

    protected void toCustomerOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if((boolean)request.getSession().getAttribute("isAdmin"))
        {
            request.getRequestDispatcher("/WEB-INF/jsp/customerOrders.jsp").forward(request, response);
        }
    }

    protected void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

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