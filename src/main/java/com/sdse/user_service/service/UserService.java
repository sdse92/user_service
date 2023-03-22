package com.sdse.user_service.service;

import com.sdse.user_service.model.User;
import com.sdse.user_service.model.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<User> createUser(UserRequest createRequest);

    public ResponseEntity<User> updateUser(String id, UserRequest updateRequest);

    public ResponseEntity<User> getUser(String id);

    public ResponseEntity<List<User>> getAllUsers();

    public ResponseEntity<User> deleteUser(String id);

}
