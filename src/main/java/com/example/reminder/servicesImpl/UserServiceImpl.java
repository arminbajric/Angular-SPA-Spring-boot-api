package com.example.reminder.servicesImpl;

import com.example.reminder.models.UserModel;
import com.example.reminder.repository.UserRepository;
import com.example.reminder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean checkLogin(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    @Override
    public void saveUser(UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public boolean checkUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserModel getUser(String email) {
        return userRepository.getUserModelByEmail(email);
    }
}
