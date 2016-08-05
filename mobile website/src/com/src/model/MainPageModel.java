package com.src.model;

public class MainPageModel {
private String brand;
private String rearCamera;
private String frontCamera;
private String screenSize;
private String priceRange;

MainPageModel(String brand, String rearCamera, String frontCamera, String screenSize, String priceRange){
this.brand=brand;
this.rearCamera=rearCamera;
this.frontCamera=frontCamera;
this.screenSize=screenSize;
this.priceRange=priceRange;
}
public String getBrand() {
	return brand;
}
public String getRearCamera() {
	return rearCamera;
}

public String getFrontCamera() {
	return frontCamera;
}

public String getScreenSize() {
	return screenSize;
}

public String getPriceRange() {
	return priceRange;
}



}
