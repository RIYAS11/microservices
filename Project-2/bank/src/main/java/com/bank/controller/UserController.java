package com.bank.controller;

import com.bank.exception.AccountException;
import com.bank.exception.UserException;
import com.bank.model.User;
import com.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService uService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){

        User us = uService.registerUser(user);

        return new ResponseEntity<User>(us , HttpStatus.ACCEPTED);
    }

    @PutMapping("/credit/{userid}/{amount}")
    public ResponseEntity<User> credit(@PathVariable int userid , @PathVariable long amount) {

           User us =   uService.credit(userid , amount);

           return new ResponseEntity<User>( us , HttpStatus.OK);
    }

    @PutMapping("/deposit/{userid}/{amount}")
    public ResponseEntity<User> debit(@PathVariable int userid , @PathVariable long amount) {

        User us = uService.deposit(userid , amount);

        return new ResponseEntity<User>(us , HttpStatus.OK);
    }

}
