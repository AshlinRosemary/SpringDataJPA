package com.DataJPA.Learning.repository;

import com.DataJPA.Learning.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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
    @Test
    void updateMethod(){
        //find entity by id
        Long id=1L;
        Product product=productRepository.findById(id).get();
        //update entity
        product.setName("UpdatedName_1");
        product.setDescription("UpdatedDescription_1");
        //save entity
        productRepository.save(product);
    }
    @Test
    void findbyIDMethod(){
        Long id=1L;
        Product product=productRepository.findById(id).get();
    }
    @Test
    void saveAllMethod(){
        Product product2=new Product();
        product2.setName("Product2");
        product2.setDescription("Product2 Description");
        product2.setImageurl("product2 url");
        product2.setSku("200AbC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);

        Product product3=new Product();
        product3.setName("Product3");
        product3.setDescription("Product3 Description");
        product3.setImageurl("product3 url");
        product3.setSku("300AbC");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);

        productRepository.saveAll(List.of(product2,product3));
    }
    @Test
    void findAllMethod() {
        List<Product>  products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

}