package com.application.shopapi.User;

import com.application.shopapi.Admin.AdminModel;
import com.application.shopapi.Admin.AdminRepo;
import com.application.shopapi.Customer.CustomerModel;
import com.application.shopapi.Customer.CustomerRepo;
import com.application.shopapi.User.RequestHandler.AdminRequest;
import com.application.shopapi.User.RequestHandler.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AdminRepo adminRepo;

    public List<UserModel> getUser()
    {
        return userRepo.findAll();
    }

    public UserModel addUser(UserModel user)
    {
        return userRepo.save(user);
    }
    public UserModel getUserById(UUID id)
    {
        return userRepo.findUserById(id);
    }

    public String updateUser(UUID id,String name)
    {
        userRepo.updateUserName(name,id);
        return "Updated Sucessfully";
    }

    public String deleteUser(UserModel user)
    {
      userRepo.delete(user);
      return "Sucessfully Deleted";
    }

    public boolean saveCustomer(CustomerRequest req)
    {
        UserModel user = new UserModel();
        user.setUsername(req.getUser().getUsername());
        user.setPassword(req.getUser().getPassword());
        user.setEmail(req.getUser().getEmail());
        user.setRole(req.getUser().getRole());
        userRepo.save(user);

        CustomerModel customerModel = new CustomerModel();
        customerModel.setUser(user);
        customerModel.setFirstname(req.getCustomer().getFirstname());
        customerModel.setLastname(req.getCustomer().getLastname());
        customerModel.setMiddlename(req.getCustomer().getMiddlename());
        customerModel.setDob(req.getCustomer().getDob());
        customerRepo.save(customerModel);
        return true;
    }

    public boolean saveAdmin(AdminRequest req)
    {
        UserModel user = new UserModel();
        user.setUsername(req.getUser().getUsername());
        user.setPassword(req.getUser().getPassword());
        user.setEmail(req.getUser().getEmail());
        user.setRole(req.getUser().getRole());
        userRepo.save(user);

        AdminModel admin = new AdminModel();
        admin.setUser(user);
        admin.setFirstname(req.getAdmin().getFirstname());
        admin.setLastname(req.getAdmin().getLastname());
        admin.setMiddlename(req.getAdmin().getMiddlename());
        admin.setDob(req.getAdmin().getDob());
        adminRepo.save(admin);
        return true;
    }

    public List<Object[]> findCustomers()
    {
        return userRepo.findCustomers();
    }

}
