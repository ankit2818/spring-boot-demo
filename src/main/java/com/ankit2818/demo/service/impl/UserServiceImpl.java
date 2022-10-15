package com.ankit2818.demo.service.impl;

import com.ankit2818.demo.entity.User;
import com.ankit2818.demo.repository.UserRepository;
import com.ankit2818.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int userId) throws Exception {
        User user = null;
        try {
            user = userRepository.findById(userId).orElse(null);
            if(user == null) {
                throw new Exception("User is not found.");
            } else {
                userRepository.deleteById(userId);
            }
        } catch (Exception exception) {
            throw exception;
        }
        return user;
    }
}
