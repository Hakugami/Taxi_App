package com.company;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class User extends Person {
    String birthDate;   //to apply discount
    public boolean active=true;

    public User() {
        super();
    }


    public boolean register(String user, String pass, String Email,String phone,String bDate){
        this.setUserName(user);
        this.setPassword(pass);
        this.setEmail(Email);
        this.setPhone(phone);
        this.setBirthDate(bDate);
        if (!(this instanceof Driver)) {
            Database.addUser((Customer) this);
        }
        return true;

    }

    public boolean login(String username, String pass){
        return Database.verify(username,pass);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(String userName, String password, String email) {
        super(userName, password, email);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
