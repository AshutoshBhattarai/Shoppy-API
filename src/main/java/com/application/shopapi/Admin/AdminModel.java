package com.application.shopapi.Admin;

import com.application.shopapi.User.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Admin")
public class AdminModel {
    @Id
    @GeneratedValue
    @Column(name = "admin_id")
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
    boolean isActive = true;

}