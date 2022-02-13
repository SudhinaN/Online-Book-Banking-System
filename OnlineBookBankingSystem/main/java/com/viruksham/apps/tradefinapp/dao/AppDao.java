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

import com.viruksham.apps.tradefinapp.data.AppData;

public class AppDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public AppDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM app";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getAppList()", e);
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
System.out.println("entered into App dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM app WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getAppGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from app where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getAppDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(AppData App) {
		List<Object> result = null;			
		System.out.println("entered into insert App dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(App);
		//System.out.println(App.getRegno()+" in dao");
		//System.out.println(App.getName()+" in dao");
		//System.out.println(App.getSex()+" in dao");
		//System.out.println(App.getAddress()+" in dao");
		//System.out.println(App.getcity()+" in dao");		
		//System.out.println(App.getpin()+" in dao");
		//System.out.println(App.getstate()+" in dao");		
		//System.out.println(App.getdateofbirth()+" in dao");		
		//System.out.println(App.getfathername()+" in dao");	
		//System.out.println(App.getmobno()+" in dao");
		//System.out.println(App.getlandline()+" in dao");		
		//System.out.println(App.getemailid()+" in dao");			
		//System.out.println(App.getcolname()+" in dao");
		//System.out.println(App.getspebranch()+" in dao");
		//System.out.println(App.getsem()+" in dao");
		//System.out.println(App.getexamno()+" in dao");
		//System.out.println(App.gettitle()+" in dao");
		String sql = "insert into Apps (id, firstname, lastname, gender, address, Subject) values (?, ?, ?, ?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, App.getid());
			stmt.setString(1, App.getid());
			stmt.setString(2, App.getfirstname());
			stmt.setString(3, App.getlastname());								
			stmt.setString(4, App.getgender());
			stmt.setString(5, App.getaddress());
			stmt.setString(6, App.getSubject());
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(AppData App) {
		List<Object> result = null;
		System.out.println("entered into update App dao");		
		//System.out.println(App.getid()+" in dao");		
		String sql = "update Apps set id=?,firstname=?,lastname=?,gender=?,address=?,Subject=? where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, App.getid());
			stmt.setString(1, App.getid());
			stmt.setString(2, App.getfirstname());
			stmt.setString(3, App.getlastname());								
			stmt.setString(4, App.getgender());
			stmt.setString(5, App.getaddress());
			stmt.setString(6, App.getSubject());
			
			
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

