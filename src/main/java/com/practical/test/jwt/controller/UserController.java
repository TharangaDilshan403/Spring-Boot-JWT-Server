package com.practical.test.jwt.controller;

import com.practical.test.jwt.entity.User;
import com.practical.test.jwt.service.UserService;
import com.practical.test.jwt.utility.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    //     user details get end point
    //    ======================================
    //    IN HEADER ADD THIS VALUES
    //    ==========================
    //          keys              values
    //      Content-Type      application/json
    //      Authorization     Bearer {token}
    //
    // ********** uri : http://localhost:8080/api/v1/user/101 0r 102 **********

    @GetMapping(path = {"/{userId}"})
    public ResponseEntity getUser(@PathVariable int userId){
        User user = userService.fetchUserById(userId);
        return new ResponseEntity(new StandardResponse(200,"success",user), HttpStatus.OK);
    }
}
