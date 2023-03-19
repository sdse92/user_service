package com.sdse.user_service.service;

import com.sdse.user_service.model.User;
import com.sdse.user_service.model.UserRequest;
import com.sdse.user_service.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> createUser(UserRequest createRequest) {
        User newUser = setUserFromRequest(null, createRequest);
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUser(String id, UserRequest updateRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User updatedUser = setUserFromRequest(user.get(), updateRequest);
            userRepository.save(updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> getUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<User> deleteUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private User setUserFromRequest(User user, UserRequest request) {
        User updated = user;
        if (updated == null) {
            updated = new User();
        }
        if (request.getName() != null) {
            updated.setName(request.getName());
        }
        if (request.getLogin() != null) {
            updated.setLogin(request.getLogin());
        }
        if (request.getPassword() != null) {
            updated.setPassword(request.getPassword());
        }
        if (request.getEmail() != null) {
            request.setEmail(request.getEmail());
        }
        if (request.getPhone() != null) {
            request.setPhone(request.getPhone());
        }
        return updated;
    }
}
