package com.jiang.SpringTest;

import com.jiang.dao.OrdersDao;
import com.jiang.domain.Orders;
import com.jiang.service.IProductService;
import com.jiang.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class SrerviceTest {

    @Autowired
    private OrdersService ordersService;

    @Test
    public void test(){
        Orders byId = ordersService.findById(1);
        System.out.println(byId);
    }



    @Test
    public void test1(){
        List<Orders> list = ordersService.findAll(1, 4);
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }

}
