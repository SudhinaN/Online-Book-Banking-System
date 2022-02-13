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

import com.viruksham.apps.tradefinapp.data.BookmasterData;

public class BookmasterDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public BookmasterDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM bookmaster";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookmasterList()", e);
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
System.out.println("entered into Bookmaster dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM bookmaster WHERE bookid = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookmasterGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from bookmaster where bookid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookmasterDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(BookmasterData Bookmaster) {
		List<Object> result = null;			
		System.out.println("entered into insert Bookmaster dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Bookmaster);
		//System.out.println(Bookmaster.getRegno()+" in dao");
		//System.out.println(Bookmaster.getName()+" in dao");
		//System.out.println(Bookmaster.getSex()+" in dao");
		//System.out.println(Bookmaster.getAddress()+" in dao");
		//System.out.println(Bookmaster.getcity()+" in dao");		
		//System.out.println(Bookmaster.getpin()+" in dao");
		//System.out.println(Bookmaster.getstate()+" in dao");		
		//System.out.println(Bookmaster.getdateofbirth()+" in dao");		
		//System.out.println(Bookmaster.getfathername()+" in dao");	
		//System.out.println(Bookmaster.getmobno()+" in dao");
		//System.out.println(Bookmaster.getlandline()+" in dao");		
		//System.out.println(Bookmaster.getemailid()+" in dao");			
		//System.out.println(Bookmaster.getcolname()+" in dao");
		//System.out.println(Bookmaster.getspebranch()+" in dao");
		//System.out.println(Bookmaster.getsem()+" in dao");
		//System.out.println(Bookmaster.getexamno()+" in dao");
		//System.out.println(Bookmaster.gettitle()+" in dao");
		String sql = "insert into bookmaster (bookno, bookname, bookauthor, bookedition) values (?, ?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Bookmaster.getbookno());
			stmt.setString(2, Bookmaster.getbookname());
			stmt.setString(3, Bookmaster.getbookauthor());
			stmt.setString(4, Bookmaster.getbookedition());

			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(BookmasterData Bookmaster) {
		List<Object> result = null;
		System.out.println("entered into update Bookmaster dao");
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");		
		System.out.println(Bookmaster.getbookid()+" in dao");	
		System.out.println(Bookmaster.getbookno()+" in dao");	
		System.out.println(Bookmaster.getbookname()+" in dao");	
		System.out.println(Bookmaster.getbookauthor()+" in dao");	
		System.out.println(Bookmaster.getbookedition()+" in dao");
		String sql = "update bookmaster set bookno=?,bookname=?,bookauthor=?,bookedition=? where bookid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Bookmaster.getid());
			//stmt.setString(1, Bookmaster.getRegno());
			stmt.setString(1, Bookmaster.getbookno());								
			stmt.setString(2, Bookmaster.getbookname());
			stmt.setString(3, Bookmaster.getbookauthor());
			stmt.setString(4, Bookmaster.getbookedition());
			stmt.setString(5, Bookmaster.getbookid());
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

