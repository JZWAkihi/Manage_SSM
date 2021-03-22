package com.jiang.dao;

import com.jiang.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdersDao {

    List<Orders> findAll();

}
