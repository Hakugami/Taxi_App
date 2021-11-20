package com.company;

import java.util.ArrayList;


public class Driver extends User{
	private int id;
	private String licence;
	private double rate;
	private static ArrayList<String> favouriteArea = new ArrayList<>();
	private static ArrayList<Rate> allRating = new ArrayList<>();
	public void listRides() {
		
	}
	public void listRides(String Area) {
		for (String area : favouriteArea) {
			
			if (area.equals(favouriteArea))
				System.out.println(""); //there is logic error in this method
		}
	}
	public void addArea(String Area) {
		favouriteArea.add(Area);              //add area to the fav areas
		Ride r=new Ride(Area);           //keep this area as source 
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
		
}
