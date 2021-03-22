package com.jiang.controller;

import com.jiang.domain.Product;
import com.jiang.service.Impl.IProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class IProductController {

    @Autowired
    private  IProductServiceImpl iProductService;

    @RequestMapping("/findAll")
    public String findAll(){
        List<Product> list = iProductService.findAll();
        System.out.println(list.toString());
        return list.toString();
    }
}
