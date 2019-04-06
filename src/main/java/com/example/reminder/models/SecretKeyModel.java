package com.example.reminder.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "key")
public class SecretKeyModel {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
