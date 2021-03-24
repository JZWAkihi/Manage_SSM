package com.jiang.controller;

import com.github.pagehelper.PageInfo;
import com.jiang.domain.Orders;
import com.jiang.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService service;

    //查询全部订单未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView model = new ModelAndView();
//        List<Orders> list = service.findAll();
//        model.addObject("orderList",list);
//        model.setViewName("orders-page-list");
//
//        return model;
//    }


    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size){
        ModelAndView view = new ModelAndView();
        List<Orders> list = service.findAll(page, size);

        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);

        view.addObject("pageInfo",pageInfo);
        view.setViewName("orders-page-list");

        return view;
    }


}
