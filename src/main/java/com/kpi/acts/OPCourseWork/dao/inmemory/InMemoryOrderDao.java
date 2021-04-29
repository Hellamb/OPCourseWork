package com.kpi.acts.OPCourseWork.dao.inmemory;

//import com.kpi.acts.OPCourseWork.dao.MenuElementDao;
import com.kpi.acts.OPCourseWork.dao.OrderDao;
import com.kpi.acts.OPCourseWork.model.Menu;
import com.kpi.acts.OPCourseWork.model.MenuElement;
import com.kpi.acts.OPCourseWork.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class InMemoryOrderDao extends InMemoryAbstractDao<Order> implements OrderDao {
    public InMemoryOrderDao( InMemoryDatabase database) {
        super(database.order, Order::getOrderId, Order::setOrderId, database);
    }

    @Override
    public void addOrder(Integer tableNumber, String customerName, HashMap<MenuElement, Integer> orderedElements) {
        Order order = new Order(-1,tableNumber, customerName, orderedElements);
        this.insert(order, true);
    }

    @Override
    public void removeOrder(Order order) {
        this.delete(order);
    }
}
