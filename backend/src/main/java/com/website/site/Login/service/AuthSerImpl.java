package com.website.site.Login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.site.Login.entity.AuthTable;
import com.website.site.Login.repository.AuthRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthSerImpl implements AuthService {

    @Autowired
    AuthRepository authRepository;

    @Override
    public String saveUser(AuthTable authTable) {
        authRepository.save(authTable);
        return "success";
    }

    @Override
    public List<AuthTable> getAll() {

        List<AuthTable> authTableval = new ArrayList<AuthTable>();

        authTableval = authRepository.findAll();
        return authTableval;

    }

}
