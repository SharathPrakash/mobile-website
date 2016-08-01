package com.src.model;

public class UserSingUpModel {

	public UserSingUpModel()
	{
		this.first_name = first_name;
		this.city = city;
		this.last_name = last_name;
		this.email_ID = email_ID;
		this.password = password;
		this.repassword = repassword;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.mobnum = mobnum;
		
		
		
	}
	private String first_name,last_name,email_ID,password,repassword,address,city,state,pincode,mobnum;

	public String getFirst_name() {
		return first_name;
	}
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail_ID() {
		return email_ID;
	}

	public String getPassword() {
		return password;
	}

	public String getRepassword() {
		return repassword;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public String getMobnum() {
		return mobnum;
	}

	
}
