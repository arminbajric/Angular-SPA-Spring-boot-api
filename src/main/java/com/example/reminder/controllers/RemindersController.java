package com.example.reminder.controllers;

import com.example.reminder.services.RemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemindersController {
    @Autowired
    private final RemindersService remindersService;

    public RemindersController(RemindersService remindersService) {
        this.remindersService = remindersService;
    }
    @RequestMapping(value = "/app/my-reminders",method = RequestMethod.GET)
    public ResponseEntity getUserReminders(@RequestParam(name = "email")String email)
    {
       return ResponseEntity.ok().body(remindersService.getAllByUserEmail(email));
    }
}
