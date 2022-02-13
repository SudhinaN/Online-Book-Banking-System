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

import com.viruksham.apps.tradefinapp.data.BookData;

public class BookDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public BookDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM books";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookList()", e);
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
System.out.println("entered into Book dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM books WHERE bookid = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;	
		//String sql = "update mcompanies set Code_LiveStatus=? where id=?";
		String sql="delete from books where bookid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getBookDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(BookData Book) {
		List<Object> result = null;			
		System.out.println("entered into insert Book dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Book);
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
		String sql = "insert into books (bookname, bookauthor, status, rate) values (?, ?, ?, ? )";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Book.getid());
			//stmt.setString(1, Book.getbookid());
			stmt.setString(1, Book.getbookname());								
			stmt.setString(2, Book.getbookauthor());
			stmt.setString(3, Book.getstatus());
			stmt.setString(4, Book.getrate());
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	

	
	@SuppressWarnings("unchecked")
	public Object editdata(BookData Book) {
		List<Object> result = null;
		System.out.println("entered into update Application dao");	
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");	
		System.out.println(Book);
		System.out.println(Book.getbookname());
		System.out.println(Book.getbookauthor());
		System.out.println(Book.getstatus());
		System.out.println(Book.getrate());
		System.out.println(Book.getbookid()+" in dao");		
		String sql = "update books set bookname=?,bookauthor=?,status=?,rate=? where bookid=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Application.getid());
			stmt.setString(1, Book.getbookname());
			stmt.setString(2, Book.getbookauthor());								
			stmt.setString(3, Book.getstatus());
			stmt.setString(4, Book.getrate());
			stmt.setString(5, Book.getbookid());
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

