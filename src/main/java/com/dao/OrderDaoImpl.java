package com.dao;

import com.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private List<Order> orders = new ArrayList<>();

    public OrderDaoImpl(){
        Order order1 = new Order();
        Order order2 = new Order();
        order1.setId(1);
        order2.setId(2);
        order1.setPrice(123d);
        order2.setPrice(12314.23);
        order1.setTitle("sadad");
        order2.setTitle("qweqwe");
        orders.add(order1);
        orders.add(order2);
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public void delete(Order order) {
        orders.remove(order);
    }

    @Override
    public Order getById(Integer id) {
        return orders.get(id);
    }
}
