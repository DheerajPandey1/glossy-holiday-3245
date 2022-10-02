package com.useCases;

import java.util.List;

import com.Exceptions.VendorException;
import com.bean.Vendor;
import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;

public class ViewAllVendorUseCase {

	public static void main(String[] args) {
		AdminDao vd = new AdminDaoImpl();
		try {
			List<Vendor> vendors = vd.viewAllVendor();
			vendors.forEach(v->{
				System.out.println("Vendor name : "+ v.getVname());
				System.out.println("Vendor email : "+v.getVemail());
				System.out.println("Vendor company : "+v.getVcompany());
				System.out.println("vendor address : "+v.getVcity());
				System.out.println("===============================");
			});
		} catch (VendorException v) {
			System.out.println(v.getMessage());
		}

	}

}
