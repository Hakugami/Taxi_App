package com.company;

public class Person {
    public String userName;
    public String password;
    public String Email;

    public Person(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        Email = email;
    }

    public Person() {

    }
    public void login(String email, String password) {
    		if (this.Email.equals(email) && this.password.equals(password)){
        		System.out.println("Login successful");
        	
    		}
    		else {
    			System.out.println("Wrong email or password please try again");	
            }
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
