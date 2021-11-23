package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Ride {
	String source;
	String destination;
	public Customer customer;
	public ArrayList<Offer> offers=new ArrayList<>();
	public Offer selectedOffer;


	public Ride(String source, String destination, Customer customer) {
		this.source = source;
		this.destination = destination;
		this.customer = customer;
		
	}
	public Ride(String source, String destination, Customer customer,Driver driver) {
		this.source = source;
		this.destination = destination;
		this.customer = customer;

	}
	public Ride(String source) {
		this.source=source;
	}
	
	public void listAllRides(String area) {
		System.out.println(Database.getAllRides());
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void listOffers(){
		for (int i = 0; i < offers.size(); i++) {
			System.out.println(i+1+"-"+offers.get(i));
		}
	}
	public void getOffer(int selectOffer){
		selectedOffer= offers.get(selectOffer-1);
		offers.get(selectOffer-1).getDriver().setDriverRide(this);
		Database.getAllRides().remove(this);

	}

}
