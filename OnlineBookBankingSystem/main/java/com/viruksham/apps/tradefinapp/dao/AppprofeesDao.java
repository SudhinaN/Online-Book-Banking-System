package com.viruksham.apps.tradefinapp.dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.sql.*;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
  
import com.viruksham.utils.security.SecurityUtil;

import com.viruksham.apps.tradefinapp.data.AppprofeesData;

public class AppprofeesDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public AppprofeesDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
		// invoke super constructor
		super();
	}

	/**
	 * Return the user list
	 *
	 * @return The list of user as an array of maps.
	 */
	@SuppressWarnings("unchecked")
	public Object getUserTypeList() {
		List<Object> result = null;
System.out.println("entered into Appprofees dao list");
		String sql = "SELECT * FROM Appprofees";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getAppprofeesList()", e);
		}
		return result;
	}

	

	/**
	 * Return the user data
	 *
	 * @return The user data as a maps.
	 */
	@SuppressWarnings("unchecked")
	public Object getUserTypeGet(String lcID_UserType) {
		List<Object> result = null;
System.out.println("entered into Appprofees dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM companybanks WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getAppprofeesGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from Appprofees where bankid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getAppprofeesDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(AppprofeesData Appprofees) {
		List<Object> result = null;
		System.out.println("entered into insert Appprofees dao");
		String sql = "insert into appprofees (Application_No, Pay_Mode, Paymode_Refno, Payment_Refno, Processing_Fee, Pay_Date) values (?, ?, ?, ?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Appprofees.getApplication_No());
			stmt.setString(2, Appprofees.getPay_Mode());								
			stmt.setString(3, Appprofees.getPaymode_Refno());								
			stmt.setString(4, Appprofees.getPayment_Refno());
			stmt.setString(5, Appprofees.getProcessing_Fee());							
			stmt.setString(6, Appprofees.getPay_Date());								
										
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			//e.printstacktrace;
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(AppprofeesData Appprofees) {
		List<Object> result = null;
		System.out.println("entered into update Appprofees dao");		
		System.out.println(Appprofees.getid()+" in dao");
		//String sql = "insert into mcompanies (company_name, reg_off_add, add_for_comm, phone_no, fax_no, email_id, pan_no, service_tax_reg_no,beneficiary_name) values (?, ?, ?, ?, ?, ?, ?, ?,?)";
		String sql = "update companybanks set bankname=?,branchname=?,branchaddress=?,branchifsccode=?,accountno=? where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(2, Appprofees.getbankname());								
			//stmt.setString(3, Appprofees.getbranchname());								
			//stmt.setString(4, Appprofees.getbranchaddress());
			//stmt.setString(5, Appprofees.getbranchifsccode());							
			//stmt.setString(6, Appprofees.getaccountno());																						
			//stmt.setString(7, Appprofees.getid());																						
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			//e.printstacktrace;
		}		
		return result;
	}
	
	
	/**
	 * Validate the given user credentials
	 *
	 * @param userName The username from the client side
	 * @param hash The password hash
	 * @return result of validation
	 */
	
		/*
		 * TODO: To be implemented
		 * Check the Username and sha2(hash+salt) against the database.
		 * If successful match, return true, else report invalid attempt.
		 * 
		 *  Refer to (http://crackstation.net/hashing-security.html#phpsourcecode) for algorithm
		 */
		//return false;
	}

