package com.kpi.acts.OPCourseWork.service;

import com.kpi.acts.OPCourseWork.dao.DaoFactory;
import com.kpi.acts.OPCourseWork.model.MenuElement;
import com.kpi.acts.OPCourseWork.model.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    public Order getOrderById(Integer orderId) {
        return daoFactory.getOrderDao().get(orderId);
    }

    @Override
    public void removeOrder(Order order) {
        daoFactory.getOrderDao().removeOrder(order);
    }

    @Override
    public void addOrder(Map<String,String[]> params) {
        Integer tableNumber = Integer.parseInt(params.get("tableNumber")[0]);
        String customerName = params.get("customerName")[0];
        int size = params.get("name").length;
        HashMap<MenuElement, Integer> orderedElements = new HashMap<>();
        for(int i=0;i<size;i++)
        {
            String name = params.get("name")[i];
            String imageUrl = params.get("imageUrl")[i];
            Integer price = Integer.parseInt(params.get("price")[i]);
            String description = params.get("description")[i];
            Integer elementCount = Integer.parseInt(params.get("elementCount")[i]);
            if(elementCount>0)
            {
               MenuElement elem = new MenuElement(name, imageUrl, price, description);
               orderedElements.put(elem, elementCount);
            }
        }
        if(orderedElements.isEmpty()) {
            throw new IllegalArgumentException("Order is empty");
        }
        daoFactory.getOrderDao().addOrder(tableNumber, customerName, orderedElements);
    }
}
