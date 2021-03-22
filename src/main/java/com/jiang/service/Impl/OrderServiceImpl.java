package com.jiang.service.Impl;

import com.jiang.dao.OrdersDao;
import com.jiang.domain.Orders;
import com.jiang.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService {


    @Autowired
    private OrdersDao ordersDao;


    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }
}
