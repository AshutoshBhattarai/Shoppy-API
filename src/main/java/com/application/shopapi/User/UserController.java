package com.application.shopapi.User;

import com.application.shopapi.ExtraModel.APIResponse;
import com.application.shopapi.ExtraModel.Role;
import com.application.shopapi.User.RequestHandler.AdminResponse;
import com.application.shopapi.User.RequestHandler.UserRequest;
import com.application.shopapi.User.RequestHandler.UserResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private final Logger log = LoggerFactory.getLogger(UserController.class);


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

    @PutMapping("/update")
    public String updateUser(@RequestBody UserModel user) {
        System.out.println(user);
        String name = user.getUsername();
        UUID id = user.getId();
        return userService.updateUser(id, name);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody UserModel user) {
        String msg = userService.deleteUser(user);
        return ResponseEntity
                .ok()
                .body(new APIResponse(HttpStatus.OK, 200, msg, LocalDateTime.now()));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody @Valid UserRequest req) {
        String msg = userService.saveUser(req);
        return ResponseEntity
                .ok()
                .body(new APIResponse(HttpStatus.OK, 200, msg, LocalDateTime.now()));
    }

    @GetMapping("/customer/all")
    public List<UserResponse> findCustomers() {
        return userService.findCustomers();
    }

    @GetMapping("/admin/all")
    public List<AdminResponse> findAdmin(){ return userService.findAdmin(); }
}
