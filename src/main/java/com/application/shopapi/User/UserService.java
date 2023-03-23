package com.application.shopapi.User;

import com.application.shopapi.Admin.AdminModel;
import com.application.shopapi.Admin.AdminRepo;
import com.application.shopapi.Customer.CustomerModel;
import com.application.shopapi.Customer.CustomerRepo;
import com.application.shopapi.ExtraModel.Role;
import com.application.shopapi.User.RequestHandler.AdminResponse;
import com.application.shopapi.User.RequestHandler.UserRequest;
import com.application.shopapi.User.RequestHandler.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final CustomerRepo customerRepo;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    public List<UserModel> getUser() {
        return userRepo.findAll();
    }

    public UserModel addUser(UserModel user) {
        return userRepo.save(user);
    }

    public UserModel getUserById(UUID id) {
        return userRepo.findUserById(id);
    }

    public String updateUser(UUID id, String name) {
        userRepo.updateUserName(name, id);
        return "Updated Successfully";
    }

    public String deleteUser(UserModel user) {
        userRepo.delete(user);
        return "Successfully Deleted";
    }

    public String saveUser(UserRequest req) {
        try {
            UserModel user = new UserModel();
            user.setUsername(req.getUsername());
            user.setPassword(passwordEncoder.encode(req.getPassword()));
            user.setEmail(req.getEmail());
            user.setRole(req.getRole());
            userRepo.save(user);
            if (req.getRole() == Role.CUSTOMER) {
                CustomerModel customerModel = new CustomerModel();
                customerModel.setUser(user);
                customerModel.setFirstname(req.getFirstname());
                customerModel.setLastname(req.getLastname());
                customerModel.setMiddlename(req.getMiddlename());
                customerModel.setAddress(req.getAddress());
                customerModel.setDob(req.getDob());
                customerRepo.save(customerModel);
                return "Customer inserted successfully";
            } else if (req.getRole() == Role.ADMIN) {
                AdminModel admin = new AdminModel();
                admin.setUser(user);
                admin.setFirstname(req.getFirstname());
                admin.setLastname(req.getLastname());
                admin.setMiddlename(req.getMiddlename());
                admin.setAddress(req.getAddress());
                admin.setDob(req.getDob());
                adminRepo.save(admin);
                return "Admin created successfully";
            }

        } catch (DataIntegrityViolationException e) {
            return e.getCause().getMessage();
        }
        return null;
    }

    public List<UserResponse> findCustomers() {
        return userRepo.findCustomers();
    }

    public List<AdminResponse> findAdmin(){ return userRepo.findAdmins();}

}
