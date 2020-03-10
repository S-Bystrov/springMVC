package com.service;

import com.domain.Order;

import java.util.List;

public interface OrderService {
    void save(String title, Double price);
    void delete(Integer id);
    List<Order> getAll();
    Order getById(Integer id);
    void update(Integer id, String title, Double price);
}
