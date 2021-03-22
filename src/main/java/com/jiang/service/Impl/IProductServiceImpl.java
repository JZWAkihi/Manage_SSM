package com.jiang.service.Impl;

import com.jiang.dao.IProductDao;
import com.jiang.domain.Product;
import com.jiang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;


    @Override
    public List<Product> findAll() {
        System.out.println("----------------------------");
        System.out.println(iProductDao);
        return iProductDao.findAll();
    }


    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }
}
