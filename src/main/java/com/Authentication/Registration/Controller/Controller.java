package com.Authentication.Registration.Controller;

import com.Authentication.Registration.Modal.MyUser;
import com.Authentication.Registration.Modal.UserRequest;
import com.Authentication.Registration.Service.MyUserDetailService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class Controller {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/login")

    public ResponseEntity<String> login(@RequestBody UserRequest userRequest) {
        String name = userRequest.getName();
        String password = userRequest.getPassword();
        if (myUserDetailService != null && passwordEncoder.matches(password,myUserDetailService.loadUserByUsername(name).getPassword())) {

            return new ResponseEntity<>("Logged in...", HttpStatus.OK);
        }


            return new ResponseEntity<>("Login failed", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/register")

    public ResponseEntity<String> register( @RequestBody MyUser myUser){
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
       return myUserDetailService.register(myUser);
    }
}







