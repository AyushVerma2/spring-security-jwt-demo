package com.example.springsecurityjwtdemo;

import com.example.springsecurityjwtdemo.model.MyUser;
import com.example.springsecurityjwtdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityJwtDemoApplication {
	@Autowired
	UserRepo userRepo;

	// this will init db with these user as initial value
	@PostConstruct

	public void init(){
		List<MyUser> userlst = new ArrayList();
		userlst.add(new MyUser(1,"user1","user1"));
		userlst.add(new MyUser(2,"user2","user1"));
		userlst.add(new MyUser(3,"user3","user1"));
		userlst.add(new MyUser(4,"user4","user1"));
		userRepo.saveAll(userlst);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
	}

}
