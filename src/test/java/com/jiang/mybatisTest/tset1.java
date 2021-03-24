package com.jiang.mybatisTest;

import com.jiang.dao.IProductDao;
import com.jiang.dao.OrdersDao;
import com.jiang.domain.Orders;
import com.jiang.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;


public class tset1 {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IProductDao bean = context.getBean(IProductDao.class);

        List<Product> list = bean.findAll();

        for (Product product : list) {
            System.out.println(product);
        }
    }


    @Test
    public void Test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrdersDao bean = context.getBean(OrdersDao.class);
        System.out.println(bean.findById(1).toString());

        List<Orders> list = bean.findAll();

        for (Orders o : list) {
            System.out.println(o);
        }
    }


    @Test
    public void Test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrdersDao bean = context.getBean(OrdersDao.class);
        System.out.println(bean.findAllTraveller(1));
    }
}
