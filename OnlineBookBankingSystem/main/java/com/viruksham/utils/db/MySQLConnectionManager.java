/**
 * 
 */
package com.viruksham.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import java.sql.Blob;

/**
 * @author bala
 * 
 */
public class MySQLConnectionManager implements ConnectionManager {
	
	protected Logger logger = Logger.getLogger(getClass().getName());

	private static MySQLConnectionManager instance = null;
	private static Connection readConnection = null;
	private static Connection writeConnection = null;

	private final String DB_MYSQL_CLASSNAME = "com.mysql.jdbc.Driver";

	private MySQLConnectionManager() throws ClassNotFoundException {
		// Setting DB classname
		try {
			Class.forName(DB_MYSQL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}

	public static synchronized ConnectionManager getSingletonObject() 
			throws ClassNotFoundException {
		if (instance == null) {
			instance = new MySQLConnectionManager();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.viruksham.utils.db.ConnectionManager#getReadConnection()
	 */
	@Override
	public Connection getReadConnection() throws NullPointerException {
		if (readConnection == null) {
			throw new NullPointerException("ConnectionManager has not been instantiated");
		}
		return readConnection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.viruksham.utils.db.ConnectionManager#getWriteConnection()
	 */
	@Override
	public Connection getWriteConnection() throws NullPointerException {
		if (writeConnection == null) {
			throw new NullPointerException("writeConnection not established. Call has not been instantiated");
		}
		return writeConnection;
	}

	public void initReadConnection(String url, String userName, String password) throws SQLException {
		if (readConnection == null) {
			// Setting up readConnection
			try {
				readConnection = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				logger.throwing(getClass().getName(), "initReadConnection(String, String, String)", e);
				throw e;
			}
		}
	}

	public void initWriteConnection(String url, String userName, String password) throws SQLException {
		if (writeConnection == null) {
			// Setting up writeConnection
			try {
				writeConnection = DriverManager.getConnection(url, userName, password);
			} catch (SQLException e) {
				logger.throwing(getClass().getName(), "initWriteConnection(String, String, String)", e);
				throw e;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.viruksham.utils.db.ConnectionManager#executeQuery(java.sql.PreparedStatement)
	 */
	@Override
	public Object executeQuery(PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			boolean execResult;
			try {
				execResult = stmt.execute();
				if (execResult) {
					return this.parseResultSet(stmt.getResultSet());
				}
				else {
					throw new SQLException("Unexpected data returned (or) No data returned");
				}
			} catch (SQLException e) {
				logger.throwing(getClass().getName(), "executeQuery(PreparedStatement)", e);
				throw e;
			}
		}
		return null;
	}

	public Object executeInsert(PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			int rowsAffected;
			try {
				rowsAffected = stmt.executeUpdate();
				if (rowsAffected > 0) {
					return this.parseResultSet(stmt.getGeneratedKeys());
				}
				else {
					throw new SQLException("Unexpected data returned (or) No data returned");
				}
			} catch (SQLException e) {
				logger.throwing(getClass().getName(), "executeQuery(PreparedStatement)", e);
				throw e;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.viruksham.utils.db.ConnectionManager#executeSelect(java.sql.Statement, java.lang.String)
	 */
	@Override
	public List<Object> executeSelect(Statement stmt, String sql) throws SQLException {
		try {
			return this.parseResultSet(stmt.executeQuery(sql));
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "executeSelect", e);
			throw e;
		}
	}
	
	@Override
	public List<Object> sepQuery(Statement stmt, String sql) throws SQLException {
		List<Object> result=null;
		try {
			System.out.println(sql);
			
			String[] sqlarr=sql.split(",");
				
				return (List<Object>) executeSelect(stmt, sql);

		} 
		catch (SQLException e) {
			logger.throwing(getClass().getName(), "sepQuery", e);
			throw e;
		}
	}

	public Object clone() throws CloneNotSupportedException {
		// You suck!
		throw new CloneNotSupportedException();
	}

	private List<Object> parseResultSet(ResultSet rsInput) throws SQLException {
		Map<String, Object> row = null;
		List<Object> retVal = null;
		try {
			if (rsInput != null) {
				retVal = new ArrayList<Object>();
				ResultSetMetaData rsMetadata = rsInput.getMetaData();
				System.out.println("---------"+rsMetadata+"---------");
				while (rsInput.next()) {
					row = new HashMap<String, Object>();
					for (int i=1; i <= rsMetadata.getColumnCount(); i++) {
						if(rsMetadata.getColumnType(i) == Types.LONGVARBINARY) {
							Blob blobData = rsInput.getBlob(i);
							row.put(rsMetadata.getColumnName(i), blobData.getBytes(1, (int)blobData.length()));
						}
						else {
							row.put(rsMetadata.getColumnName(i), rsInput.getString(i));
						}
					}
					retVal.add(row);
				}
			}
		}
		catch (SQLException e) {
			logger.throwing(getClass().getName(), "parseResultSet()", e);
			throw e;
		}
		return retVal;
	}
}
