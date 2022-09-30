package com.Dao;

import java.util.List;

import com.Bean.Vendor;
import com.Exception.VendorException;

public interface VendorDao {
	
	public String addNewVendor(Vendor vendor );
	
	public List<Vendor> showAllVendorDetails() throws VendorException;

}
