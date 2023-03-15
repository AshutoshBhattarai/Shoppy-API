package com.application.shopapi.User.RequestHandler;

import com.application.shopapi.Customer.CustomerModel;
import com.application.shopapi.User.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    UserModel user;
    CustomerModel customer;
}
