package com.jiang.SpringTest;

import com.jiang.dao.OrdersDao;
import com.jiang.domain.Orders;
import com.jiang.domain.UserInfo;
import com.jiang.service.IProductService;
import com.jiang.service.OrdersService;
import com.jiang.service.RoleService;
import com.jiang.service.UserService;
import com.jiang.utils.BCryptPasswordEncoderUtils;
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

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Test
    public void test(){
        Orders byId = ordersService.findById("1");
        System.out.println(byId);
    }



    @Test
    public void test1(){
        List<Orders> list = ordersService.findAll(1, 4);
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }


    @Test
    public void test2(){
        UserInfo userInfo = new UserInfo();

        userInfo.setPassword("123");
        userInfo.setUsername("fox");
        userInfo.setEmail("qq@qq.com");
        userInfo.setPhoneNum("123456");
        userInfo.setStatus(1);

        userService.save(userInfo);

        System.out.println(userService.findAll());

    }


    @Test
    public void Test3(){
        List<UserInfo> all = userService.findAll();

        for (UserInfo userInfo: all) {
            System.out.println(userInfo);
        }

    }


    @Test
    public void test4(){
        System.out.println(BCryptPasswordEncoderUtils.encodePassword("admin"));
    }


    @Test
    public void test5(){
        System.out.println(userService.loadUserByUsername("admin"));
    }

    @Test
    public void test6(){
        System.out.println(roleService.findById("1"));
    }

}
