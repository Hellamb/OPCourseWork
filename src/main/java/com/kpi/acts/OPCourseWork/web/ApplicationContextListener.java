package com.kpi.acts.OPCourseWork.web;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.dao.inmemory.InMemoryDatabase;
import com.kpi.acts.OPCourseWork.service.MenuService;
import com.kpi.acts.OPCourseWork.service.MenuServiceImplementation;
import com.kpi.acts.OPCourseWork.service.OrderService;
import com.kpi.acts.OPCourseWork.service.OrderServiceImplementation;
import javax.servlet.*;

public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        InMemoryDatabase database = new InMemoryDatabase();
        DaoFactory daoFactory = database.getDaoFactory();

        MenuService menuService = new MenuServiceImplementation(daoFactory);
        sce.getServletContext().setAttribute("menuService", menuService);

        OrderService orderService = new OrderServiceImplementation(daoFactory);
        sce.getServletContext().setAttribute("orderService", orderService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}