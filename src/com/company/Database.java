package com.company;

import java.util.ArrayList;

public class  Database {

    public static ArrayList<User> allUsers=new ArrayList<>();
    public static ArrayList<Driver> allDrivers= new ArrayList<>();
    public static  ArrayList<Ride> allRides=new ArrayList<>();
    public static ArrayList<Driver> driversRequests=new ArrayList<>();



    public static boolean verify(String user,String pass){
        for (User user1:allUsers) {
            if(user1.getUserName().equals(user)&&user1.getPassword().equals(pass)){
                System.out.println("You have logged in successfully");
                user1.setActive(true);

                return true;
            }
        }
        System.out.println("User does not exist");
        return false;
    }

    public static boolean verifyDriver(String user,String pass){
        for(Driver driver:allDrivers){

        }
        return false;
    }


    public static boolean addUser(User user){
        if(allUsers.contains(user)){
            System.out.println("This user already exists");
            return false;
        }
        else{
            allUsers.add(user);
            System.out.println("user has been added successfully");
            return true;
        }
    }


    public static User getUser(String user,String Email){
        for (User user1:allUsers){
            if(user1.getUserName().equals(user)||user1.getEmail().equals(Email)){
                return user1;
            }
        }
        return allUsers.get(0);
    }


    public static boolean addDriver(Driver driver){
        if(allDrivers.contains(driver)){
            System.out.println("This driver already exists");
            return false;
        }
        else{
            allDrivers.add(driver);
            allUsers.add(driver);
            System.out.println("Driver has been added successfully");
            return true;
        }
    }


    public static User getDriver(String user,String Email){
        for (Driver driver:allDrivers){
            if(driver.getUserName().equals(user)||driver.getEmail().equals(Email)){
                return driver;
            }
        }
        return allUsers.get(0);
    }





    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static ArrayList<Driver> getAllDrivers() {
        return allDrivers;
    }

    public static ArrayList<Ride> getAllRides() {
        return allRides;
    }

    public static ArrayList<Driver> getDriversRequests() {
        return driversRequests;
    }


}
