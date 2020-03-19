package com.service;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.domain.Order;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public void save(String title, Double price) {
        List<Order> orders = orderDao.getAll();
        Order order = new Order();
        order.setPrice(price);
        order.setTitle(title);
        if(!orders.isEmpty()) {
            Order lastOrder = orders.get(orders.size()-1);
            order.setId(lastOrder.getId()+1);
        } else {
            order.setId(1);
        }
        orderDao.save(order);
    }

    @Override
    public void delete(Integer id) {
        Order order = orderDao.getById(id);
        orderDao.delete(order);
    }

    @Override
    public Order getById(Integer id) {
        return orderDao.getById(id);
    }

    @Override
    public void update(Integer id, String title, Double price) {
        Order order = orderDao.getById(id);
        order.setTitle(title);
        order.setPrice(price);
        System.out.println(order.toString());
    }
}
