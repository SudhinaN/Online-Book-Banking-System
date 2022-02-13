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

import com.viruksham.apps.tradefinapp.data.ApplicationData;

public class ApplicationDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public ApplicationDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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
		String sql = "SELECT * FROM applications";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getApplicationList()", e);
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
System.out.println("entered into Application dao");
System.out.println(lcID_UserType);
		String sql = "SELECT * FROM applications WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getApplicationGet()", e);
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
			logger.throwing(getClass().getName(), "getApplicationDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Object insertdata(ApplicationData Application) {
		List<Object> result = null;			
		System.out.println("entered into insert Application dao DAO");				
		System.out.println("-------------------------------------------------------------------------------------");		
		System.out.println(Application);
		//System.out.println(Application.getRegno()+" in dao");
		//System.out.println(Application.getName()+" in dao");
		//System.out.println(Application.getSex()+" in dao");
		//System.out.println(Application.getAddress()+" in dao");
		//System.out.println(Application.getcity()+" in dao");		
		//System.out.println(Application.getpin()+" in dao");
		//System.out.println(Application.getstate()+" in dao");		
		//System.out.println(Application.getdateofbirth()+" in dao");		
		//System.out.println(Application.getfathername()+" in dao");	
		//System.out.println(Application.getmobno()+" in dao");
		//System.out.println(Application.getlandline()+" in dao");		
		//System.out.println(Application.getemailid()+" in dao");			
		//System.out.println(Application.getcolname()+" in dao");
		//System.out.println(Application.getspebranch()+" in dao");
		//System.out.println(Application.getsem()+" in dao");
		//System.out.println(Application.getexamno()+" in dao");
		//System.out.println(Application.gettitle()+" in dao");
		String sql = "insert into applications (Regno, Name, Sex, Address, city, pin, state, dateofbirth, fathername, mobno, landline, emailid, colname, spebranch, sem, examno, title, codeuserrole, idmenugroup, status, deposit, regfees) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Application.getid());
			stmt.setString(1, Application.getRegno());
			stmt.setString(2, Application.getName());								
			stmt.setString(3, Application.getSex());
			stmt.setString(4, Application.getAddress());
			stmt.setString(5, Application.getcity());
			stmt.setString(6, Application.getpin());								
			stmt.setString(7, Application.getstate());			
			stmt.setString(8, Application.getdateofbirth());
			stmt.setString(9, Application.getfathername());								
			stmt.setString(10, Application.getmobno());
			stmt.setString(11, Application.getlandline());
			stmt.setString(12, Application.getemailid());
			stmt.setString(13, Application.getcolname());
			stmt.setString(14, Application.getspebranch());								
			stmt.setString(15, Application.getsem());			
			stmt.setString(16, Application.getexamno());	
			stmt.setString(17, Application.gettitle());
			stmt.setString(18, Application.getcodeuserrole());	
			stmt.setString(19, Application.getidmenugroup());
			stmt.setString(20, Application.getstatus());
			stmt.setString(21, Application.getdeposit());
			stmt.setString(22, Application.getregfees());
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCustomerList()", e);
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public Object editdata(ApplicationData Application) {
		List<Object> result = null;
		System.out.println("entered into update Application dao");
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");		
		System.out.println(Application.getid()+" in dao");	
		System.out.println(Application.getName()+" in dao");	
		System.out.println(Application.getSex()+" in dao");	
		System.out.println(Application.getAddress()+" in dao");	
		System.out.println(Application.getcity()+" in dao");	
		System.out.println(Application.getpin()+" in dao");	
		System.out.println(Application.getstate()+" in dao");		
		System.out.println(Application.getdateofbirth()+" in dao");	
		System.out.println(Application.getfathername()+" in dao");	
		System.out.println(Application.getmobno()+" in dao");	
		System.out.println(Application.getlandline()+" in dao");	
		System.out.println(Application.getemailid()+" in dao");	
		System.out.println(Application.getcolname()+" in dao");	
		System.out.println(Application.getspebranch()+" in dao");	
		String sql = "update applications set Name=?,Sex=?,Address=?,city=?,pin=?,state=?,dateofbirth=?,fathername=?,mobno=?,landline=?,emailid=?,colname=?,spebranch=?,sem=?,examno=?,title=? where id=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//stmt.setString(1, Application.getid());
			//stmt.setString(1, Application.getRegno());
			stmt.setString(1, Application.getName());								
			stmt.setString(2, Application.getSex());
			stmt.setString(3, Application.getAddress());
			stmt.setString(4, Application.getcity());
			stmt.setString(5, Application.getpin());								
			stmt.setString(6, Application.getstate());	
			stmt.setString(7, Application.getdateofbirth());
			stmt.setString(8, Application.getfathername());								
			stmt.setString(9, Application.getmobno());
			stmt.setString(10, Application.getlandline());
			stmt.setString(11, Application.getemailid());
			stmt.setString(12, Application.getcolname());
			stmt.setString(13, Application.getspebranch());								
			stmt.setString(14, Application.getsem());			
			stmt.setString(15, Application.getexamno());
			stmt.setString(16, Application.gettitle());	
			//stmt.setString(18, Application.getcodeuserrole());
			//stmt.setString(19, Application.getidmenugroup());
			//stmt.setString(20, Application.getstatus());
			stmt.setString(17, Application.getid());
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

