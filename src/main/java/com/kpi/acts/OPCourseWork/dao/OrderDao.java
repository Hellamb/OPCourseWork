package com.kpi.acts.OPCourseWork.dao;

import com.kpi.acts.OPCourseWork.model.MenuElement;
import com.kpi.acts.OPCourseWork.model.Order;

import java.util.HashMap;

public interface OrderDao extends AbstractDao<Order> {
    void addOrder(Integer tableNumber, String customerName, HashMap<MenuElement, Integer> orderedElements);
    void removeOrder(Order order);
}
