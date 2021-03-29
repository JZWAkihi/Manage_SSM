package com.jiang.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jiang.dao.OrdersDao;
import com.jiang.domain.Orders;
import com.jiang.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrdersService {


    @Autowired
    private OrdersDao ordersDao;


    @Override
    public List<Orders> findAll(Integer page,Integer size) {
        //参数pageNum 时页码值  参数pageSize 是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }


    @Override
    public Orders findById(String id) {
        System.out.println(id);

        System.out.println(ordersDao.findById(id));

        return ordersDao.findById(id);
    }
}
