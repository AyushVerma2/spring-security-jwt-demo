package com.example.springsecurityjwtdemo.repo;

import com.example.springsecurityjwtdemo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * this is user repository to read the vlaue from DB (H2 here)
 */
@Repository
public interface UserRepo extends JpaRepository<MyUser,Integer> {
    MyUser findByUsername(String username);
}
