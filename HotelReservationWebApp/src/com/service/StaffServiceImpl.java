package com.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.model.Staff;
import com.util.CommonConstants;
import com.util.CommonUtil;
import com.util.DBConnectionUtil;
import com.util.QueryUtil;

//This is the implementation of StaffService
public class StaffServiceImpl implements IStaffService {
	// Initialize logger
	public static final Logger log = Logger.getLogger(StaffServiceImpl.class.getName());
	private static Connection connection;
	private static Statement statement;

	static {
		// drop staff table if exist and create staff table
		createStaffTable();
	}

	private PreparedStatement preparedStatement;

	// This method initially drop existing staff table in the database and recreate
	// table structure to insert staff entries
	public static void createStaffTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop staff table if already exists
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new staff table
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	// Add set of staff for as a batch from the selected staff List
	@Override
	public void addStaff(Staff staff) {

		String staffID = CommonUtil.generateIDs(getstaffIDs());

		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_STAFF));
			connection.setAutoCommit(false);

			// Generate staffIDs
			staff.setStaffID(staffID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, staff.getStaffID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, staff.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, staff.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, staff.getOccupation());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, staff.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, staff.getPhone());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, staff.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, staff.getGender());

			// Add staff
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			// Close prepared statement and database connectivity at the end of transaction
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	// Retrieve staff details based on the provided staffID
	@Override
	public Staff getStaffByID(String staffID) {

		return actionOnStaff(staffID).get(0);
	}

	// Get all list of staff
	@Override
	public ArrayList<Staff> getStaff() {

		return actionOnStaff(null);
	}

	// Delete the staff based on the provided staffID
	@Override
	public void removeStaff(String staffID) {

		// Before deleting check whether staffID is available
		if (staffID != null && !staffID.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, staffID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				// Close prepared statement and database connectivity at the end of transaction
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	// get staff by staffID and Display the list of staff
	private ArrayList<Staff> actionOnStaff(String staffID) {

		ArrayList<Staff> staffList = new ArrayList<Staff>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			if (staffID != null && !staffID.isEmpty()) {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, staffID);
			}

			// This will display all staff if staffID is not provided for get staff option
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_STAFF));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Staff staff = new Staff();
				staff.setStaffID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				staff.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				staff.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				staff.setOccupation(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				staff.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				staff.setPhone(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				staff.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				staff.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				staffList.add(staff);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			// Close prepared statement and database connectivity at the end of transaction
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return staffList;
	}

	@Override
	public Staff updateStaff(String staffID, Staff staff) {

		// this will check whether staffID is available before retrieving staff
		if (staffID != null && !staffID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_STAFF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, staff.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, staff.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, staff.getOccupation());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, staff.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, staff.getPhone());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, staff.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, staff.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, staff.getStaffID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				// Close prepared statement and database connectivity at the end of transaction
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated staff
		return getStaffByID(staffID);
	}

	private ArrayList<String> getstaffIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_STAFF_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			// Close prepared statement and database connectivity at the end of transaction
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;

	}
}
