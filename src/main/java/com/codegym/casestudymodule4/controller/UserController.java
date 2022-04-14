package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

        @PostMapping("/validated/username")
    public ResponseEntity<?> validateUserName(@RequestBody User user) {
        if(userService.findByUsername(user.getUsername())!= null) {
            User userFindByUsername = userService.findByUsername(user.getUsername());
            return new ResponseEntity<>(userFindByUsername, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new User(), HttpStatus.OK);
        }
    }
}