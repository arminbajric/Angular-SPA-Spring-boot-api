package com.example.reminder.services;

import com.example.reminder.models.SecretKeyModel;
import com.example.reminder.models.UserModel;

public interface UserService {
    public boolean checkLogin(String username,String password);
    public void saveUser(UserModel userModel);
    public boolean checkUsername(String username);
    public boolean checkEmail(String email);
    public UserModel getUser(String email);
    public SecretKeyModel getKey();
}
