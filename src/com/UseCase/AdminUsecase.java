package com.UseCase;

import java.util.Scanner;

import com.Dao.Admin;
import com.Dao.AdminDaoImpl;

public class AdminUsecase {

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	 System.out.println("Enter login username and password");
	 System.out.println("Enter username");
	 String username = sc.next();
	 System.out.println("Enter user password");
	 String password = sc.next();
	 
	 Admin dao = new AdminDaoImpl();
String result=	 dao.AdminLogin(username, password);
System.out.println(result);
}
}
