package com.application.shopapi.Products;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class ProductModel {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    long id;
    String title;
    String description;
    double price;
    String image;
    int stock;
    float rating;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;


}
