package com.DataJPA.Learning.repository;

import com.DataJPA.Learning.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
