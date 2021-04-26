package com.kpi.acts.OPCourseWork.model;

import java.util.HashMap;
import java.util.TreeMap;

public class Order {
    private int tableNumber;
    private String customerName;
    private HashMap<MenuElement, Integer> orderedElements;

    public Order(int tableNumber, String customerName, HashMap<MenuElement, Integer> orderedElements) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.orderedElements = orderedElements;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
