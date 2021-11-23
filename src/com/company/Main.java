package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to our taxi app");
            Driver driver = new Driver();
            Customer customer = new Customer();
            Admin admin =new Admin();
            Scanner scannerInt = new Scanner(System.in);
            Scanner scannerStr = new Scanner(System.in);
            System.out.println("1-Register as a Customer\n2-Register as a driver\n3-log in\n4-admin panel");
            int choice = scannerInt.nextInt();
            switch (choice) {
                case 1 -> {

                    System.out.println("Enter your Username: ");
                    String Username = scannerStr.nextLine();
                    System.out.println("Enter your Password: ");
                    String Password = scannerStr.nextLine();
                    System.out.println("Enter your Email: ");
                    String Email = scannerStr.nextLine();
                    System.out.println("Enter your Phone: ");
                    String Phone = scannerStr.nextLine();
                    customer.register(Username, Password, Email, Phone);
                }
                case 2 -> {

                    System.out.println("Enter your Username: ");
                    String Username = scannerStr.nextLine();
                    System.out.println("Enter your Password: ");
                    String Password = scannerStr.nextLine();
                    System.out.println("Enter your Email: ");
                    String Email = scannerStr.nextLine();
                    System.out.println("Enter your Phone: ");
                    String Phone = scannerStr.nextLine();
                    System.out.println("Enter your ID: ");
                    String ID = scannerStr.nextLine();
                    System.out.println("Enter your License ID: ");
                    String License = scannerStr.nextLine();
                    driver.register(Username, Password, Email, Phone, ID, License);

                }
                case 3 -> {
                    System.out.println("Do you want to login as\n1-Customer\n2-Driver");
                    int type = scannerInt.nextInt();
                    System.out.println("Enter your Username: ");
                    String Username = scannerStr.nextLine();
                    System.out.println("Enter your Password: ");
                    String Password = scannerStr.nextLine();
                    boolean loggedC = Database.verify(Username, Password);
                    boolean loggedD=Database.verifyDriver(Username,Password);
                    if (loggedC||loggedD) {
                        if (type == 1) {
                            Customer customer1 = Database.getUser(Username, Password);
                            int choiceC=0;
                            while(choiceC!=3){
                            System.out.println("1-Request a ride\n2-View current offers\n3-log-out");
                            choiceC = scannerInt.nextInt();
                            assert customer1 != null;
                            switch (choiceC) {
                                case 1 -> {
                                    System.out.println("Enter source");
                                    String source = scannerStr.nextLine();
                                    System.out.println("Enter destination");
                                    String dest = scannerStr.nextLine();
                                    customer1.requestRide(source, dest);
                                }
                                case 2 -> {
                                    customer1.chooseOffer();
                                }
                            }

                            }
                        }
                        else if (type == 2) {
                            Driver driver1 = Database.getDriver(Username, Password);
                            int choiceD = 0;
                            while (choiceD != 3) { //not equal the log-out number choice
                                System.out.println("");
                                choiceD = scannerInt.nextInt();

                            }

                        }
                    }
                    else{
                        System.out.println("Wrong Username or password");
                    }
                }
                case 4 -> {
                    int choiceA = 0;
                    while (choiceA != 3) {
                        System.out.println("1-Review drivers requests\n2-Suspend\n3-log-out");
                        choiceA = scannerInt.nextInt();
                        switch (choiceA) {
                            case 1 -> admin.reviewRequests();
                            case 2 -> admin.suspend();
                        }
                    }
                }
            }
        }


    }
}
