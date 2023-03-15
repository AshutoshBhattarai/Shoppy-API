package com.application.shopapi.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @GetMapping("/all")
    public List<CustomerModel> getAllCust()
    {
        return service.getAllCust();
    }

    @PostMapping("/insert")
    public CustomerModel insert(@RequestBody CustomerModel customer)
    {
        return service.insertCust(customer);
    }

}
