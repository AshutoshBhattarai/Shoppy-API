package com.application.shopapi.Products;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "category")
    List<ProductModel> products = new ArrayList<>();

}
