package com.application.shopapi.Products;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    int id;
    String title;
    @OneToOne(mappedBy = "category")
    ProductModel products;

}
