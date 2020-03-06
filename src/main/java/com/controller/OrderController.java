package com.controller;

import com.domain.Order;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService = new OrderServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Model model){
        List<Order> orders = orderService.getAll();
        model.addAttribute("orderList", orders);
        return "order";
    }

    @RequestMapping(value = "/add-new-order", method = RequestMethod.GET)
    public String addNewOrderPage(){
        return "addNewOrder";
    }

    @RequestMapping(value = "/add-new-order", method = RequestMethod.POST)
    public String addNewOrder(@RequestParam(value = "title") String title,
                           @RequestParam(value = "price") Double price){
        orderService.save(title, price);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable Integer id){
        orderService.delete(id);
        return "redirect:/";
    }

}
