package com.application.shopapi.User;

import com.application.shopapi.User.RequestHandler.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Objects;
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

    @PutMapping("/update")
    public String updateUser(@RequestBody UserModel user) {
        System.out.println(user);
        String name = user.getUsername();
        UUID id = user.getId();
        return userService.updateUser(id, name);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody UserModel user) {
        return userService.deleteUser(user);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerRequest req) {
        if (req.getUser().getRole() == UserModel.Role.CUSTOMER) {
            System.out.println(req);
            boolean isInserted = userService.saveCustomer(req);
            return ResponseEntity.ok().build();
        } else if (req.getUser().getRole() == UserModel.Role.ADMIN) {
            boolean isSaved = userService.saveCustomer(req);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/cust/all")
    public List<Object[]> findCustomers()
    {
        System.out.println(userService.findCustomers());
        return userService.findCustomers();
    }
}
