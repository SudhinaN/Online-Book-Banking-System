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

import com.viruksham.apps.tradefinapp.data.BookbranchData;

public class BookbranchDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public BookbranchDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM bookbranch";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookbranchList()", e);
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
System.out.println("entered into Bookbranch dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM bookbranch WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookbranchGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from bookbranch where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookbranchDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(BookbranchData Bookbranch) {
		List<Object> result = null;			
		System.out.println("entered into insert Bookbranch dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Bookbranch);
		//System.out.println(Bookbranch.getRegno()+" in dao");
		//System.out.println(Bookbranch.getName()+" in dao");
		//System.out.println(Bookbranch.getSex()+" in dao");
		//System.out.println(Bookbranch.getAddress()+" in dao");
		//System.out.println(Bookbranch.getcity()+" in dao");		
		//System.out.println(Bookbranch.getpin()+" in dao");
		//System.out.println(Bookbranch.getstate()+" in dao");		
		//System.out.println(Bookbranch.getdateofbirth()+" in dao");		
		//System.out.println(Bookbranch.getfathername()+" in dao");	
		//System.out.println(Bookbranch.getmobno()+" in dao");
		//System.out.println(Bookbranch.getlandline()+" in dao");		
		//System.out.println(Bookbranch.getemailid()+" in dao");			
		//System.out.println(Bookbranch.getcolname()+" in dao");
		//System.out.println(Bookbranch.getspebranch()+" in dao");
		//System.out.println(Bookbranch.getsem()+" in dao");
		//System.out.println(Bookbranch.getexamno()+" in dao");
		//System.out.println(Bookbranch.gettitle()+" in dao");
		String sql = "insert into bookbranch (bookid, branch, sem) values (?, ?, ?)";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Bookbranch.getbookid());
			stmt.setString(2, Bookbranch.getbranch());
			stmt.setString(3, Bookbranch.getsem());
			

			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(BookbranchData Bookbranch) {
		List<Object> result = null;
		System.out.println("entered into update Bookbranch dao");
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");		
		System.out.println(Bookbranch.getid()+" in dao");	
		System.out.println(Bookbranch.getbookid()+" in dao");	
		System.out.println(Bookbranch.getbranch()+" in dao");	
		System.out.println(Bookbranch.getsem()+" in dao");	
		String sql = "update bookbranch set bookid=?,branch=?,sem=? where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Bookbranch.getid());
			//stmt.setString(1, Bookbranch.getRegno());
			stmt.setString(1, Bookbranch.getbookid());								
			stmt.setString(2, Bookbranch.getbranch());
			stmt.setString(3, Bookbranch.getsem());
			stmt.setString(4, Bookbranch.getid());
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

