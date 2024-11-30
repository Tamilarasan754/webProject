package com.website.site.Login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.website.site.Login.entity.AuthTable;
import com.website.site.Login.repository.AuthRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthSerImpl implements AuthService {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String saveUser(AuthTable authTable) {
        authTable.setPassword(passwordEncoder.encode(authTable.getPassword()));
        authRepository.save(authTable);
        return "success";
    }

    @Override
    public List<AuthTable> getAll() {

        List<AuthTable> authTableval = new ArrayList<AuthTable>();

        authTableval = authRepository.findAll();
        return authTableval;

    }

    public AuthTable loadUserByUsername(String username) {
        return authRepository.findByEmail(username);
    }

    public boolean checkPassword(AuthTable authTable, String rawPassword) {
        boolean isMatch = passwordEncoder.matches(rawPassword, authTable.getPassword()); 
         return isMatch;
    }

}
