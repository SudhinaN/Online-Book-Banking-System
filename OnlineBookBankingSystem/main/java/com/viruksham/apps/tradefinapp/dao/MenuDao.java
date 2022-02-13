package com.viruksham.apps.tradefinapp.dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
//this is for test
public class MenuDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public MenuDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
		// invoke super constructor
		super();
	}

	/**
	 * Return the user list
	 *
	 * @return The list of user as an array of maps.
	 */
	@SuppressWarnings("unchecked")
	public Object getMenuList() {
		List<Object> result = null;

		String sql = "SELECT * FROM tblGnlMenu";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getMenuList()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getMenuGet(String userid) {
		List<Object> result = null;
System.out.println("entered into menu dao");
System.out.println(userid);
		String sql = "SELECT  DISTINCT b.Name_Menu, b.ID_MenuBase, a.ID_User ,b.Name_Link ,a.Code_LiveStatus,a.ID_Menu FROM tblGnlUserMenu a, tblGnlMenu b WHERE a.ID_User =? and a.ID_Menu =b.ID_Menu";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, userid);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserTypeGet()", e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Object getUserMenuList() {
		List<Object> result = null;

		String sql = "SELECT ID_User,ID_Menu FROM tblGnlUserMenu";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserMenuList()", e);
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
	/*@SuppressWarnings("unchecked")
	public boolean validateUser(String userName, String hash) {*/
		/*
		 * Temporary solution that should go away. *UGLY UGLY HATE HATE*
		 */
		/*final String SECRET_HASH = "secret_hash";
		List<Object> result = null;
		String sql = "SELECT uuid, username, secret_hash, role, name FROM users WHERE username = ? and is_disabled = 0";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, userName);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());

			// Check if passwords match
			if (((Map<String, Object>)result.get(0)).get(SECRET_HASH).equals(hash)) {
				return true;
			}
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getUserList()", e);
		}*/
		/*
		 * TODO: To be implemented
		 * Check the Username and sha2(hash+salt) against the database.
		 * If successful match, return true, else report invalid attempt.
		 * 
		 *  Refer to (http://crackstation.net/hashing-security.html#phpsourcecode) for algorithm
		 */
		/*return false;
	}*/
}
