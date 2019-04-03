package com.example.reminder.repository;

import com.example.reminder.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel,Long> {
 public UserModel getUserModelByUsernameAndPassword(String username,String password);
 public UserModel getUserModelByUsername(String username);
 public UserModel getUserModelByEmail(String email);
}
