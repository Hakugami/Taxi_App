package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {
    public static ArrayList<Driver> allRequests=new ArrayList<>();

    public static void getDriversRequests(Driver driver){
        allRequests.add(driver);
    }
    public boolean reviewRequests(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("all the current requests : \n"+allRequests.toString());
        System.out.println("Please enter the ID of the driver you wish to select");
        int selectDriver=scanner.nextInt();
        for(int i=0;i<allRequests.size();i++){
            if(allRequests.get(i).getId()==selectDriver){
                System.out.println("1-Accept request\n2-Deny request");
                int choice=scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        Database.addDriver(allRequests.get(i));
                        allRequests.remove(i);
                        return true;
                    }
                    case 2 -> {
                        allRequests.remove(i);
                        return false;
                    }
                    default -> {
                        System.out.println("something went wrong !");
                        return false;
                    }
                }


            }
            else {
                System.out.println("You have entered a wrong ID");
            }
        }
        return false;
    }

    public void suspend(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Suspension : \n"+Database.getAllDrivers().toString());
        System.out.println("Please enter the ID of the driver you wish to select");
        int selectDriver=scanner.nextInt();
        for(Driver driver:Database.getAllDrivers()){
            if(driver.getId()==selectDriver){
                driver.setSuspended(true);
                System.out.println(driver.getUserName()+" has been suspended");
                break;
            }
        }
    }
}
