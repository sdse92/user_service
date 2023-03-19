package com.sdse.user_service.controller;

import com.sdse.user_service.model.User;
import com.sdse.user_service.model.UserRequest;
import com.sdse.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController{

    UserService userService;

    UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody UserRequest createRequest) {
        return userService.createUser(createRequest);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,  @RequestBody UserRequest updateRequest) {
        return userService.updateUser(id, updateRequest);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @Override
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(id);
    }
}
