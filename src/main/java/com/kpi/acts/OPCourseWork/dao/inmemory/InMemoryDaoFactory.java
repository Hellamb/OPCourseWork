package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.dao.MenuDao;
import com.kpi.acts.OPCourseWork.dao.MenuElementDao;

class InMemoryDaoFactory implements DaoFactory {

    InMemoryDatabase database;
    MenuElementDao menuElementDao;
    MenuDao menuDao;

    InMemoryDaoFactory(InMemoryDatabase database) {
        this.database = database;
        menuElementDao = new InMemoryMenuElementDao(database);
        menuDao = new InMemoryMenuDao(database);
    }

    @Override
    public MenuElementDao getMenuElementDao() {
        return menuElementDao;
    }

    @Override
    public MenuDao getMenuDao() {
        return menuDao;
    }

}
