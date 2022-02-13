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

import com.viruksham.apps.tradefinapp.data.UserssData;

public class UserssDao extends BaseDao {
	 

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public UserssDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
		// invoke super constructor
		super();
	}


@SuppressWarnings("unchecked")
	public Object viewall() {
		
		List<Object> result = null;

		String sql = "SELECT * FROM userss";
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "viewall()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object view(String GetID) {
		List<Object> result = null;

		String sql = "SELECT * FROM userss WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, GetID);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "view()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object save(UserssData Userss) {
		List<Object> result = null;
		String sql;
		if(Userss.getid()==null || Userss.getid()==""){
				sql = "insert into userss (user_id,user_name,user_password,user_role) values(?,?,?,?)";
				System.out.println(Userss.getid()+"  --- Not ID in dao");
		}else{
			sql = "update userss set user_id=?,user_name=?,user_password=?,user_role=? where id=?";
			System.out.println(Userss.getid()+"  --- ID in dao");
		}
		try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, Userss.getuser_id());
			stmt.setString(2, Userss.getuser_name());
			stmt.setString(3, Userss.getuser_password());
			stmt.setString(4, Userss.getuser_role());
			if(Userss.getid()==null || Userss.getid()==""){
			}else{
				stmt.setString(5, Userss.getid());
			}
			result = (List<Object>) connectionManager.executeInsert(stmt);
			System.out.println(result);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "save()", e);
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object delete(String GetID) {
		List<Object> result = null;

		String sql = "delete FROM userss WHERE id = ?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, GetID);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "view()", e);
		}
		return result;
	}

	/**
	 * Validate the given ApplicationDoc credentials
	 *
	 * @param ApplicationDocName The ApplicationDocname from the client side
	 * @param hash The password hash
	 * @return result of validation
	 */
	
		/*
		 * TODO: To be implemented
		 * Check the ApplicationDocname and sha2(hash+salt) against the database.
		 * If successful match, return true, else report invalid attempt.
		 * 
		 *  Refer to (http://crackstation.net/hashing-security.html#phpsourcecode) for algorithm
		 */
		//return false;
	}

/*****************************OVER***********************************************/
