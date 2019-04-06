package com.example.reminder.repository;

import com.example.reminder.models.SecretKeyModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecretKeyRepository extends MongoRepository<SecretKeyModel,String> {
    public SecretKeyModel getAllBy();
}
