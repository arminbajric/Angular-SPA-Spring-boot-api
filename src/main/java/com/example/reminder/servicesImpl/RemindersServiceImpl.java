package com.example.reminder.servicesImpl;

import com.example.reminder.models.RemindersModel;
import com.example.reminder.models.UserModel;
import com.example.reminder.repository.RemindersRepository;
import com.example.reminder.repository.UserRepository;
import com.example.reminder.services.RemindersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RemindersServiceImpl implements RemindersService {
    @Autowired
private final UserRepository userRepository;
    @Autowired
private final RemindersRepository remindersRepository;

    public RemindersServiceImpl(UserRepository userRepository, RemindersRepository remindersRepository) {
        this.userRepository = userRepository;
        this.remindersRepository = remindersRepository;
    }

    @Override
    public List<RemindersModel> getAllByUser(UserModel userModel) {
        return null;
    }

    @Override
    public List<RemindersModel> getAllByUserEmail(String email) {
        return null;
    }

    @Override
    public RemindersModel getReminderByTitle(String title) {
        return null;
    }

    @Override
    public void saveReminder(RemindersModel remindersModel) {
        remindersRepository.save(remindersModel);
    }
}
