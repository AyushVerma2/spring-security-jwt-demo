package com.example.springsecurityjwtdemo.srvices;

import com.example.springsecurityjwtdemo.model.MyUser;
import com.example.springsecurityjwtdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user =userRepo.findByUsername(username);
        //create user object provide by spring using credential give

        return new User(user.getUsername(),user.getPassword(),new ArrayList<>());

    }
}
