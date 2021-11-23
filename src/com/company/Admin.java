package com.company;

import java.util.ArrayList;
import java.util.Objects;
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
        String selectDriver=scanner.nextLine();
        for(int i=0;i<allRequests.size();i++){
            if(Objects.equals(allRequests.get(i).getId(), selectDriver)){
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
        Scanner scannerInt=new Scanner(System.in);
        System.out.println("1-Suspend Driver\n2-Suspend Customer");
        int choice= scannerInt.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Suspension : \n" + Database.getAllDrivers().toString());
                System.out.println("Please enter the ID of the driver you wish to select");
                String select = scanner.nextLine();
                for (Driver driver : Database.getAllDrivers()) {
                    if (Objects.equals(driver.getId(), select)) {
                        driver.setActive(false);
                        System.out.println(driver.getUserName() + " has been suspended");
                        break;
                    }
                }
            }
            case 2 -> {
                System.out.println("Suspension : \n" + Database.getAllUsers().toString());
                System.out.println("Please enter the Username of the Customer you wish to select");
                String select = scanner.nextLine();
                for (Customer customer : Database.getAllUsers()) {
                    if (Objects.equals(customer.getUserName(), select)) {
                        customer.setActive(false);
                        System.out.println(customer.getUserName() + " has been suspended");
                        break;
                    }
                }
            }
        }

    }
}
