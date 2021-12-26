package com.practical.test.jwt.service;

import com.practical.test.jwt.entity.User;

public interface UserService {

    public User fetchUserById(int userId);
}
