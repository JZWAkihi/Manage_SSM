package com.jiang.dao;

import com.jiang.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    List<Product> findAll();


}
