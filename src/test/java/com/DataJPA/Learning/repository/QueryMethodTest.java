package com.DataJPA.Learning.repository;

import com.DataJPA.Learning.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
     void  findByNameMethod(){
         Product product=productRepository.findByName("Product1");
         System.out.println(product.getId());
         System.out.println(product.getDescription());
         System.out.println(product.getName());
     }
@Test
     void findByIdMethod(){
        // Product product=productRepository.findById(1L).get();
    Optional<Product> product=productRepository.findById(1L);
            //System.out.println(product.getId());
            //System.out.println(product.getDescription());
    System.out.println(product);
     }
@Test
     void findByNameOrDescription(){
         List<Product> products=productRepository.findByNameOrDescription("Product1" ,
                 "Product1 Description");
         //System.out.println(products);
    products.forEach
            (p -> {
            System.out.println(p.getId());
            System.out.println(p.getDateCreated());
            }
            );
     }
@Test
     void findByNameAndDescription(){
        List<Product> products=productRepository.findByNameAndDescription("Product1" ,
                "Product1 Description");
        products.forEach(s->{
            System.out.println(s.getId());
            System.out.println(s.getDateCreated());
        });
     }
}
