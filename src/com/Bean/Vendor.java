package com.Bean;

public class Vendor {

	private int vendor_Id;
	private String  name;
	private String  email_Id;
	private String mobile_Number;
	private String City;
	private int pincode;
	public Vendor(int vendor_Id, String name, String email_Id, String mobile_Number, String city, int pincode) {
		super();
		this.vendor_Id = vendor_Id;
		this.name = name;
		this.email_Id = email_Id;
		this.mobile_Number = mobile_Number;
		City = city;
		this.pincode = pincode;
	}
	public int getVendor_Id() {
		return vendor_Id;
	}
	public void setVendor_Id(int vendor_Id) {
		this.vendor_Id = vendor_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_Id() {
		return email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	public String getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Vendor [vendor_Id=" + vendor_Id + ", name=" + name + ", email_Id=" + email_Id + ", mobile_Number="
				+ mobile_Number + ", City=" + City + ", pincode=" + pincode + "]";
	}
	
	public Vendor() {
		
	}
	
}
