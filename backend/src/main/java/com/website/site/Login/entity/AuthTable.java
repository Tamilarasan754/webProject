package com.website.site.Login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="AuthTable")
@Data
public class AuthTable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String username;
    private String password;
    private String email;
    // public String getUsername() {
    //     return username;
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }
    
}
