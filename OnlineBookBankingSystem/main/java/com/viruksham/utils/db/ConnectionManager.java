/**
 * 
 */
package com.viruksham.utils.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author bala
 *
 */
public interface ConnectionManager {
	
	public Connection getReadConnection();
	public Connection getWriteConnection();

	public void initReadConnection(String url, String userName, String password) throws SQLException;
	public void initWriteConnection(String url, String userName, String password) throws SQLException;

	public Object executeSelect(Statement stmt, String sql) throws SQLException;
	public Object sepQuery(Statement stmt, String sql) throws SQLException;
	public Object executeQuery(PreparedStatement stmt) throws SQLException;
	public Object executeInsert(PreparedStatement stmt) throws SQLException;
}
