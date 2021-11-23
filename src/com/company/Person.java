package com.company;

public class Person {
    protected String userName;
    protected String password;
    protected String Email;
    protected String phone;

    public Person(String userName, String password, String email, String phone) {
        this.userName = userName;
        this.password = password;
        Email = email;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person(String userName, String password, String phone){
        this.userName=userName;
        this.password=password;
        this.phone=phone;
        this.Email="";
    }


    public Person() {

    }
  
    	

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
