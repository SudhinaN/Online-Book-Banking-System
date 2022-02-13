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

import com.viruksham.apps.tradefinapp.data.CnsPrdDocData;


public class CnsPrdDocDao extends BaseDao {
	
	private static final String CONPRDKEY = "conprdkey";
    private static final String DOCUMENTTYPE = "documenttype";
    private static final String DOCSUBTYPE = "docsubtype";    

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public CnsPrdDocDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
		// invoke super constructor
		super();
	}

	/**
	 * Return the user list
	 *
	 * @return The list of user as an array of maps.
	 */
	@SuppressWarnings("unchecked")
	public Object getCnsPrdDocList() {
		List<Object> result = null;

		String sql = "SELECT * FROM const_prod_doc";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocList()", e);
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
System.out.println("entered into CnsPrdDoc dao");
System.out.println(lcID_UserType);
		//String sql = "SELECT * FROM tbl_cnstn_prds WHERE ID_Constitution = ?";
		String sql = "SELECT * FROM tbl_cnstn_prds WHERE Constitution=?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_UserType.replace("abcdefgh"," "));

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocGet()", e);
		}
		return result;
	}
		
	@SuppressWarnings("unchecked")
	public Object getUserTypeDelete(String lcID_UserType) {
		List<Object> result = null;
		System.out.println(lcID_UserType);
		String sql = "delete from const_prod_doc where conprdkey=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcID_UserType);	
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocDelete()", e);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public String getUserTypeGetID() {
		String lcID_UserType = null;
		String sql = "Select max(ID_CnsPrdDoc) FROM const_prod_doc";
		
		try {
			Statement stmt = readConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				lcID_UserType = rs.getString(1);
			}
			if(lcID_UserType==null)
			{
				lcID_UserType="ABnk00";
			}		
			
			lcID_UserType=BaseDao.nextid(lcID_UserType);
					
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocGetID()", e);
		}
		return lcID_UserType;
	}
	
	@SuppressWarnings("unchecked")
	public Object createCnsPrdDoc(CnsPrdDocData cnsPrdDoc) {
		List<Object> result = null;
		//System.out.println("entered into create cnsPrdDoc dao");
		String sql = "INSERT INTO const_prod_doc(conprdkey, documenttype, docsubtype, concatunique, stage) VALUES(?, ?, ?, ?, ?)";
		System.out.println(cnsPrdDoc.getconprdkey()+" in dao");
		System.out.println(cnsPrdDoc.getdocumenttype()+" in dao");
		System.out.println(cnsPrdDoc.getdocsubtype()+" in dao");		
			try {
			Calendar c = new GregorianCalendar();
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cnsPrdDoc.getconprdkey());
			stmt.setString(2, cnsPrdDoc.getdocumenttype());
			stmt.setString(3, cnsPrdDoc.getdocsubtype());					
			stmt.setString(4, cnsPrdDoc.getconprdkey()+cnsPrdDoc.getdocumenttype()+cnsPrdDoc.getdocsubtype()+cnsPrdDoc.getstage());						
			stmt.setString(5, cnsPrdDoc.getstage());
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocList()", e);
			//e.printstacktrace;
		}
		
		return result;
	}
	
		@SuppressWarnings("unchecked")
	public Object updateCnsPrdDoc(CnsPrdDocData cnsPrdDoc) {
		List<Object> result = null;
		//System.out.println("entered into create cnsPrdDoc dao");
		//String sql = "INSERT INTO const_prod_doc(conprdkey, documenttype, docsubtype) VALUES(?, ?, ?)";
		//String sql="update const_prod_doc set conprdkey=?, documenttype=? , docsubtype=? where conprdkey=? AND documenttype=? AND docsubtype=?";
		String sql="update const_prod_doc set conprdkey=?, documenttype=? , docsubtype=? where conprdkey=? AND documenttype=? and docsubtype=?";
		System.out.println(cnsPrdDoc.getconprdkey()+" in dao");
		System.out.println(cnsPrdDoc.getdocumenttype()+" in dao");
		System.out.println(cnsPrdDoc.getdocsubtype()+" in dao");
		System.out.println(cnsPrdDoc.getoconprdkey()+" in dao");
		System.out.println(cnsPrdDoc.getodocumenttype()+" in dao");
		System.out.println(cnsPrdDoc.getodocsubtype()+" in dao");	
			try {
			Calendar c = new GregorianCalendar();
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cnsPrdDoc.getconprdkey());
			stmt.setString(2, cnsPrdDoc.getdocumenttype());
			stmt.setString(3, cnsPrdDoc.getdocsubtype());	
			stmt.setString(4, cnsPrdDoc.getoconprdkey());
			stmt.setString(5, cnsPrdDoc.getodocumenttype());
			stmt.setString(6, cnsPrdDoc.getodocsubtype());						
			result = (List<Object>) connectionManager.executeInsert(stmt);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocList()", e);
			//e.printstacktrace;
		}
		
		return result;
	}
	//--------------------------DOCUMENT DELETE-------------------------
	@SuppressWarnings("unchecked")
	public Object deletedoc(CnsPrdDocData cnsPrdDoc) 
	{
		List<Object> result = null;		
		String sql = "delete from const_prod_doc where concatunique=?";
		//System.out.println(cnsPrdDoc.getconcatunique()+" in dao");	
			try 
			{			
				PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, cnsPrdDoc.getconcatunique());									
				result = (List<Object>) connectionManager.executeInsert(stmt);
			} 
			catch (SQLException e) 
			{
				logger.throwing(getClass().getName(), "getCnsPrdDocList()", e);
				//e.printstacktrace;
			}
		
		return result;
	}
	//OVER----------------------------------------------------------OVER
	
	/*@SuppressWarnings("unchecked")
	public Object getUserTypeGetID(String username) {
		List<Object> result = null;

		String sql = "Select max(ID_CnsPrdDoc) FROM tbl_cnstn_prds";
		
		try {
			Statement stmt = readConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String userid = null;
			while(rs.next())
			{
				userid = rs.getString(1);
			}
			if(userid==null)
			{
				userid="ABnk00";
			}		
			String sql1 = "insert into tbluts values(?,?,?,?)";
			try {
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			Calendar c = new GregorianCalendar();
			stmt1.setString(1,GetID());
			stmt1.setString(2,username);	
			stmt1.setInt(3,1);	
			stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getEnquiryList()", e);
		}
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocList()", e);
		}
		return result;
	}*/
	
	@SuppressWarnings("unchecked")
	public Object getUserTypeSave(String lcID_UserType, String lcName_UserType) {
		List<Object> result = null;	
		
		/**
		 * to be changed when json is accuried
		 * lcID_UserType should be given directly from parameters*/
		
		if (lcID_UserType.equals("New"))
		{
			System.out.println("entered Insert");
			try {
			String sql1 = "insert into const_prod_doc values(?,?,?,?)";
			
			PreparedStatement stmt1 = writeConnection.prepareStatement(sql1);
			Calendar c = new GregorianCalendar();
			stmt1.setString(1,getUserTypeGetID());
			stmt1.setString(2,lcName_UserType);	
			stmt1.setInt(3,1);	
			stmt1.setString(4,(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)));	
			stmt1.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocSave()", e);
			}
		}	
		else
		{
			System.out.println("entered Update");
			String sql = "update const_prod_doc set Name_CnsPrdDoc=? where ID_CnsPrdDoc=?";
			try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql);
			stmt.setString(1,lcName_UserType);
			stmt.setString(2,lcID_UserType);	
			stmt.executeUpdate();
			} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getCnsPrdDocSave()", e);
			}
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

