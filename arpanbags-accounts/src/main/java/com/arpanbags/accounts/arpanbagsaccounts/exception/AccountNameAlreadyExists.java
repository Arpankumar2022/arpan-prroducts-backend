package com.arpanbags.accounts.arpanbagsaccounts.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AccountNameAlreadyExists extends  RuntimeException{
    public AccountNameAlreadyExists(String message){
        super(message);
    }


}
