package com.src.model;

public class UserSingUpModel {

	private String firstName,lastName,emailId,password,address,city,state,mobnum;
	int pincode;
	

	public UserSingUpModel(String firstName,String lastName,String emailId,String password,String address,String city,String state,String pincode,String mobnum)
	{
		this.firstName = firstName;
		this.city = city;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		
		
		this.address = address;
		this.state = state;
		this.pincode =Integer.parseInt(pincode);
		this.mobnum = mobnum;
		
		
		
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getPincode() {
		return pincode;
	}

	public String getMobnum() {
		return mobnum;
	}

	
}
