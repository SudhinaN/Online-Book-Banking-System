package com.viruksham.apps.tradefinapp.dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.sql.*;


public class ParamDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public ParamDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
		// invoke super constructor
		super();
	}

	/**
	 * Return the user list
	 *
	 * @return The list of user as an array of maps.
	 */
	@SuppressWarnings("unchecked")
	public Object getParamList() {
		
		List<Object> result = null;

		String sql = "SELECT * FROM parameters order by Code_Param";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getParamList()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserTypeGet(String lcID_UserType) {
		List<Object> result = null;

		String sql = "SELECT * FROM tblUserType WHERE ID_UserType = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getparamGet()", e);
		}
		return result;
	}

		@SuppressWarnings("unchecked")
	public Object insertUserTypeGet(String lcName_UserType) {
		List<Object> result = null;	

			
			try {
			String sql1 = "insert into parameters (Code_Param,Name_Param,Code_LiveStatus,Date_LiveStatus) values(?,?,?,?)";
			
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			Calendar c = new GregorianCalendar();
			stmt1.setString(1,lcName_UserType.replace("abcdefgh"," "));
			stmt1.setString(2,"New");	
			stmt1.setInt(3,1);	
			stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeSave()", e);
			}
		return result;
	}

		@SuppressWarnings("unchecked")
	public Object editUserTypeGet(String NameParam,String id) {
		List<Object> result = null;	

			
			try {
			String sql1 = "update parameters set Name_Param=? where ID=?";
			
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			//Calendar c = new GregorianCalendar();
			stmt1.setString(2,id.replace("abcdefgh"," "));
			stmt1.setString(1,NameParam.replace("abcdefgh"," "));
			//stmt1.setInt(3,1);	
			//stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeSave()", e);
			}
		return result;
	}


		@SuppressWarnings("unchecked")
	public Object insert1ParamGet(String CodeParam,String NameParam) {
		List<Object> result = null;	
			System.out.println("entered into param insert1 dao");
			System.out.println(CodeParam.replace("abcdefgh"," "));
			System.out.println(NameParam.replace("abcdefgh"," "));
			try {
			String sql1 = "insert into parameters (Code_Param,Name_Param,Code_LiveStatus,Date_LiveStatus) values(?,?,?,?)";
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			Calendar c = new GregorianCalendar();
			stmt1.setString(1,CodeParam.replace("abcdefgh"," "));
			stmt1.setString(2,NameParam.replace("abcdefgh"," "));	
			stmt1.setInt(3,1);	
			stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeSave()", e);
			}
		return result;
	}

		@SuppressWarnings("unchecked")
	public Object deleteUserTypeGet(String lcName_UserType) {
		List<Object> result = null;	

			
			try {
			String sql1 = "delete from parameters where ID=?";
			
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			//Calendar c = new GregorianCalendar();
			stmt1.setString(1,lcName_UserType);
			//stmt1.setString(2,"New");	
			//stmt1.setInt(3,1);	
			//stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeSave()", e);
			}
		return result;
	}

		@SuppressWarnings("unchecked")
	public Object deleteDocType(String lcName_UserType) {
		List<Object> result = null;	

			
			try {
		String sql1 = "delete from const_prod_doc where documenttype=?";
			
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			//Calendar c = new GregorianCalendar();
			stmt1.setString(1,lcName_UserType.replace("abcdefgh"," "));
			//stmt1.setString(2,"New");	
			//stmt1.setInt(3,1);	
			//stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeSave()", e);
			}
		return result;
	}

		@SuppressWarnings("unchecked")
	public Object deleteDoc(String lcName_UserType) {
		List<Object> result = null;	

			
			try {
		String sql1 = "delete from const_prod_doc where docsubtype=?";
			
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			//Calendar c = new GregorianCalendar();
			stmt1.setString(1,lcName_UserType.replace("abcdefgh"," "));
			//stmt1.setString(2,"New");	
			//stmt1.setInt(3,1);	
			//stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeSave()", e);
			}
		return result;
	}

/*		@SuppressWarnings("unchecked")
	public Object createUser(ParamData user) {
		List<Object> result = null;
		
		String sql = "INSERT INTO users(username, secret, role, name, salt) VALUES(?, ?, ?, ?, ?)";
		//String sql = "INSERT INTO users(username, secret, role, name, salt) VALUES(?, ?, ?, ?, ?)";
		
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getSecret());
			stmt.setInt(3, user.getRole());
			//stmt.setString(3, user.getRole());
			stmt.setString(4, user.getName());
			Blob blobValue = writeConnection.createBlob();
			blobValue.setBytes(1, user.getSalt());
			stmt.setBlob(5, blobValue);

			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserList()", e);
		}
		
		return result;
	}*/
	
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

