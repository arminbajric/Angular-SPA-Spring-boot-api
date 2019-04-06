package com.example.reminder.controllers;

import com.example.reminder.models.RemindersModel;
import com.example.reminder.security.JwtUtillity;
import com.example.reminder.services.RemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
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

       return ResponseEntity.ok().body(remindersService.getAllByUserEmail(jwtUtillity.extractEmail(token)));
    }
    @RequestMapping(value="/app/create-new-reminder",method = RequestMethod.POST)
    public ResponseEntity createReminder(@RequestBody RemindersModel remindersModel)
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat();
        String datePattern="dd.MM.yyyy";
        dateFormat.applyPattern(datePattern);
        remindersModel.setDoc(dateFormat.format(new Date()));
        remindersService.saveReminder(remindersModel);
        return ResponseEntity.status(200).build();
    }
}
