package com.project.dao;

import java.util.List;

import com.Exceptions.VendorException;
import com.bean.Administrator;
import com.bean.Tender;
import com.bean.Vendor;
import com.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

//import com.project.bean.Administrator;
//import com.project.bean.Vendor;
//import com.project.exceptions.VendorException;
//import com.project.utility.DBUtil;


public class AdminDaoImpl implements AdminDao{

	@Override
	public String registerVendor(Vendor vendor) {
		String message="Not Registered..";
		
		try (Connection con=DBUtil.provideConnection()){
			
			
			PreparedStatement ps=con.prepareStatement("insert into vendor(vname,vemail,vpassword,vcompany,vcity) values(?,?,?,?,?)");
			
			ps.setString(1,vendor.getVname());
			ps.setString(2,vendor.getVemail());
			ps.setString(3,vendor.getVpassword());
			ps.setString(4,vendor.getVcompany());
			ps.setString(5,vendor.getVcity());
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Vendor Registration Successful!";
			}
			
			
		} catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}

	@Override
	public boolean loginVendor(String email, String password) throws VendorException {
		Vendor vendor = null;
		boolean flag = false;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from vendor where Vemail=? AND Vpassword=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString("vid");
				String n = rs.getString("vname");
				String e = rs.getString("Vemail");
				String p = rs.getString("Vpassword");
				String c = rs.getString("Vcompany");
				String ci = rs.getString("Vcity");
			vendor = new Vendor(id,n,e,p,c,ci);	
			
			}else {
				throw new VendorException("Invalid email or password");
			}
			if(email.equals(vendor.getVemail())&&password.equals(vendor.getVpassword()))             {
				System.out.println("Login successfully..");
				flag=true;
          				
			}else {
				throw new VendorException("Invalid username or password ");
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		
		
		
		return flag;
		
	}

	@Override
	public List<Vendor> viewAllVendor() throws VendorException {
		List<Vendor> vlist = new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from vendor");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String vid = rs.getString("vid");
				String n = rs.getString("Vname");
				String e = rs.getString("Vemail");
				String p = rs.getString("Vpassword");
				String c = rs.getString("Vcompany");
				String ci = rs.getString("Vcity");
				Vendor vendor = new Vendor(vid,n,e,p,c,ci);
				vlist.add(vendor);
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		if(vlist.size()==0) {
			throw new VendorException("No vendor found..");
		}
	
		return vlist;
		
	}

	@Override
	public boolean loginAdmin(String username, String password) throws  VendorException {
		boolean flag = false;
		Administrator admin = null;
//		String msg = "invalid username or password";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from admin where Admin_username=? AND Admin_password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String e = rs.getString("Admin_username");
				String p = rs.getString("Admin_password");
				admin = new Administrator(e,p);
				
			}else {
				throw new VendorException("Invalid username or password");
			}
			
			if(username.equals(admin.getUsername())&&password.equals(admin.getPassword())) {
//				System.out.println("Login Successfully!!");
				flag=true;
			}else {
				throw new VendorException("Invalid username or password ");
			}
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		
		return flag;
	}

	@Override
	public String createTender(Tender tender) {
		// TODO Auto-generated method stub
		String str = "Tender not created";
		try(Connection conn=DBUtil.provideConnection()) {
		PreparedStatement ps=	conn.prepareStatement("insert into tender(tid,flat_type_in_BHK,location,startDate,endDate, Base_price) values(?,?,?,?,?,?)");
		ps.setInt(1, tender.getTid());	
		ps.setString(3,tender.getLocation());
		ps.setInt(2, tender.getFlatType());
		ps.setString(4, tender.getStartDate());
		ps.setString(5,tender.getEndDate());
		ps.setDouble(6, tender.getBasePrice());
		int x = ps.executeUpdate();
		if(x>0) {
			str = "Tender created successfully!!...";
		}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		
		return str;
		
	}

	@Override
	public List<Tender> viewTender() throws VendorException {
		// TODO Auto-generated method stub
		List<Tender> tender= new ArrayList<>();
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from tender");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			int tid = rs.getInt("tid");
			int ftype = rs.getInt("flat_type_in_BHK");
			String l = rs.getString("location");
			String sdate = rs.getString("startdate");
			String edate = rs.getString("enddate");
			double bp = rs.getDouble("Base_price");
			Tender t = new Tender(tid,ftype,l,sdate,edate,bp);
			tender.add(t);
			}
	
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}if(tender.size()==0) {
			throw new VendorException("No tender found!!...");
		}
		return tender;
	}

	@Override
	public String placeBid(int tid,int vid,double offer) throws VendorException {
		String msg = "Invalid Tender id or Vendor id";
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("insert into bid(tid,vid,offer) values(?,?,?)");
			ps.setInt(1, tid);
			ps.setInt(2, vid);
			ps.setDouble(3, offer);
			int x = ps.executeUpdate();
			if(x>0) {
				msg = "Bid place successfully";
			}else {
				//throw new VendorException("incorrect tender id or vendor id");
				System.out.println("Incorrect Tender id or Vendor Id");
			}
		} catch (SQLException e) {
			//throw new VendorException(e.getMessage());
			
		}
		
		
		return msg;
	}

	@Override
	public void viewBid(int tid) throws VendorException {
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from bid where tid = ?");
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
            if(rs==null) {
            	System.out.println("No bid found..");
            }else {
            	while(rs.next()) {
    				int vid = rs.getInt("vid");
    				double o = rs.getDouble("offer");
    				System.out.println("Recieve offer of "+o+" by vendor id "+vid);
    			}	
            }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public String assignTender(int tid) throws VendorException {
		String msg = "Pending....";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from bid where tid =?");
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while(rs.next()) {
				count++;
			}
			double max=0;
			if(count>=3) {
				PreparedStatement ps1 = conn.prepareStatement("select MAX(offer) from bid where tid=?");
				ps1.setInt(1, tid);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next()) {
					max = rs1.getDouble("MAX(offer)");
					//System.out.println(max);
				}
				PreparedStatement ps2 = conn.prepareStatement("select vid from bid where offer = ?");
				ps2.setDouble(1,max);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					int v= rs2.getInt("vid");
					msg = "Tender assigned to Vender id "+ v;
				}
			}
			else {
				throw new VendorException("Bid incomplete..");
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
			
		}
	
		return msg;
	}

	@Override
	public void viewBidHistory(int vid) throws VendorException {
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from bid where vid =?");
			ps.setInt(1, vid);
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					double o = rs.getDouble("offer");
					int tid = rs.getInt("tid");
				System.out.println("Your bid against tender id "+tid+" is "+o );	
				}
			}else {
				throw new VendorException("No history found...");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}


