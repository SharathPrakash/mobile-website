package com.src.model;

public class UserSingUpModel {

	private String firstName;
	private String city;
	private String lastName;
	private String emailId;
	private String password;
	private String repassword;
	private String address;
	private String state;
	private String pincode;
	private String mobnum;

	public UserSingUpModel(String firstName,String lastName, String city,String emailId, String password, String repassword
			,String address,String state,String pincode, String mobnum)
	{
		this.firstName = firstName;
		this.city = city;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.repassword = repassword;
		this.address = address;
		this.state = state;
		this.pincode = pincode;
		this.mobnum = mobnum;
		
		
		
	}
	
	public String getFirst_name() {
		return firstName;
	}
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getLast_name() {
		return lastName;
	}

	public String getEmail_ID() {
		return emailId;
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
