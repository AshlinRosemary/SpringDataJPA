package com.DataJPA.Learning.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
      name = "products" ,
        schema = "ecommerce",
        uniqueConstraints = {
              @UniqueConstraint(
                      name = "sku_unique",
                      columnNames = "stock_keeping_unit"
              )
        }
)
public class Product {
//Plain old java object (POJO)
    //JPA annotation is given to make this class as Java Entity
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "stock_keeping_unit",nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageurl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}
