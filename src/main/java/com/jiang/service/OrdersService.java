package com.jiang.service;

import com.jiang.domain.Orders;

import java.util.List;

public interface OrdersService  {

    List<Orders> findAll(Integer page,Integer size);

    Orders findById(Integer id);

}
