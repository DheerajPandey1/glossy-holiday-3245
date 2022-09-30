package com.UseCase;

import java.util.List;

import com.Bean.Vendor;
import com.Dao.VendorDao;
import com.Dao.VendorDaoImpl;
import com.Exception.VendorException;

public class VendorShowAllUseCase {

	public static void main(String[] args) {
		
		VendorDao dao=new VendorDaoImpl();
		
		try {
			List<Vendor>  vendor=   dao.showAllVendorDetails();
			vendor.forEach(d -> System.out.println(d));
		} catch (VendorException e) {
			 System.out.println(e.getMessage());
		
		
	}
}
	
}
