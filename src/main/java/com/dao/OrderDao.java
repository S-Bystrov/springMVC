package com.dao;

import com.domain.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    void delete(Order order);
    List<Order> getAll();
    Order getById(Integer id);
}
