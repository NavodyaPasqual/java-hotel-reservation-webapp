package com.service;

import com.model.Staff;
import java.util.ArrayList;
import java.util.logging.Logger;

//This is the interface of StaffService
public interface IStaffService {
	
	//Initialize logger
	public static final Logger log = Logger.getLogger(IStaffService.class.getName());
	
	//Add staff for staff table
	public void addStaff(Staff staff);
	
	//Get the staff according to staffID
	public Staff getStaffByID(String staffID);
	
	//Get all list of staff
	public ArrayList<Staff> getStaff();
	
	//Update existing staff according to stafffId 
	public Staff updateStaff(String staffID, Staff staff);
	
	//Delete existing staff according to staffID
	public void removeStaff(String staffID);
	
}
