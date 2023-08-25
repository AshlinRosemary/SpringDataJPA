package com.DataJPA.Learning.repository;

import com.DataJPA.Learning.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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
@Test
     void findDistinctByName(){
    Product product=productRepository.findDistinctByName("Product1");
    System.out.println(product.getName());
    System.out.println(product.getLastUpdated());
     }
@Test
     void findByPriceGreaterThan(){
        List<Product>  products=productRepository.findByPriceGreaterThan(new BigDecimal(100));

        products.forEach(p->{
            System.out.println(p.getName());
            System.out.println(p.getId());
        });
     }
     @Test
     void findByPriceLessThan(){
        List<Product> products=productRepository.findByPriceLessThan(new BigDecimal(300));
        products.forEach(ps ->{
            System.out.println(ps.getName());
            System.out.println(ps.getId());
        } );
     }
/*@Test
     void findByNameContainingMethod(String name){
        List<Product> products=productRepository.findByNameContainingMethod("Product1");
    products.forEach((p )->{
        System.out.println(p.getName());
        System.out.println(p.getId());
    } );
     }
*/
@Test
void findByNameContaining() {
    List<Product> products = productRepository.findByNameContaining("Product1");
    products.forEach(p -> {
        System.out.println(p.getName());
        System.out.println( p.getId());
    });
}

}
