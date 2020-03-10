package com.controller;

import com.domain.Order;
import com.service.OrderService;
import com.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
public class OrderController {

    private OrderService orderService = new OrderServiceImpl();

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrderPage(Locale locale, Model model){
        List<Order> orders = orderService.getAll();
        model.addAttribute("orderList", orders);
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);
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

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String addUpdateOrderPage(){
        return "updateOrder";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateOrder(@PathVariable Integer id,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "price") Double price){
        orderService.update(id, title, price);
        return "redirect:/";
    }

}
