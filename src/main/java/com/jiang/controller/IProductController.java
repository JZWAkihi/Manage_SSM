package com.jiang.controller;

import com.jiang.domain.Product;
import com.jiang.service.Impl.IProductServiceImpl;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.sound.sampled.Line;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class IProductController {

    @Autowired
    private  IProductServiceImpl iProductService;




    //添加产品
    @RequestMapping("/save.do")
    public String save(Product product){
        System.out.println(product.toString());
        log.info("-----------------------进入save方法-----------------------------");
        iProductService.save(product);
        return "redirect:findAll.do";
    }





    //查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView();
        List<Product> list = iProductService.findAll();

        //
        model.addObject("productList",list);
        //视图页面
        model.setViewName("product-list1");

        for (Product product : list) {
            System.out.println(product.getId());
        }

        System.out.println(model);

        return model;

    }
}
