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

import com.viruksham.apps.tradefinapp.data.FeedData;

public class FeedDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public FeedDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM feedback";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getFeedList()", e);
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
System.out.println("entered into Feed dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM feedback WHERE fid = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getFeedGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from feedback where fid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getFeedDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(FeedData Feed) {
		List<Object> result = null;			
		System.out.println("entered into insert Book dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Feed);
		System.out.println(Feed.getid()+" in dao");
		System.out.println(Feed.getName()+" in dao");
		System.out.println(Feed.getemailid()+" in dao");
		System.out.println(Feed.getrating()+" in dao");
		System.out.println(Feed.getcomment()+" in dao");
		//System.out.println(Book.getRegno()+" in dao");
		//System.out.println(Book.getName()+" in dao");
		//System.out.println(Book.getSex()+" in dao");
		//System.out.println(Book.getAddress()+" in dao");
		//System.out.println(Book.getcity()+" in dao");		
		//System.out.println(Book.getpin()+" in dao");
		//System.out.println(Book.getstate()+" in dao");		
		//System.out.println(Book.getdateofbirth()+" in dao");		
		//System.out.println(Book.getfathername()+" in dao");	
		//System.out.println(Book.getmobno()+" in dao");
		//System.out.println(Book.getlandline()+" in dao");		
		//System.out.println(Book.getemailid()+" in dao");			
		//System.out.println(Book.getcolname()+" in dao");
		//System.out.println(Book.getspebranch()+" in dao");
		//System.out.println(Book.getsem()+" in dao");
		//System.out.println(Book.getexamno()+" in dao");
		//System.out.println(Book.gettitle()+" in dao");
		String sql = "insert into feedback (id, Name, emailid, rating, comment) values (?, ?, ?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Book.getid());
			//stmt.setString(1, Book.getbookid());
			stmt.setString(1, Feed.getid());								
			stmt.setString(2, Feed.getName());
			stmt.setString(3, Feed.getemailid());
			stmt.setString(4, Feed.getrating());
			stmt.setString(5, Feed.getcomment()); 
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	

	
	@SuppressWarnings("unchecked")
	public Object editdata(FeedData Feed) {
		List<Object> result = null;
		System.out.println("entered into update Application dao");	
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
		System.out.println(Feed);
		System.out.println(Feed.getid());
		System.out.println(Feed.getfid());
		System.out.println(Feed.getName());
		System.out.println(Feed.getemailid());
		System.out.println(Feed.getrating()+" in dao");		
		System.out.println(Feed.getcomment());
		String sql = "update feedback set id=?,Name=?,emailid=?,rating=?,comment=? where fid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Application.getid());
			stmt.setString(1, Feed.getid());									
			stmt.setString(2, Feed.getName());
			stmt.setString(3, Feed.getemailid());
			stmt.setString(4, Feed.getrating());
			stmt.setString(5, Feed.getcomment());
			stmt.setString(6, Feed.getfid());
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

