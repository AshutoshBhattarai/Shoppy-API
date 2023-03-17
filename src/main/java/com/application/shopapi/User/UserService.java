package com.application.shopapi.User;

import com.application.shopapi.Admin.AdminModel;
import com.application.shopapi.Admin.AdminRepo;
import com.application.shopapi.Customer.CustomerModel;
import com.application.shopapi.Customer.CustomerRepo;
import com.application.shopapi.User.RequestHandler.UserRequest;
import com.application.shopapi.User.RequestHandler.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public boolean saveCustomer(UserRequest req)
    {
        UserModel user = new UserModel();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setRole(req.getRole());
        userRepo.save(user);

        CustomerModel customerModel = new CustomerModel();
        customerModel.setUser(user);
        customerModel.setFirstname(req.getFirstname());
        customerModel.setLastname(req.getLastname());
        customerModel.setMiddlename(req.getMiddlename());
        customerModel.setAddress(req.getAddress());
        customerModel.setDob(req.getDob());
        customerRepo.save(customerModel);
        return true;
    }

    public boolean saveAdmin(UserRequest req)
    {
        UserModel user = new UserModel();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setRole(req.getRole());
        userRepo.save(user);

        AdminModel admin = new AdminModel();
        admin.setUser(user);
        admin.setFirstname(req.getFirstname());
        admin.setLastname(req.getLastname());
        admin.setMiddlename(req.getMiddlename());
        admin.setDob(req.getDob());
        adminRepo.save(admin);
        return true;
    }

    public List<UserResponse> findCustomers()
    {
        return userRepo.findCustomers();
    }

}
