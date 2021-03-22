package com.jiang.service;

import com.jiang.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<Product> findAll();



    void save(Product product);

}
