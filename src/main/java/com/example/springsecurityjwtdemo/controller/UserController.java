package com.example.springsecurityjwtdemo.controller;

import com.example.springsecurityjwtdemo.model.AuthRequest;
import com.example.springsecurityjwtdemo.model.MyUser;
import com.example.springsecurityjwtdemo.repo.UserRepo;
import com.example.springsecurityjwtdemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this class is responsible for test the rest endpoints
 */
@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome user.. you are  authenticate user  !!";
    }
    @GetMapping("/user")
    public String getUser(@RequestParam String user) {
        return "User detail  :: "+userRepo.findByUsername(user) ;
    }

    @GetMapping("/alluser")
    public List<MyUser> getAllUser() {
        return userRepo.findAll() ;
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody MyUser myuser
    ) {
        MyUser myUser =userRepo.save(myuser) ;
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
