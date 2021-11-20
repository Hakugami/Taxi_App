package com.company;
public class Ride {
	String source;
	String distination;
	double price;
	User user;
	Driver driver;
	public Ride(String source, String distination, User user) {
		this.source = source;
		this.distination = distination;
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
	public String getDistination() {
		return distination;
	}
	public void setDistination(String distination) {
		this.distination = distination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	
	}
}
