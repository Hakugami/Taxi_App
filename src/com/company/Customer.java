package com.company;

import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class Customer extends User {
    static int counter=1;
    protected Ride myRide;
    boolean checkList ;
    boolean firstRide=false;


    public void requestRide (String source,String destination,String date,int numOfPass){
        Ride r=new Ride(source,destination,this);//leave this, remove the rest
        r.numOfPeople=numOfPass;
        r.date=date;
        Database.getAllRides().add(r);//this too
        myRide=r;// added this to see his ride

    }

    public void chooseOffer(){
        Scanner input=new Scanner(System.in);
        if(myRide==null)
        {
            System.out.println("there are no offers yet");
            return;
        }
        checkList= myRide.listOffers();
        if(checkList) {
            System.out.println("0-exit");
            System.out.println("choose your desired offer");
            int choice = input.nextInt();
            if (choice == 0) {
                return;
            }
            String date = getDate();
            //checkDiscount(date);
            myRide.getOffer(choice);
            myRide.listOffers();//
            myRide.incrementNumOfPeople();
            myRide.log("Customer accepted offer",this);
        }

    }
    public void addRate(double rate){
        Rate customerRate= null;
        if (myRide.getSelectedOffer() != null) {
            customerRate = new Rate(myRide.getSelectedOffer().getDriver().getUserName(), rate);
            myRide.getSelectedOffer().getDriver().setRate(customerRate);
        }
        else {
            System.out.println("No recent rides");
        }

    }
    public boolean checkFirstRide(){
        if (counter==1){
            firstRide=true;
            counter++;
            return true;
        }
        firstRide=false;
        return false;
    }
    public void checkDiscount(String date){
        myRide.setDiscount(0);
        if (birthDate.equals(date)) {
            myRide.setDiscount(myRide.getDiscount()+ 10);
        }
        if (checkFirstRide()){
            myRide.setDiscount(myRide.getDiscount()+10);
        }
        if (myRide.getNumOfPeople()==2){
            myRide.setDiscount(myRide.getDiscount()+5);
        }

        if (Database.checkHoliday(date)) {
            for (String holiday : Database.getAllHolidays()) {
                if (date.equals(holiday))
                    myRide.setDiscount(myRide.getDiscount() + 5);
            }
        }
    }
        public void setDate(String date){
        this.myRide.date=date;
        }
        public String getDate(){
        return myRide.date;
        }

    @Override
    public String toString() {
        return "Customer{" +
                "myRide=" + myRide +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", Email='" + Email + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                '}';
    }
}
