package com.example.springsecurityjwtdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name ="USER_TABLE")
public class MyUser {
    @Id
    private int id;
    private String username;
    private String password;
}
