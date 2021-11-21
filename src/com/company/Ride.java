package com.company;
public class Ride {
	String source;
	String destination;
	double price;
	Customer customer;
	Driver driver;
	public Ride(String source, String destination, Customer customer) {
		this.source = source;
		this.destination = destination;
		this.customer = customer;
		
	}
	public Ride(String source, String destination, Customer customer,Driver driver) {
		this.source = source;
		this.destination = destination;
		this.customer = customer;
		this.driver=driver;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	
	}
}
