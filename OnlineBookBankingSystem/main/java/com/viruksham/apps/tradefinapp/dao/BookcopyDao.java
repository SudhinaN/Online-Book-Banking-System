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

import com.viruksham.apps.tradefinapp.data.BookcopyData;

public class BookcopyDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public BookcopyDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM bookcopy";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookcopyList()", e);
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
System.out.println("entered into Bookcopy dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM bookcopy WHERE bookcopyid = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookcopyGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from bookcopy where bookcopyid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookcopyDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(BookcopyData Bookcopy) {
		List<Object> result = null;			
		System.out.println("entered into insert Bookcopy dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Bookcopy);
		//System.out.println(Bookcopy.getRegno()+" in dao");
		//System.out.println(Bookcopy.getName()+" in dao");
		//System.out.println(Bookcopy.getSex()+" in dao");
		//System.out.println(Bookcopy.getAddress()+" in dao");
		//System.out.println(Bookcopy.getcity()+" in dao");		
		//System.out.println(Bookcopy.getpin()+" in dao");
		//System.out.println(Bookcopy.getstate()+" in dao");		
		//System.out.println(Bookcopy.getdateofbirth()+" in dao");		
		//System.out.println(Bookcopy.getfathername()+" in dao");	
		//System.out.println(Bookcopy.getmobno()+" in dao");
		//System.out.println(Bookcopy.getlandline()+" in dao");		
		//System.out.println(Bookcopy.getemailid()+" in dao");			
		//System.out.println(Bookcopy.getcolname()+" in dao");
		//System.out.println(Bookcopy.getspebranch()+" in dao");
		//System.out.println(Bookcopy.getsem()+" in dao");
		//System.out.println(Bookcopy.getexamno()+" in dao");
		//System.out.println(Bookcopy.gettitle()+" in dao");
		String sql = "insert into bookcopy (bookid, bookno, rate, status) values (?, ?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Bookcopy.getbookid());
			stmt.setString(2, Bookcopy.getbookno());
			stmt.setString(3, Bookcopy.getrate());
			stmt.setString(4, Bookcopy.getstatus());

			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(BookcopyData Bookcopy) {
		List<Object> result = null;
		System.out.println("entered into update Bookcopy dao");
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");		
		System.out.println(Bookcopy.getbookcopyid()+" in dao");	
		System.out.println(Bookcopy.getbookid()+" in dao");	
		System.out.println(Bookcopy.getbookno()+" in dao");	
		System.out.println(Bookcopy.getrate()+" in dao");	
		System.out.println(Bookcopy.getstatus()+" in dao");	
		String sql = "update bookcopy set bookid=?,bookno=?,rate=?,status=? where bookcopyid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Bookcopy.getid());
			//stmt.setString(1, Bookcopy.getRegno());
			stmt.setString(1, Bookcopy.getbookid());
			stmt.setString(2, Bookcopy.getbookno());								
			stmt.setString(3, Bookcopy.getrate());
			stmt.setString(4, Bookcopy.getstatus());
			stmt.setString(5, Bookcopy.getbookcopyid());
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

