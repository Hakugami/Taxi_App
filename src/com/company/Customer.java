package com.company;

public class Customer extends User {
    
    public void requestRide (String source,String destination){
    	for (Driver driver: Database.allDrivers ){
    		for (String area : driver.favouriteArea) {
    			if (driver.favouriteArea.equals(source)) {
    				Ride r=new Ride(source,destination,this,driver);
    				Database.allRides.add(r);
    			}
    		}
    	}
    }
    public void chooseOffer(double offer,Ride ride){
    		for(Ride r : Database.allRides) {
    			if (r.equals(ride)) {
    				r.price=offer;
    			}
    		}
    }
    public void addRate(double rate,String name){
    	for (Driver driver: Database.allDrivers) {
    		if(driver.userName.equals(name)) {
    			driver.setRate(driver.userName, rate);
    		}
    	}
    }
}
