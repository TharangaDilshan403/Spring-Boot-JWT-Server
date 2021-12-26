package com.practical.test.jwt.service;

import com.practical.test.jwt.entity.User;
import com.practical.test.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User fetchUserById(int userId) {
        return userRepository.findById(userId).get();
    }
}
