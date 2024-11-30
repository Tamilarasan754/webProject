package com.website.site.Login.controller;

import com.website.site.CORS.CustomAuthenticationProvider;
import com.website.site.Login.entity.AuthTable;
import com.website.site.Login.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CustomAuthenticationProvider authenticationManager;

    @GetMapping("/hello")
    public ResponseEntity<List<AuthTable>> hello() {
        List<AuthTable> msg = authService.getAll();
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> auth(@RequestBody AuthTable authTable) {
        try {
            String saveStatus = authService.saveUser(authTable);
            return new ResponseEntity<>(saveStatus, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @PostMapping("/login")
public ResponseEntity<Map<String, String>> login(@RequestBody AuthTable authTable) {
    Map<String, String> response = new HashMap<>();
    try {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authTable.getEmail(), authTable.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        response.put("message", "Login successful");
        return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        response.put("message", "Invalid credentials");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}

}
