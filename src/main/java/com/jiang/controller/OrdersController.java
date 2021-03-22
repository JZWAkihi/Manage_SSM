package com.jiang.controller;

import com.jiang.domain.Orders;
import com.jiang.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService service;


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();
        List<Orders> list = service.findAll();
        model.addObject("",model);
        model.setViewName("");

        return model;
    }




}
