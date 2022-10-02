package com.useCases;

import java.util.Scanner;
//import java.util.Scanner;


import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
//import com.project.dao.VendorDaoImp;
import com.bean.Vendor;
//import com.project.dao.VendorDao;

public class RegisterVendorUseCase {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Vendor Name:");
		String vname=sc.next();
		
		System.out.println("Enter Email:");
		String email=sc.next();
		
		System.out.println("Enter Password:");
		String pass=sc.next();
		
		System.out.println("Enter Your Company:");
		String comp=sc.next();
		
		System.out.println("Enter Your City");
		String city=sc.next();
		
		
	
		Vendor vendor = new Vendor();
		vendor.setVname(vname);
		vendor.setVemail(email);
		vendor.setVpassword(pass);
		vendor.setVcompany(comp);
		vendor.setVcity(city);
		AdminDao tdao = new AdminDaoImpl();
		String result = tdao.registerVendor(vendor);
		System.out.println(result);
	}
}
