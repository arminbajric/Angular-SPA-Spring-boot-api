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
    public UserModel getUser(String username, String password) {
        return userRepository.getUserModelByUsernameAndPassword(username,password);
    }

    @Override
    public void saveUser(UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public UserModel checkUsername(String username) {
        return userRepository.getUserModelByUsername(username);
    }

    @Override
    public UserModel checkEmail(String email) {
        return userRepository.getUserModelByEmail(email);
    }
}
