package com.jiang.SpringTest;

import com.jiang.controller.IProductController;
import com.jiang.dao.IProductDao;
import com.jiang.domain.Product;
import com.jiang.service.IProductService;
import com.jiang.service.Impl.IProductServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IProductController bean = context.getBean(IProductController.class);

        System.out.println(bean.findAll());

    }



}
