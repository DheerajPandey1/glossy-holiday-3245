package com.project.dao;

import java.util.List;

import com.Exceptions.VendorException;
import com.bean.Tender;
import com.bean.Vendor;

public interface AdminDao {

	public String registerVendor(Vendor vendor);
	public boolean loginVendor(String email,String password) throws VendorException;
	public List<Vendor> viewAllVendor() throws VendorException;
	public boolean loginAdmin(String username,String password) throws VendorException;
	public String createTender(Tender tender);
	public List<Tender> viewTender() throws VendorException;
	public String placeBid(int tid,int vid,double offer) throws VendorException;
	public void viewBid(int tid) throws VendorException;
	public String assignTender(int tid) throws VendorException;
	public void viewBidHistory(int vid) throws VendorException;	

}
