package com.example.reminder.repository;

import com.example.reminder.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,Long> {
 public boolean existsByUsernameAndPassword(String username,String password);
 public boolean existsByUsername(String username);
 public boolean existsByEmail(String email);
 public UserModel getUserModelByEmail(String email);
}
