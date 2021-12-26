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
public class AuthController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping
    public ResponseEntity save(){
        return new ResponseEntity(new StandardResponse(200,"Success",null), HttpStatus.OK);
    }


//    jwt
    @PostMapping("/authenticate")
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

}
