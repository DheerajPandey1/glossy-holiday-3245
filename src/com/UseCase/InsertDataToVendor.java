package com.UseCase;

import java.util.Scanner;

import com.Bean.Vendor;
import com.Dao.VendorDao;
import com.Dao.VendorDaoImpl;

public class InsertDataToVendor {

	
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		  
		System.out.println("Enter Vendor Name");
		String dname = sc.next();
		System.out.println("Enter Vendor Email ");
		String email = sc.next();
		System.out.println("Enter Vendor MobileNumber");
		String mobile = sc.next();
		System.out.println("Enter Vendor City ");
		String city = sc.next();
		System.out.println("Enter Vendor Pincode");
		int p = sc.nextInt();
		
		
		
		VendorDao dao = new VendorDaoImpl();
		
	 Vendor vendor = new Vendor();
		vendor.setName(dname);
		vendor.setEmail_Id(email);
		vendor.setMobile_Number(mobile);
		vendor.setCity(city);
		vendor.setPincode(p);
		String result = dao.addNewVendor(vendor);
		System.out.println(result);
		
	}

}


