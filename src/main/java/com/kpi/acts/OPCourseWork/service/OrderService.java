package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.model.MenuElement;
import com.kpi.acts.OPCourseWork.model.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface OrderService {
    Collection<Order> getAllOrders();
    HashMap<MenuElement, Integer> getAllOrderedElements(Order order);
    Order getOrderById(Integer orderId);
    void removeOrder(Order order);
    void addOrder(Map<String,String[]> params);

}
