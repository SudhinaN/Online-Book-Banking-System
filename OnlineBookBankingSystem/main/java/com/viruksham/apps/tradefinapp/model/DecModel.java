/**
 * 
 */
package com.viruksham.apps.tradefinapp.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.viruksham.apps.tradefinapp.dao.DecDao;
import com.viruksham.apps.tradefinapp.data.DecData;
import com.viruksham.apps.tradefinapp.exceptions.DataMismatchException;
import com.viruksham.utils.security.SecurityUtil;

/**
 * @author brajagopal
 *
 */
public class DecModel {
	
	private static final String GENERATED_KEY = "GENERATED_KEY";

	private DecDao DecDao = null;
	//private static Map<String, Object> mockUserData = initMockDecData();

	public DecModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		DecDao = new DecDao();
	}

	/**
	 * Initialize mock user data (For test purposes)
	 * This would be replaced by data from the backend DB
	 *
	 * @return user mappings
	 */
	@Deprecated
	private static Map<String, Object> initMockUserData() {
		Map<String, Object> userData = new HashMap<String, Object>();
		for (int i = 0; i < 5; i++) {
			Map<String, Object> userDetails = new HashMap<String, Object>();
			int id = i+1;
			userDetails.put("user_id", String.valueOf(id));
			userDetails.put("username", "MockUser"+id);
			userDetails.put("is_admin", (i%2)==1 ? Boolean.TRUE : Boolean.FALSE);
			userData.put(String.valueOf(id), userDetails);
		}

		return userData;
	}

	/**
	 * Retrieve the user list by invoking methods in the
	 * UserDao class.
	 *
	 * @return Returns a list of maps containing user information
	 */
	public Object getUserTypeList() {
		System.out.println("entered into company master model list");
		return DecDao.getUserTypeList();
	}

	public Object getUserTypeGet(String GetID) {
System.out.println("entered into Dec model");
		return DecDao.getUserTypeGet(GetID);
	}

	public Object getUserTypeDelete(String delete) {
		return DecDao.getUserTypeDelete(delete);
	}

		public Object insertdata(Map<String, Object> data) throws Exception {
	System.out.println("entered into add customer model");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(data);
		Map<String, Integer> retVal = null;
		DecData DecData = new DecData(data);
		DecData.createDec();
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) ((List<Object>)DecDao.insertdata(DecData));
			retVal = new HashMap<String, Integer>();
			// Retrieve the uuid
			retVal.put("id", Integer.valueOf(execResult.get(GENERATED_KEY)));	
		return retVal;
	}
	
	public Object editdata(Map<String, Object> data) throws Exception {
	System.out.println("entered into update customer model");
		Map<String, Integer> retVal = null;
		DecData DecData = new DecData(data);
		DecData.createDec();
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGg");
		System.out.println(data+"hi");
		System.out.println(DecData+"hi");		
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) ((List<Object>)DecDao.editdata(DecData));
			retVal = new HashMap<String, Integer>();
			// Retrieve the uuid
			retVal.put("id", Integer.valueOf(execResult.get(GENERATED_KEY)));	
		return retVal;
	}

	/**
	 * Validate the user based on the supplied credentials
	 * TODO Implement API keys
	 *
	 * @param userName The username supplied from the client
	 * @param hash The secret hash
	 * @return Authentication result
	 */
	//public boolean isValidUser(String userName, String hash) {
	//	return userTypeDao.validateUserType(userName, hash);
	//}
}
