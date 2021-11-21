package com.company;

import java.util.Scanner;

public class Customer extends User {

	public Ride myRide;

    
    public void requestRide (String source,String destination){
    	for (Driver driver: Database.allDrivers ){
    		for (String area : driver.favouriteArea) {
    			if (area.equals(source)) {
    				Ride r=new Ride(source,destination,this);//leave this, remove the rest
    				Database.allRides.add(r);//this too
					myRide=r;// added this to see his ride
    			}
    		}
    	}
    }
    public void chooseOffer(){
			Scanner input=new Scanner(System.in);
			System.out.println("0-exit");
    		myRide.listOffers();
			System.out.println("choose your desired offer");
			int choice=input.nextInt();
			if (choice==0){
				return;
			}
			myRide.getOffer(choice);
    }
    public void addRate(double rate,String name){
    	for (Driver driver: Database.allDrivers) {
    		if(driver.userName.equals(name)) {
    			driver.setRate(driver.userName, rate);
    		}
    	}
    }
}
