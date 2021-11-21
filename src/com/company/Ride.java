package com.company;
public class Ride {
	String source;
	String destination;
	double price;
	User user;
	Driver driver;
	public Ride(String source, String destination, User user) {
		this.source = source;
		this.destination = destination;
		this.user = user;
	}
	public Ride(String source) {
		this.source=source;
	}
	public void listAllRides(String area) {
		
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
