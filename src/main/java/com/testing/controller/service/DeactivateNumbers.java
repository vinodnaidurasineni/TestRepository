package com.testing.controller.service;

import java.sql.*;
import java.util.Scanner;

public class DeactivateNumbers {
	public static void main(String args[]) {
		try {
			System.out.println("Name");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PhoneDB", "root", "0987@123");
            //here PhoneDB is database name, root is username and 0987@123 password  
			Scanner in=new Scanner(System.in) ;
			System.out.println("Enter phone Number");
			String phoneNumber=in.next();
			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("update  PhoneData  set PROV_STATUS=\"Deleted\", CREDIT_LIMIT=0, VAS_CALL_DIVERT=\"No\", VAS_CALL_WAITING=\"NO\" where PhoneNum=?");
			ps.setString(1, phoneNumber);
			int i=ps.executeUpdate();
			if(i==0) {
				System.out.println("Failed");
			}else {
				System.out.println("Success");
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println("Failed"+e);
		}
	}
}