package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Ride implements rideSub{
	private String source;
	private String destination;
	private Customer customer;
	private ArrayList<Offer> offers=new ArrayList<>();
	private Offer selectedOffer;
	private double discount;
	private int numOfPeople;

	public void log(String event,Person actor){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		StringBuilder stringBuilder=new StringBuilder();
		if(actor instanceof Driver){
			stringBuilder.append(dtf.format(now)).append("--->"+event+": ").append(actor.getUserName());
			Database.saveLogs(stringBuilder.toString());
		}
		else{
			stringBuilder.append(dtf.format(now)).append("--->"+event+": ").append(customer.getUserName());
			Database.saveLogs(stringBuilder.toString());
			log("Driver has reached the user location");
			log("Driver has reached his destination");
		}

	}
	public void log(String event){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		StringBuilder stringBuilder=new StringBuilder();
		Random random=new Random();
		stringBuilder.append(dtf.format(now)+random.nextInt(10)).append("--->"+event+": ").append(selectedOffer.getDriver().getUserName())
				.append(" "+customer.getUserName());

		Database.saveLogs(stringBuilder.toString());
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isThereOffers()
	{
		return !offers.isEmpty();
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

	Vector<driverAndRideObserver> obsSub;
	@Override
	public void subscribe(driverAndRideObserver ob) {
		obsSub.add(ob);
	}
	@Override
	public void unsubscribe(driverAndRideObserver ob) {
		for (int i=0; i < obsSub.size() ; i++){
			if (obsSub.elementAt(i) == ob){
				obsSub.remove(obsSub.elementAt(i));
			}
		}
	}


	@Override
	public void Notify() {
		//.setDriverRide(this);
		for (int i=0; i < obsSub.size() ; i++){
			if (selectedOffer .getDriver() == obsSub.elementAt(i)) {
				obsSub.elementAt(i).update(this);
			}
		}
	}
}
