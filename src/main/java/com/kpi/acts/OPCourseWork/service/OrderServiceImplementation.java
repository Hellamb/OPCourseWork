package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.model.MenuElement;
import com.kpi.acts.OPCourseWork.model.Order;

import java.util.Collection;
import java.util.HashMap;

public class OrderServiceImplementation implements OrderService{

    DaoFactory daoFactory;

    public OrderServiceImplementation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Collection<Order> getAllOrders() {
        return daoFactory.getOrderDao().findAll();
    }

    @Override
    public HashMap<MenuElement, Integer> getAllOrderedElements(Order order) {
        return order.getOrderedElements();
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return daoFactory.getOrderDao().get(orderId);
    }

    @Override
    public void removeOrder(Order order) {
        daoFactory.getOrderDao().removeOrder(order);
    }

    @Override
    public void addOrder(Integer tableNumber, String customerName, HashMap<MenuElement, Integer> orderedElements) {
        daoFactory.getOrderDao().addOrder(tableNumber, customerName,orderedElements);
    }
}
