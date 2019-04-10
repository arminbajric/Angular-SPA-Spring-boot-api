package com.example.reminder.controllers;

import com.example.reminder.models.RemindersModel;
import com.example.reminder.security.JwtUtillity;
import com.example.reminder.services.RemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class RemindersController {
    @Autowired
    private final RemindersService remindersService;
    @Autowired
    private final JwtUtillity jwtUtillity;

    public RemindersController(RemindersService remindersService, JwtUtillity jwtUtillity) {
        this.remindersService = remindersService;
        this.jwtUtillity = jwtUtillity;
    }
    @RequestMapping(value = "/app/get-user-reminders",method = RequestMethod.GET)
    public ResponseEntity getUserReminders(@RequestParam(name = "token")String token)
    {
        if(remindersService.checkIfUserHaveReminders(jwtUtillity.extractEmail(token)))
        {
            return ResponseEntity.status(200).body(remindersService.getAllByUserEmail(jwtUtillity.extractEmail(token)));
        }
        else
        {
            return ResponseEntity.status(201).build();
        }

    }
    @RequestMapping(value="/app/create-new-reminder",method = RequestMethod.POST)
    public ResponseEntity createReminder(@RequestBody RemindersModel remindersModel,@RequestHeader(value = "authorization") String token)
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat();
        String datePattern="dd.MM.yyyy";
        String dateOfExpiration=remindersModel.getDoe();
        dateFormat.applyPattern(datePattern);
        remindersModel.setDoc(dateFormat.format(new Date()));
        remindersModel.setUserEmail(jwtUtillity.extractEmail(token));
        remindersService.saveReminder(remindersModel);
        return ResponseEntity.status(200).build();
    }
    @RequestMapping(value="/app/get-upcoming",method = RequestMethod.GET)
    public ResponseEntity getUpcoming(@RequestHeader(value = "authorization")String token){

          if(remindersService.getUpcoming(jwtUtillity.extractEmail(token))!= null)
          {
             return ResponseEntity.status(200).body(remindersService.getUpcoming(jwtUtillity.extractEmail(token)));
          }
          else
          {
             return ResponseEntity.status(201).build();
          }
    }
}
