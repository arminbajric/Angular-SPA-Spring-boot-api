package com.example.reminder.models;

import net.bytebuddy.build.Plugin;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "reminders")
public class RemindersModel {

    @Id
    private Long Id;
    private String reminderTitle;

    private String doc;
    private String toe;
    private String doe;

    public String getToe() {
        return toe;
    }

    public void setToe(String toe) {
        this.toe = toe;
    }

    private String reminderText;
    private String  userEmail;

    public String getUserModel() {
        return userEmail;
    }

    public void setUserModel(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }


    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDoe() {
        return doe;
    }

    public void setDoe(String doe) {
        this.doe = doe;
    }

    public String getReminderText() {
        return reminderText;
    }

    public void setReminderText(String reminderText) {
        this.reminderText = reminderText;
    }
}
