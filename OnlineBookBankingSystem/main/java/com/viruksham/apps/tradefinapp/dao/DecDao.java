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

import com.viruksham.apps.tradefinapp.data.DecData;

public class DecDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public DecDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
			logger.throwing(getClass().getName(), "getDecList()", e);
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
System.out.println("entered into Dec dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM applications WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getDecGet()", e);
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
			logger.throwing(getClass().getName(), "getDecDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(DecData Dec) {
		List<Object> result = null;			
		System.out.println("entered into insert Dec dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Dec);
		//System.out.println(Dec.getRegno()+" in dao");
		//System.out.println(Dec.getName()+" in dao");
		//System.out.println(Dec.getSex()+" in dao");
		//System.out.println(Dec.getAddress()+" in dao");
		//System.out.println(Dec.getcity()+" in dao");		
		//System.out.println(Dec.getpin()+" in dao");
		//System.out.println(Dec.getstate()+" in dao");		
		//System.out.println(Dec.getdateofbirth()+" in dao");		
		//System.out.println(Dec.getfathername()+" in dao");	
		//System.out.println(Dec.getmobno()+" in dao");
		//System.out.println(Dec.getlandline()+" in dao");		
		//System.out.println(Dec.getemailid()+" in dao");			
		//System.out.println(Dec.getcolname()+" in dao");
		//System.out.println(Dec.getspebranch()+" in dao");
		//System.out.println(Dec.getsem()+" in dao");
		//System.out.println(Dec.getexamno()+" in dao");
		//System.out.println(Dec.gettitle()+" in dao");
		String sql = "insert into applications (status) values (?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Dec.getstatus());
			stmt.setString(2, Dec.getid());

			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(DecData Dec) {
		List<Object> result = null;
		System.out.println("entered into update Dec dao");
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");		
		System.out.println(Dec.getid()+" in dao");	
		System.out.println(Dec.getstatus()+" in dao");	
		String sql = "update applications set status=? where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Dec.getid());
			//stmt.setString(1, Dec.getRegno());
			stmt.setString(1, Dec.getstatus());								
			stmt.setString(2, Dec.getid());
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

