package com.practical.test.jwt.advisor;


import com.practical.test.jwt.utility.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleMethod(Exception ex){
        StandardResponse response=new StandardResponse(500,"Internal Server Error..",ex.getMessage());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
