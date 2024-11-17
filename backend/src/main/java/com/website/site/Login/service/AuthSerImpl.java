package com.website.site.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.site.Login.entity.AuthTable;
import com.website.site.Login.repository.AuthRepository;

@Service
public class AuthSerImpl implements AuthService {

    @Autowired
    AuthRepository authRepository;

    @Override
    public String saveUser(String name,String email,String password)
    {
        AuthTable table=new AuthTable();
        table.setUsername(name);
        table.setEmail(email);
        table.setPassword(password);
        authRepository.save(table);
        return "success";
    }
    
}
