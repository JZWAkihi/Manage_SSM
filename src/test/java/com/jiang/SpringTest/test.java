package com.jiang.SpringTest;

import com.jiang.controller.IProductController;
import com.jiang.dao.IProductDao;
import com.jiang.domain.Product;
import com.jiang.service.IProductService;
import com.jiang.service.Impl.IProductServiceImpl;
import com.jiang.utils.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class test {

    @Test
    public void Test() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IProductService bean = context.getBean(IProductService.class);

        Product product = new Product();
        product.setProductNum("001");
        product.setDepartureTime(new Date());
        product.setProductStatus(1);
        product.setProductPrice(500.00);
        product.setProductName("重庆");
        product.setProductDesc("重庆一日游");
        product.setCityName("重庆");

        bean.save(product);
    }
}
