package com.viruksham.apps.tradefinapp.dao;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
//this is for test
public class MenDao extends BaseDao {

	/**
	 * Default Constructor.
	 * Does nothing but invoke the super class default constructor
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public MenDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
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

		String sql = "SELECT * FROM tbl_gnl_menus";		
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
	public Object getMenList() {
		List<Object> result = null;

		String sql = "select b.id,b.ID_MenuGroup,a.ID_MenuBase,a.Name_Link,a.ID_Menu,a.Name_Menu from tbl_gnl_menus a,user_menus b where b.ID_Menu=a.ID_Menu";		
		try {
			Statement stmt = readConnection.createStatement();

			result = (List<Object>) connectionManager.executeSelect(stmt, sql);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getMenList()", e);
		}
		return result;
	}
	
		@SuppressWarnings("unchecked")
	public Object getMenGet(String lcID_Men) {
		List<Object> result = null;


		String sql = "select a.ID_MenuBase,a.Name_Link,a.ID_Menu,a.Name_Menu from tbl_gnl_menus a,user_menus b where b.ID_MenuGroup=? and b.ID_Menu=a.ID_Menu order by a.No_MenuOrder";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_Men.replace("abcdefgh"," "));

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getMenGet()", e);
		}
		return result;
	}
	
			@SuppressWarnings("unchecked")
	public Object insertMenGet(String lcID_menugroupID,String lcID_menuID) {
		List<Object> result = null;

		String sql = "insert into user_menus (ID_MenuGroup,ID_Menu,ID_MenuGroup_Type,Code_LiveStatus) values(?,?,?,?)";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_menugroupID.replace("abcdefgh"," "));
			stmt.setString(2, lcID_menuID);
			stmt.setString(3, (lcID_menugroupID+lcID_menuID).replace("abcdefgh"," "));
			stmt.setInt(4, 1);

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getMenGet()", e);
		}
		return result;
	}

			@SuppressWarnings("unchecked")
	public Object deletemenugroup(String lcID_menugroupID) {
		List<Object> result = null;

		String sql = "delete from user_menus where ID_MenuGroup=?";

		try {
			PreparedStatement stmt = readConnection.prepareStatement(sql);
			stmt.setString(1, lcID_menugroupID.replace("abcdefgh"," "));

			result = (List<Object>) connectionManager.executeQuery(stmt);
			logger.info(result.toString());
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "getMenGet()", e);
		}
		return result;
	}

}
