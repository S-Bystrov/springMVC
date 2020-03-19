package com.controller;

import com.domain.Order;
import com.service.OrderService;
import com.service.OrderServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Controller
public class OrderController {


    private OrderService orderService = new OrderServiceImpl();


    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String addUpdateOrderPage(@PathVariable Integer id){
        return "updateOrder";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateOrder(@PathVariable Integer id,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "price") Double price){
        orderService.update(id, title, price);
        return "redirect:/";
    }

}
