package com.application.shopapi.Customer;

import com.application.shopapi.User.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class CustomerModel {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    UUID id;

    String firstname;
    String lastname;
    String middlename = "";
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
    @Column(updatable = false, nullable = false)
    LocalDate createdAt = LocalDate.now();
    LocalDate updatedAt = LocalDate.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    UserModel user;
}
