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

import com.viruksham.apps.tradefinapp.data.ActiveData;

public class ActiveDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public ActiveDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
System.out.println("entered into customer master dao list");
		String sql = "SELECT * FROM applicatios";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getActiveList()", e);
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
System.out.println("entered into Active dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM applications WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getActiveGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from applications where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getActiveDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(ActiveData Active) {
		List<Object> result = null;			
		System.out.println("entered into insert Active dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Active);
		//System.out.println(Active.getRegno()+" in dao");
		//System.out.println(Active.getName()+" in dao");
		//System.out.println(Active.getSex()+" in dao");
		//System.out.println(Active.getAddress()+" in dao");
		//System.out.println(Active.getcity()+" in dao");		
		//System.out.println(Active.getpin()+" in dao");
		//System.out.println(Active.getstate()+" in dao");		
		//System.out.println(Active.getdateofbirth()+" in dao");		
		//System.out.println(Active.getfathername()+" in dao");	
		//System.out.println(Active.getmobno()+" in dao");
		//System.out.println(Active.getlandline()+" in dao");		
		//System.out.println(Active.getemailid()+" in dao");			
		//System.out.println(Active.getcolname()+" in dao");
		//System.out.println(Active.getspebranch()+" in dao");
		//System.out.println(Active.getsem()+" in dao");
		//System.out.println(Active.getexamno()+" in dao");
		//System.out.println(Active.gettitle()+" in dao");
		String sql = "insert into applications (status, deposit, regfees) values (?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Active.getstatus());
			stmt.setString(2, Active.getdeposit());
			stmt.setString(3, Active.getregfees());
			stmt.setString(4, Active.getid());

			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(ActiveData Active) {
		List<Object> result = null;
		System.out.println("entered into update Active dao");
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");		
		System.out.println(Active.getid()+" in dao");	
		System.out.println(Active.getstatus()+" in dao");	
		System.out.println(Active.getdeposit()+" in dao");	
		System.out.println(Active.getregfees()+" in dao");	
		String sql = "update applications set status=?,deposit=?,regfees=? where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Active.getid());
			//stmt.setString(1, Active.getRegno());
			stmt.setString(1, Active.getstatus());								
			stmt.setString(2, Active.getdeposit());
			stmt.setString(3, Active.getregfees());
			stmt.setString(4, Active.getid());
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

