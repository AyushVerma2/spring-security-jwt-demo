package com.example.springsecurityjwtdemo.repo;

import com.example.springsecurityjwtdemo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<MyUser,Integer> {
    MyUser findByUsername(String username);
}
