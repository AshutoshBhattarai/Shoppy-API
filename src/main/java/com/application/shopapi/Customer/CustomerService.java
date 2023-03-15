package com.application.shopapi.Customer;

import com.application.shopapi.User.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public List<CustomerModel> getAllCust()
    {
        return customerRepo.findAll();
    }
    public CustomerModel insertCust(CustomerModel customer)
    {
        return customerRepo.save(customer);
    }
}
