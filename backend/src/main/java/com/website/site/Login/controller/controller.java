package com.website.site.Login.controller;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.site.Login.service.AuthService;
@RestController
public class controller {

   @Autowired
   AuthService authService;

    @GetMapping("/hello")
    public ResponseEntity hello()
    {
        Map<String, String> response = new HashMap<>(); response.put("name", "Hi Toko");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/auth")
    public ResponseEntity auth(JSONObject jsonObject )
    {
        String name=jsonObject.getString("uname");
        String password=jsonObject.getString("password");
        String email=jsonObject.getString("uemail");

        try
        {
            String msg=authService.saveUser(name, email, password);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
    }


}