package com.example.reminder.repository;

import com.example.reminder.models.RemindersModel;
import com.example.reminder.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RemindersRepository extends MongoRepository<RemindersModel,Long> {
    public List<RemindersModel> getAllByUserModel(UserModel userModel);
    public List<RemindersModel> getAllBy(String email);
}
