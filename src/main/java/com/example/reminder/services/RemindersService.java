package com.example.reminder.services;

import com.example.reminder.models.RemindersModel;
import com.example.reminder.models.UserModel;

import java.util.List;

public interface RemindersService {
    public List<RemindersModel> getAllByUser(UserModel userModel);
    public List<RemindersModel> getAllByUserEmail(String email);
    public RemindersModel getReminderByTitle(String title);
}
