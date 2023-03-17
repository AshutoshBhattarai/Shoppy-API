package com.application.shopapi.Orders;

import com.application.shopapi.Customer.CustomerModel;
import com.application.shopapi.ExtraModel.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue
    UUID id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "delivery_date")
    LocalDate deliveryDate;
    @Column(name = "order_date")
    LocalDate orderDate = LocalDate.now();
    double total;
    Status status;
    @Column(name = "confirm_code")
    int confirmCode;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    CustomerModel customer;


}
