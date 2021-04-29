package com.admin;

//This is Admin model class

public class Admin {
	private int id;
	private String name;
	private String phone;
	private String occupation;
	private String userName;
	private String password;

	//Constructor
	public Admin(int id, String name, String phone, String occupation, String userName, String password) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.occupation = occupation;
		this.userName = userName;
		this.password = password;
	}
	
	//return the id
	public int getid() {
		return id;
	}

	///return the name
	public String getName() {
		return name;
	}

	//return the phone
	public String getPhone() {
		return phone;
	}
	
	//return the Occupation
	public String getOccupation() {
		return occupation;
	}

	//return the UserName
	public String getUserName() {
		return userName;
	}

	//return the Password
	public String getPassword() {
		return password;
	}

}
