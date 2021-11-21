package com.company;

public class Main {

    public static void main(String[] args) {
        //testing....
        Driver driver=new Driver();
        driver.register("islam","123","islam@email.com",12354,"test");
        Admin admin=new Admin();
        admin.reviewRequests();
        admin.suspend();
        System.out.println("Database"+Database.getAllDrivers().toString());


    }
}
