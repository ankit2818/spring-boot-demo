package com.ankit2818.demo.controller;

import com.ankit2818.demo.entity.User;
import com.ankit2818.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = null;
        try {
            userList = userService.getAllUsers();
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
        User user = null;
        try {
            user = userService.getUserById(userId);
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/addOrUpdateUser", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<User> addOrUpdateUser(@RequestBody User newUser) {
        User user = null;
        try {
            user = userService.addOrUpdateUser(newUser);
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> addOrUpdateUser(@PathVariable("id") int userId) {
        User user = null;
        try {
            user = userService.deleteUser(userId);
        } catch (Exception exception) {
            exception.getMessage();
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
