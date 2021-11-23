package com.company;

import java.util.ArrayList;


public class Driver extends User{
	private int id;
	private String licence;
	public double rate;
	public ArrayList<String> favouriteArea = new ArrayList<>();
	public ArrayList<Rate> allRating = new ArrayList<>();

	public void setDriverRide(Ride driverRide) {
		this.driverRide = driverRide;
	}

	public  Ride driverRide;
	public boolean isSuspended=false;


	public void chooseRide(){
		//filter area depending on fav area and offer an offer and register it in the database
		for (String area : favouriteArea) {
			for(Ride ride : Database.allRides) {
				if(ride.source.equals(area)){
					driverRide=ride;
					setOffer(driverRide, driverRide.selectedOffer.getPrice());
					Database.allRides.add(driverRide);
				}
			}
		}

	}
	public void setOffer(Ride ride,double price) {
		Offer offer = new Offer(this, price);
		ride.offers.add(offer);
	}
	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean suspended) {
		isSuspended = suspended;
	}

	public boolean register(String user, String pass, String Email, int id, String licence){
		this.register(user,pass,Email);
		this.id=id;
		this.licence=licence;
		Admin.getDriversRequests(this);
		return true;
	}

	public void addRide(Ride r) {
		driverRide =r;
	}
//	public void listAllPreviousRides() {
//		for (Ride ride:driverRides) {
////			System.out.println(ride.getSource()+"   "+ride.getDestination()+"   "+ride.getPrice());
//		}
//	}
	public void listRidesWithSourceArea() {
		for (String area : favouriteArea) {
			for (Ride r : Database.allRides)
				if (area.equals(r.source)) {
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
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
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
				"id=" + id +
				", licence='" + licence + '\'' +
				", rate=" + rate +
				", isSuspended=" + isSuspended +
				", userName='" + userName + '\'' +
				", Email='" + Email + '\'' +
				", active=" + active +
				'}';
	}
}
