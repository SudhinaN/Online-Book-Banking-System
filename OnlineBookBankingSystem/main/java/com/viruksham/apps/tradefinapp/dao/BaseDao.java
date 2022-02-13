/**
 * 
 */
package com.viruksham.apps.tradefinapp.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.viruksham.utils.VirukshamBase;
import com.viruksham.utils.db.ConnectionManager;
import com.viruksham.utils.db.MySQLConnectionManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base DAO
 *
 * @since 1.0
 * @author brajagopal
 */
public abstract class BaseDao extends VirukshamBase {

	protected final String DB = "db";
	protected final String DB_HOST = "host";
	protected final String DB_PORT = "port";
	protected final String DB_SCHEMA = "schema_name";
	protected final String DB_READ_USER = "read";
	protected final String DB_WRITE_USER = "write";
	protected final String DB_USERNAME = "username";
	protected final String DB_PASSWORD = "password";

	protected final String DB_CONFIGFILE = "conf/tradefinapps.yml";

	private Map<String, Object> dbConfig = null;

	protected ConnectionManager connectionManager = null;
	protected Connection readConnection = null;
	protected Connection writeConnection = null;

	/**
	 * Default constructor
	 * Initialize the connectionManager instance
	 * Load database details from the configuration
	 * Retrieve the readConnection and writeConnection
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	 public static String nextid(String lsuserid){
		String numS=null;
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(lsuserid);
		while (m.find()) {
		  numS=m.group();
		}
		int charlen=(lsuserid.length()-numS.length());
		int charS=Integer.parseInt(lsuserid.substring(charlen));
		int i=(int) Math.pow(10, numS.length());
		int rnum=charS+i+1;
		String lastChars = Integer.toString(rnum).substring(Integer.toString(rnum).length()-numS.length());
		return lsuserid.substring(0,charlen)+lastChars;
		
	}
	@SuppressWarnings("unchecked")
	public BaseDao() throws ClassNotFoundException, SQLException, FileNotFoundException {
	
		// Init user maps
		Map<String, String> readUser, writeUser = null;

		try {
			// Get instance of the ConnectionManager
			connectionManager = MySQLConnectionManager.getSingletonObject();

			// Load Database configurations
			loadDatabaseConfig(DB_CONFIGFILE);

			readUser = (Map<String, String>) dbConfig.get(DB_READ_USER);
			writeUser = (Map<String, String>) dbConfig.get(DB_WRITE_USER);

			// Setting up readConnection
			connectionManager.initReadConnection(getUrl(), 
					readUser.get(DB_USERNAME), 
					readUser.get(DB_PASSWORD));

			// Setting up writeConnection
			connectionManager.initWriteConnection(getUrl(), 
					writeUser.get(DB_USERNAME), 
					writeUser.get(DB_PASSWORD));

			readConnection = connectionManager.getReadConnection();
			writeConnection = connectionManager.getWriteConnection();

		} catch (ClassNotFoundException e) {
			logger.throwing(getClass().getName(), "constructor", e);
			throw e;
		} catch (SQLException e) {
			logger.throwing(getClass().getName(), "constructor", e);
			throw e;
		} catch (NullPointerException e) {
			logger.throwing(getClass().getName(), "constructor", e);
			throw e;
		} catch (FileNotFoundException e) {
			logger.throwing(getClass().getName(), "constructor", e);
			throw e;
		} finally {
			readUser = writeUser = null;
		}
	}

	/**
	 * Load the database configurations from the YAML file
	 *
	 * @param configFileName Configuration file URI
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private void loadDatabaseConfig(String configFileName) throws FileNotFoundException {
		getYamlReader().loadFile(configFileName);
		dbConfig = (Map<String, Object>) getYamlReader().getValue(DB);
	}

	/**
	 * Construct the SQL connection URL using the details from
	 * DB configuration file.
	 *
	 * @return The SQL connection URL
	 */
	private String getUrl() {
		return "jdbc:mysql://"+
			(String)dbConfig.get(DB_HOST)+":"+
			(Integer)dbConfig.get(DB_PORT)+"/"+
			(String)dbConfig.get(DB_SCHEMA);
	}

	@Override
	public String toString() {
		return "read_conn: "+
				connectionManager.getReadConnection()+
				"\nwrite_conn: "+
				connectionManager.getWriteConnection();
	}
}
