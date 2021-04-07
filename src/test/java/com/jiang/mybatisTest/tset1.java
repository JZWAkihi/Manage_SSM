package com.jiang.mybatisTest;

import com.jiang.dao.IProductDao;
import com.jiang.dao.OrdersDao;
import com.jiang.dao.RoleDao;
import com.jiang.dao.UserDao;
import com.jiang.domain.Orders;
import com.jiang.domain.Product;
import com.jiang.domain.Role;
import com.jiang.domain.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class tset1 {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1(){

        IProductDao bean = context.getBean(IProductDao.class);

        List<Product> list = bean.findAll();

        for (Product product : list) {
            System.out.println(product);
        }
    }


    @Test
    public void Test1(){

        OrdersDao bean = context.getBean(OrdersDao.class);
        System.out.println(bean.findById("2").toString());
    }


    @Test
    public void Test2(){

        OrdersDao bean = context.getBean(OrdersDao.class);
        System.out.println(bean.findAllTraveller(1));
    }

    @Test
    public void Test3(){

        UserDao bean = context.getBean(UserDao.class);
        System.out.println(bean.findByUsername("admin"));

    }


    @Test
    public void Test4(){

        UserDao userDao = context.getBean(UserDao.class);
        List<UserInfo> all = userDao.findAll();

        for (UserInfo user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void Test5(){

        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao.findRoles("1"));
    }

    @Test
    public void Test6(){
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao.findById("1"));
    }

    @Test
    public void Test7(){
        RoleDao roleDao = context.getBean(RoleDao.class);
        System.out.println(roleDao.findAll());
    }


    @Test
    public void Test8(){
        RoleDao roleDao = context.getBean(RoleDao.class);
        System.out.println(roleDao.findById("1"));

    }


}
