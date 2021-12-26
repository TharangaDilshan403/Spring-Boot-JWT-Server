package com.practical.test.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    Integer userId;
    String userName;
    String userPassword;
    String fullName;
    String address;
    String emailAddress;
}
