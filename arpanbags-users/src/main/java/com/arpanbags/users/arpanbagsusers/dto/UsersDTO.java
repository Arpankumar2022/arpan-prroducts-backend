package com.arpanbags.users.arpanbagsusers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

    private Long Id;

    private String userName;

    private String userPassword;

    private String address;

    private String city;

    private String mobileNo;

    private String emailId;

}
