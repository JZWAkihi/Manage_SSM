package com.jiang.dao;

import com.jiang.domain.Orders;
import com.jiang.domain.Traveller;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdersDao {

    List<Orders> findAll();


    Orders findById(String id);

    Traveller findAllTraveller(Integer orderId);
}
