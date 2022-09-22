package com.xoriant.enrollmentapplication.ResponseEntities;


public class AddressResponse {
	private int addressId;
	private String city;
	private String state;
	private int pincode;
	private UserResponse userId;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public UserResponse getUserId() {
		return userId;
	}
	public void setUserId(UserResponse userId) {
		this.userId = userId;
	}
	
	

}
