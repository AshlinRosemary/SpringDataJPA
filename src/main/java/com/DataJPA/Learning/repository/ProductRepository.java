package com.DataJPA.Learning.repository;

import com.DataJPA.Learning.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

/* Below method will search for Product by name ,
if  found the product entry will
 be returned ,otherwise will be returning null*/
    public Product findByName(String name);

    Optional<Product> findById(Long Id);

    //List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameOrDescription(String name, String description);
    List<Product> findByNameAndDescription(String name, String description);

    public Product findDistinctByName(String Name);

    public List<Product> findByPriceGreaterThan(BigDecimal price);
    public List<Product> findByPriceLessThan(BigDecimal price);
    public List<Product> findByNameContaining(String name);
   // public List<Product> findByNameContainingMethod(String name);
}
