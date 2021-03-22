package com.jiang.mybatisTest;

import com.jiang.dao.IProductDao;
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
}
