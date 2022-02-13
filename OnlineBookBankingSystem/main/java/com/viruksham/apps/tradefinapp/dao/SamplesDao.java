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

import com.viruksham.apps.tradefinapp.data.SamplesData;

public class SamplesDao extends BaseDao {
	 

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public SamplesDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
		// invoke super constructor
		super();
	}


@SuppressWarnings("unchecked")
	public Object viewall() {
		
		List<Object> result = null;

		String sql = "select * from samples";
		try {
			Statement stmt = readConnection.createStatement();

			//result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			result = (List<Object>) connectionManager.sepQuery(stmt, sql);
			//logger.info(result.toString());
			System.out.println(result);
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "viewall()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object view(String GetID) {
		List<Object> result = null;

		String sql = "SELECT * FROM samples WHERE id = ?";

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
	public Object save(SamplesData samples) {
		List<Object> result = null;
		String sql;
		if(samples.getid()==null || samples.getid()==""){
				sql = "insert into samples (samplesone,samplestwo,samplesthree,samplesfour) values(?,?,?,?)";
				System.out.println(samples.getid()+"  --- Not ID in dao");
		}else{
			sql = "update samples set samplesone=?,samplestwo=?,samplesthree=?,samplesfour=? where id=?";
			System.out.println(samples.getid()+"  --- ID in dao");
		}
		try {
			PreparedStatement stmt = writeConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, samples.getsamplesone());
			stmt.setString(2, samples.getsamplestwo());
			stmt.setString(3, samples.getsamplesthree());
			stmt.setString(4, samples.getsamplesfour());
			if(samples.getid()==null || samples.getid()==""){
			}else{
				stmt.setString(5, samples.getid());
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

		String sql = "delete FROM samples WHERE id = ?";

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
