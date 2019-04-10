package com.example.reminder.controllers;

import com.example.reminder.models.UserModel;
import com.example.reminder.security.JwtUtillity;
import com.example.reminder.services.UserService;

import com.mongodb.MongoCommandException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final JwtUtillity jwtUtillity;
    public UserController(UserService userService, JwtUtillity jwtUtillity) {
        this.userService = userService;

        this.jwtUtillity = jwtUtillity;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResponseEntity checkUser(@RequestParam(name = "email") String email,@RequestParam(name="password") String password)
    {
        if(userService.checkLogin(email, password))
        {
            String UserToken=jwtUtillity.generateJwt(email);
            return ResponseEntity.ok().header("UserToken",UserToken).body(userService.getUser(email));
        }
        else{
            return ResponseEntity.status(201).build();
        }
    }
    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserModel userModel)
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat();
        String pattern="dd.MM.yyyy";
        dateFormat.applyPattern(pattern);
        System.out.print(userModel.toString());
        try
        {
            userModel.setDor(dateFormat.format(new Date()));
            userService.saveUser(userModel);
        }
        catch(MongoCommandException e){
            System.out.print(userModel.toString());
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();


    }
    @RequestMapping(value="/check-username",method=RequestMethod.GET)
    public ResponseEntity checkUsername(@RequestParam(name = "username") String username)
    {
            if (userService.checkUsername(username)) {
                return ResponseEntity.status(201).build();
            }
           else{
            return ResponseEntity.status(200).build();
           }
    }
    @RequestMapping(value="/check-email",method=RequestMethod.GET)
    public ResponseEntity checkEmail(@RequestParam(name = "email") String email)
    {

        if(userService.checkEmail(email))
        {
            return ResponseEntity.status(201).build();
        }
        else
        {
            return ResponseEntity.status(200).build();
        }
    }
    @RequestMapping(value="/decode-jwt",method=RequestMethod.GET)
    public ResponseEntity getUsername(@RequestParam("token") String token)
    {
        String user;
        try {
            user = jwtUtillity.extractEmail(token);
        }catch(JwtException e){
            e.printStackTrace();
          return ResponseEntity.status(201).build();
        }


        String[] username=new String[]{userService.getUser(user).getUsername()};

         return ResponseEntity.status(200).body(username);
    }
}
