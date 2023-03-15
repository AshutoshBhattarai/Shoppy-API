package com.application.shopapi.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);


    @GetMapping
    public String userHome() {
        return "Welcome to the user home page";
    }

    @GetMapping("/get/all")
    public List<UserModel> getUser() {
        return userService.getUser();
    }

    @PostMapping("/insert")
    public UserModel addUser(@RequestBody UserModel user) {
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public UserModel getUserById(@PathVariable UUID id) {

        return userService.getUserById(id);
    }
}
