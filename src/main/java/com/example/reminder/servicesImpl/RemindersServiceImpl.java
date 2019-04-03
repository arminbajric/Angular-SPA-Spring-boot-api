package com.example.reminder.servicesImpl;

import com.example.reminder.models.RemindersModel;
import com.example.reminder.models.UserModel;
import com.example.reminder.services.RemindersService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RemindersServiceImpl implements RemindersService {

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
}
