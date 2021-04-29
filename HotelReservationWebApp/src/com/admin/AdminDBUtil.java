package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//This class will load all the details of admin
public class AdminDBUtil {

	private static Connection con = null;
	private static Statement state = null;
	private static ResultSet rs = null;

	//Admin validation using username and password for login
	public static List<Admin> validate(String username, String password) {

		ArrayList<Admin> ad = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			state = con.createStatement();
			String sql = "select * from admin where userName ='" + username + "' and password='" + password + "'";
			rs = state.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String occupation = rs.getString(4);
				String uname = rs.getString(5);
				String upd = rs.getString(6);

				Admin a = new Admin(id, name, phone, occupation, uname, upd);
				ad.add(a);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ad;
	}

}
