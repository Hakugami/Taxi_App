package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Ride {
	private String source;
	private String destination;
	private Customer customer;
	private ArrayList<Offer> offers=new ArrayList<>();
	private Offer selectedOffer;

	public boolean isThereOffers()
	{
		if(offers.isEmpty())
		{
			return false;
		}
		return true;
	}
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Offer> getOffers() {
		return offers;
	}

	public void setOffers(ArrayList<Offer> offers) {
		this.offers = offers;
	}

	public Offer getSelectedOffer() {
		return selectedOffer;
	}
	public double getPrice(String driverName) {
		double temp=0;
		for (Offer offer:offers){
			if(offer.getDriver().getUserName().equals(driverName)){
				temp=offer.getPrice();
				return temp;
			}
		}
		return temp;
	}
	public void setSelectedOffer(Offer selectedOffer) {
		this.selectedOffer = selectedOffer;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public boolean listOffers(){
		if (offers.size()==0){
			System.out.println("There are currently no offers");
			return false;
		}
		else{
			for (int i = 0; i < offers.size(); i++) {
				System.out.println(i+1+"-"+offers.get(i));
			}
			return true;
		}
	}
	public void getOffer(int selectOffer){
		selectedOffer= offers.get(selectOffer-1);
		offers.get(selectOffer-1).getDriver().setDriverRide(this);
		Database.getAllRides().remove(this);
		offers.remove(selectOffer-1);

	}

}
