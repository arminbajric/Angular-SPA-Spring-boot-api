package com.example.reminder.controllers;

import com.example.reminder.services.RemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemindersController {
    @Autowired
    private final RemindersService remindersService;

    public RemindersController(RemindersService remindersService) {
        this.remindersService = remindersService;
    }
}
