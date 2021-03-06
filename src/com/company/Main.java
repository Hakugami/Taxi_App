package com.company;

import java.util.Date;
import java.util.Scanner;
public class Main {
    static final String date ="27/4";
    public static void main(String[] args) {
        while (true) {

            System.out.println(date);
            System.out.println("\nWelcome to our taxi app\n---------------------------\n");
            Driver driver = new Driver();
            Customer customer = new Customer();
            Admin admin =new Admin();
            Scanner scannerInt = new Scanner(System.in);
            Scanner scannerStr = new Scanner(System.in);
            Scanner scannerDoub = new Scanner(System.in);
            System.out.println("1-Register as a Customer\n2-Register as a driver\n3-log in\n4-admin panel\n5-exit");
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
                    System.out.println("Enter your birth date (dd/MM) :");
                    String bDate = scannerStr.nextLine();
                    customer.register(Username, Password, Email, Phone,bDate);
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
                    System.out.println("Enter your birth date (dd/MM) :");
                    String bDate = scannerStr.nextLine();
                    driver.register(Username, Password, Email, Phone, ID, License,bDate);

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
                            while(choiceC!=4){
                                if(!customer1.isActive()){
                                    System.out.println("You are currently suspended");
                                    break;
                                }
                                System.out.println("1-Request a ride\n2-View current offers\n3-rate a driver\n4-Logout");
                                choiceC = scannerInt.nextInt();
                                assert customer1 != null;
                                switch (choiceC) {
                                    case 1 -> {
                                        System.out.println("Enter source");
                                        String source = scannerStr.nextLine();
                                        System.out.println("Enter destination");
                                        String dest = scannerStr.nextLine();
                                        System.out.println("Enter number of passengers");
                                        int numOfPassenger = scannerInt.nextInt();
                                        customer1.requestRide(source, dest,date,numOfPassenger);
                                    }
                                    case 2 -> {
                                        customer1.chooseOffer();
                                    }
                                    case 3 ->{
                                        System.out.println("Rate your latest driver");
                                        System.out.println("Enter rating");
                                        double rate= scannerDoub.nextDouble();
                                        try{
                                            customer1.addRate(rate);
                                        }
                                        catch (Exception e){
                                            System.out.println("No selected rides\n");
                                        }
                                    }
                                }

                            }
                        }
                        else if (type == 2) {
                            Driver driver1 = Database.getDriver(Username, Password);
                            int choiceD = 0;
                            while (choiceD != 6) { //not equal the log-out number choice
                                if(!driver1.isActive()){
                                    System.out.println("You are currently suspended");
                                    break;
                                }
                                System.out.println("1-Search for a ride");
                                System.out.println("2-View current ride");
                                System.out.println("3-View all rating & average rating");
                                System.out.println("4-Add favourite area");
                                System.out.println("5-List favourite areas");
                                System.out.println("6-Logout");
                                choiceD = scannerInt.nextInt();
                                assert driver1 != null;
                                switch(choiceD) {
                                    case 1 -> {
                                        if (driver1.listRidesWithSourceArea()) {
                                            driver1.chooseRide();
                                            System.out.println("Set the offer");
                                            double price=scannerDoub.nextDouble();
                                            driver1.setOffer(driver1.chooseRide(),price);
                                        }
                                        else
                                            System.out.println("There is no requests in your fav areas");

                                    }
                                    case 2 -> {
                                        try {
                                            System.out.println(driver1.getDriverRide().getSource()+"-------->"+driver1.getDriverRide().getDestination());
                                            System.out.println(driver1.getDriverRide().getCustomer().getUserName());
                                            System.out.println(driver1.getDriverRide().getPrice(driver1.getUserName()));

                                        }
                                        catch (Exception e) {
                                            System.out.println("Error");
                                        }
                                    }
                                    case 3 -> {
                                        driver1.getAllRating();
                                        System.out.println(" ");
                                        driver1.getAverageRating();
                                    }
                                    case 4 -> {
                                        System.out.println("Enter the area you want to add");
                                        String area = scannerStr.nextLine();
                                        driver1.setFavouriteArea(area);
                                    }
                                    case 5 -> {
                                        driver1.getFavouriteArea();
                                    }


                                }

                            }

                        }
                    }
                    else{
                        System.out.println("Wrong Username or password");
                    }
                }
                case 4 -> {
                    int choiceA = 0;
                    while (choiceA != 4) {
                        System.out.println("1-Review drivers requests\n2-Suspend\n3-show logs\n4-log out");
                        choiceA = scannerInt.nextInt();
                        switch (choiceA) {
                            case 1 -> admin.reviewRequests();
                            case 2 -> admin.suspend();
                            case 3 -> admin.showLogs();
                        }
                    }
                }
                case 5 ->{
                    System.exit(0);
                }
            }
        }


    }
}
