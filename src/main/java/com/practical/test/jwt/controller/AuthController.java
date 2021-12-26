package com.practical.test.jwt.controller;

import com.practical.test.jwt.dto.AuthDTO;
import com.practical.test.jwt.utility.JWTUtility;
import com.practical.test.jwt.utility.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;



    //    jwt token generate api end point
    //  ====================================
    //    IN BODY ADD THIS VALUES
    //    ========================
    //    {
    //    "userName" : "admin",
    //    "userPassword" : "admin"
    //    }
    // ============= or  =============
    //    {
    //    "userName" : "user1",
    //    "userPassword" : "user1"
    //    }
    // ********** uri : http://localhost:8080/api/v1/auth **********
    @PostMapping
    public ResponseEntity generateToken(@RequestBody AuthDTO authDTO) throws  Exception{

        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.getUserName(),authDTO.getUserPassword())
        );
    }catch (Exception ex){
            throw new Exception("Invalid user name and password...");
        }
        String token =jwtUtility.generateToken(authDTO.getUserName());
        return new ResponseEntity(new StandardResponse(200,"Success",token), HttpStatus.CREATED);
    }


    //     jwt token testing  api end point
    //    ======================================
    //    IN HEADER ADD THIS VALUES
    //    ==========================
    //          keys              values
    //      Content-Type      application/json
    //      Authorization     Bearer {token}
    //
    // ********** uri : http://localhost:8080/api/v1/auth **********
    @GetMapping
    public ResponseEntity save(){
        return new ResponseEntity(new StandardResponse(200,"Success",null), HttpStatus.OK);
    }

}
