package com.application.shopapi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

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

}
