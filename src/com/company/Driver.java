package com.company;

import java.util.ArrayList;


public class Driver extends User{
	protected String id;
	protected String licence;
	protected double rate;
	protected ArrayList<String> favouriteArea = new ArrayList<>();
	protected ArrayList<Rate> allRating = new ArrayList<>();
	protected Ride driverRide;

	public void setDriverRide(Ride driverRide) {
		this.driverRide = driverRide;
	}



	public void chooseRide(){
		//filter area depending on fav area and offer an offer and register it in the database
		for (String area : favouriteArea) {
			for(Ride ride : Database.getAllRides()) {
				if(ride.getSource().equals(area)){
					driverRide=ride;
					setOffer(driverRide, driverRide.getSelectedOffer().getPrice());
				}
			}
		}

	}
	public void setOffer(Ride ride,double price) {
		Offer offer = new Offer(this, price);
		ride.getOffers().add(offer);
	}
	public boolean register(String user, String pass, String Email,String phone,String id, String licence){
		this.register(user,pass,Email,phone);
		this.id=id;
		this.licence=licence;
		System.out.println("Pending approval");
		Admin.getDriversRequests(this);
		return true;
	}

	public void addRide(Ride r) {
		driverRide =r;
	}

	public void listRidesWithSourceArea() {
		for (String area : favouriteArea) {
			for (Ride r : Database.getAllRides())
				if (area.equals(r.getSource())) {
//					System.out.println(r.source+"   "+r.destination+"   "+r.price);
//					System.out.println(Database.getUser(r.customer.userName,r.customer.Email));
			}
		}
	}
	
	
	public void addArea(String Area) {
		favouriteArea.add(Area);              //add area to the fav areas
	}
	public void offer(double price) {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setFavouriteArea(ArrayList<String> favouriteArea) {
		this.favouriteArea = favouriteArea;
	}

	public void setAllRating(ArrayList<Rate> allRating) {
		this.allRating = allRating;
	}

	public Ride getDriverRide() {
		return driverRide;
	}

	public void setLicence(String licence) {
		this.licence=licence;
	}
	public String getLicence() {
		return licence;
	}
	public void setRate(String username,double rate) {
		this.rate=rate;
		Rate r=new Rate(username,rate);
		allRating.add(r);
	}
	public double getRate() {
		return rate;
	}
	public void setFavouriteArea(String favArea) {
		favouriteArea.add(favArea);
		
	}
	public void getFavouriteArea() {
		for (String favArea: favouriteArea) {
			System.out.println(favArea);
		}
		
	}
	public void setAllRating(String username,double rate) {
		Rate r=new Rate(username,rate);
		allRating.add(r);
	}
	public void getAllRating() {
		for(Rate allRate : allRating)
			System.out.println(allRate.getUsername()+"   "+allRate.getRate());
	}
	public void getAverageRating() {
		double r=0;
		for(Rate allRate : allRating){
			r+=allRate.getRate();
		}
		System.out.println(r/allRating.size());
	}

	@Override
	public String toString() {
		return "Driver{" +
				"id='" + id + '\'' +
				", licence='" + licence + '\'' +
				", rate=" + rate +
				", favouriteArea=" + favouriteArea +
				", allRating=" + allRating +
				", driverRide=" + driverRide +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", Email='" + Email + '\'' +
				", phone='" + phone + '\'' +
				", active=" + active +
				'}';
	}
}
