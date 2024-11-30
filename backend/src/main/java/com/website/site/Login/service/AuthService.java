package com.website.site.Login.service;

import java.util.List;

import com.website.site.Login.entity.AuthTable;

public interface AuthService {

   public String saveUser(AuthTable authTable);
  public List<AuthTable> getAll();
  public AuthTable loadUserByUsername(String username);
  public boolean checkPassword(AuthTable authTable, String rawPassword);
  
    
}
