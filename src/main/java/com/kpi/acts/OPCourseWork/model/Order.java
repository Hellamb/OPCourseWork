package com.kpi.acts.OPCourseWork.model;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

public class Order {
    private Integer orderId;
    private Integer tableNumber;
    private String customerName;
    private HashMap<MenuElement, Integer> orderedElements;

    public Order(Integer orderId, Integer tableNumber, String customerName,HashMap<MenuElement, Integer> orderedElements) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.orderedElements = orderedElements;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public HashMap<MenuElement, Integer> getOrderedElements() {
        return orderedElements;
    }

    public void setOrderedElements(HashMap<MenuElement, Integer> orderedElements) {
        this.orderedElements = orderedElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId)
                && Objects.equals(tableNumber, order.tableNumber)
                && Objects.equals(customerName, order.customerName)
                && Objects.equals(orderedElements, order.orderedElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, tableNumber, customerName, orderedElements);
    }

}
