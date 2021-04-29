package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.dao.MenuDao;
//import com.kpi.acts.OPCourseWork.dao.MenuElementDao;
import com.kpi.acts.OPCourseWork.dao.OrderDao;

class InMemoryDaoFactory implements DaoFactory {

    InMemoryDatabase database;
    //MenuElementDao menuElementDao;
    MenuDao menuDao;
    OrderDao orderDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;
        //menuElementDao = new InMemoryMenuElementDao(database);
        menuDao = new InMemoryMenuDao(database);
        orderDao = new InMemoryOrderDao(database);
    }

    //@Override
    //public MenuElementDao getMenuElementDao() {
    //    return menuElementDao;
    //}

    @Override
    public MenuDao getMenuDao() {
        return menuDao;
    }

    @Override
    public OrderDao getOrderDao()
    {
        return orderDao;
    }

}
