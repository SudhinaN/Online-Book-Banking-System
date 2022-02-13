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

import com.viruksham.apps.tradefinapp.dao.ParamDao;
//import com.viruksham.apps.tradefinapp.data.ParamData;
import com.viruksham.apps.tradefinapp.exceptions.DataMismatchException;
import com.viruksham.utils.security.SecurityUtil;
/**
 * @author brajagopal
 *
 */
public class ParamModel {
	
	private static final String GENERATED_KEY = "GENERATED_KEY";

	private ParamDao paramDao = null;
	//private static Map<String, Object> mockUserData = initMockUserTypeData();

	public ParamModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		paramDao = new ParamDao();
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
	public Object getParamList() {
		
		return paramDao.getParamList();
	}

	public Object getParamGet(String GetID) {
		
		return paramDao.getUserTypeGet(GetID);
	}
	
		public Object insertParamGet(String GetID) {
		
		return paramDao.insertUserTypeGet(GetID);
	}
	
			public Object editParamGet(String NameParam,String id) {
		
		return paramDao.editUserTypeGet(NameParam,id);
	}
	

			public Object insert1ParamGet(String CodeParam,String NameParam) {
		System.out.println("entered into param insert1 model");
		return paramDao.insert1ParamGet(CodeParam,NameParam);
	}

			public Object deleteParamGet(String GetID) {
		
		return paramDao.deleteUserTypeGet(GetID);
	}

			public Object deleteDocType(String GetID) {
		
		return paramDao.deleteDocType(GetID);
	}
	
			public Object deleteDoc(String GetID) {
		
		return paramDao.deleteDoc(GetID);
	}
	
/*		public Object createUser(Map<String, Object> data) throws Exception {
		
		Map<String, Integer> retVal = null;
		ParamData paramData = new ParamData(data);
		paramData.createUser();
		
		// Check if user exists
		if (!userDao.checkUserExists(userData.getUsername())) {
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)paramDao.createUser(paramData)).get(0);

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("uuid", Integer.valueOf(execResult.get(GENERATED_KEY)));
		}
		else {
			throw new UnsupportedOperationException("Username already exists.");
		}
		return retVal;
	}*/


	/**
	 * Validate the user based on the supplied credentials
	 * TODO Implement API keys
	 *
	 * @param userName The username supplied from the client
	 * @param hash The secret hash
	 * @return Authentication result
	 */
	//public boolean isValidUser(String userName, String hash) {
	//	return ParamDao.validateParam(userName, hash);
	//}
}
