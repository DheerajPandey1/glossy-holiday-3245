package com.bean;

public class Vendor {


		private String Vid;
		private String Vname;
		private String Vemail;
		private String Vpassword;
		private String Vcompany;
		private String Vcity;
		
		
		
		public Vendor(String vid, String vname, String vemail, String vpassword, String vcompany, String vcity) {
			super();
			Vid = vid;
			Vname = vname;
			Vemail = vemail;
			Vpassword = vpassword;
			Vcompany = vcompany;
			Vcity = vcity;
		}
	
		public Vendor() {
			// TODO Auto-generated constructor stub
		}

		public String getVid() {
			return Vid;
		}
		public void setVid(String vid) {
			Vid = vid;
		}
		public String getVname() {
			return Vname;
		}
		public void setVname(String vname) {
			Vname = vname;
		}
		public String getVemail() {
			return Vemail;
		}
		public void setVemail(String vemail) {
			Vemail = vemail;
		}
		public String getVpassword() {
			return Vpassword;
		}
		public void setVpassword(String vpassword) {
			Vpassword = vpassword;
		}
		public String getVcompany() {
			return Vcompany;
		}
		public void setVcompany(String vcompany) {
			Vcompany = vcompany;
		}
		public String getVcity() {
			return Vcity;
		}
		public void setVcity(String vcity) {
			Vcity = vcity;
		}
		@Override
		public String toString() {
			return "Vendor [Vid=" + Vid + ", Vname=" + Vname + ", Vemail=" + Vemail + ", Vpassword=" + Vpassword
					+ ", Vcompany=" + Vcompany + ", Vcity=" + Vcity + "]";
		}

		
		
	}


