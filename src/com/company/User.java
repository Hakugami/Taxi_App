package com.company;

public abstract class User extends Person {

    public boolean active=true;

    public User() {
        super();
    }


    public boolean register(String user, String pass, String Email,String phone){
        this.setUserName(user);
        this.setPassword(pass);
        this.setEmail(Email);
        this.setPhone(phone);
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
}
