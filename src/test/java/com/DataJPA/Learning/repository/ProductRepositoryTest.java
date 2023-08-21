package com.DataJPA.Learning.repository;

import com.DataJPA.Learning.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Test
    void saveMethod(){
        //create product object
        Product product=new Product();
        product.setName("Product1");
        product.setDescription("Product1 Description");
        product.setImageurl("product1 url");
        product.setSku("100AbC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        //save product
        Product savedObject=productRepository.save(product);
        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }
}