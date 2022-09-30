package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Vendor;
import com.Exception.VendorException;
import com.masai.utility.DBUtil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public String addNewVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		
		String message ="Not Inserted....";
	    
	    try(Connection con = DBUtil.provideConnection()){
	    	
	    	PreparedStatement ps = con.prepareStatement("insert into Vendor(name,email_Id,mobile_Number,city,pincode)values(?,?,?,?,?)");
	    	ps.setString(1, vendor.getName());
	    	ps.setString(2,vendor.getEmail_Id());
	    	ps.setString(3,vendor.getMobile_Number());
	    	ps.setString(4,vendor.getCity());
	    	ps.setInt(5,vendor.getPincode());
	    int x=	ps.executeUpdate();
	    if(x>0) {
	    	message = "Vendor Added Succesfully";
	    }
	    	
	    	
	    	
	    	
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return message;
	
	}

	@Override
	public List<Vendor> showAllVendorDetails() throws VendorException {
		// TODO Auto-generated method stub
	
		List<Vendor> vendors = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			 
		PreparedStatement pr = 	con.prepareStatement("Select * from Vendor");
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			 int id = rs.getInt("vendor_Id");
			 String name = rs.getString("name");
			 String email = rs.getString("email_Id");
			 String mobile = rs.getString("mobile_Number");
			 String city=rs.getString("city");
			 int pc=rs.getInt("pincode");
			 
			 
			 Vendor vendor = new Vendor(id,name,email,mobile, city,pc);
			 vendors.add(vendor);
			 
		}
			
			
		} catch (Exception e) {
			throw new VendorException(e.getMessage());
		}
		
		if(vendors.size()==0) {
			throw new VendorException("no Vendor found...");
		}
		
		
		
		
		return vendors;
	}

}
