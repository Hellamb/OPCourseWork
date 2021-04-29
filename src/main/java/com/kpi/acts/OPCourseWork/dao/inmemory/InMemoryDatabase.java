package com.kpi.acts.OPCourseWork.dao.inmemory;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;
import com.kpi.acts.OPCourseWork.model.Order;

import java.util.Map;
import java.util.TreeMap;

public class InMemoryDatabase {

    Map<Integer, MenuElement> menuElements;
    Map<Integer, Menu> menu;
    Map<Integer, Order> order;

    public InMemoryDatabase() {
        menuElements = new TreeMap<>();
        menu = new TreeMap<>();
        order = new TreeMap<>();
    }

    public DaoFactory getDaoFactory() {
        return new InMemoryDaoFactory(this);
    }

}
