package com.example.reminder.services;

import com.example.reminder.models.UserModel;

public interface UserService {
    public UserModel getUser(String username,String password);
    public void saveUser(UserModel userModel);
    public boolean checkUsername(String username);
    public boolean checkEmail(String email);
}
