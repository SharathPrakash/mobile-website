package com.src.model;

public class MainPageModel {
	private String Brand;
	private String RearCamera;
	private String FrontCamera;
	private String ScreenSize;
	private String PriceRange;
	
	
	public MainPageModel(String Brand, String RearCamera, String FrontCamera, String ScreenSize, String PriceRange ){
	this.Brand=Brand;
	this.RearCamera=RearCamera;
	this.FrontCamera=FrontCamera;
	this.ScreenSize=ScreenSize;
	this.PriceRange=PriceRange;
	}
	public String getBrand() {
		return Brand;
	}
	
	public String getRearCamera() {
		return RearCamera;
	}
	
	public String getFrontCamera() {
		return FrontCamera;
	}
	
	public String getScreenSize() {
		return ScreenSize;
	}
	
	public String getPriceRange() {
		return PriceRange;
	}
	
	

}
