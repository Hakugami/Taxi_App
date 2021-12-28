package com.company;

import java.util.Scanner;

public class Customer extends User {

	protected Ride myRide;

    
    public void requestRide (String source,String destination){
		Ride r=new Ride(source,destination,this);//leave this, remove the rest
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

			if(myRide.listOffers()) {
				System.out.println("0-exit");
				System.out.println("choose your desired offer");
				int choice = input.nextInt();
				if (choice == 0) {
					return;
				}
				myRide.getOffer(choice);
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
