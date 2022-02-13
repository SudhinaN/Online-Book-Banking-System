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

import com.viruksham.apps.tradefinapp.dao.SamplesDao;
import com.viruksham.apps.tradefinapp.data.SamplesData;
import com.viruksham.apps.tradefinapp.exceptions.DataMismatchException;
import com.viruksham.utils.security.SecurityUtil;



/**
 * @author brajagopal
 *
 */
public class SamplesModel {
	
		private static final String GENERATED_KEY = "GENERATED_KEY";

	private SamplesDao SamplesDao = null;
	//private static Map<String, Object> mockSamplesData = initMockSamplesTypeData();

	public SamplesModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		SamplesDao = new SamplesDao();
	}

	/**
	 * Initialize mock ApplicationDoc data (For test purposes)
	 * This would be replaced by data from the backend DB
	 *
	 * @return ApplicationDoc mappings
	 */
	/*@Deprecated
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
	}*/

	/**
	 * Retrieve the ApplicationDoc list by invoking methods in the
	 * ApplicationDocDao class.
	 *
	 * @return Returns a list of maps containing ApplicationDoc information
	 */
	
	public Object viewall() {
		return SamplesDao.viewall();
	}
	
	public Object view(String GetID) {
		return SamplesDao.view(GetID);
	}

	public Object save(Map<String, Object> data) throws Exception {
		System.out.println("entered into samples delete model");
		Map<String, Integer> retVal = null;
		SamplesData SamplesData = new SamplesData(data);
		SamplesData.createSamples();
		return SamplesDao.save(SamplesData);
	}

	public Object delete(String GetID) {

		return SamplesDao.delete(GetID);
	}

	/**
	 * Validate the ApplicationDoc based on the supplied credentials
	 * TODO Implement API keys
	 *
	 * @param ApplicationDocName The ApplicationDocname supplied from the client
	 * @param hash The secret hash
	 * @return Authentication result
	 */
	//public boolean isValidApplicationDoc(String ApplicationDocName, String hash) {
	//	return ApplicationDocTypeDao.validateUserType(ApplicationDocName, hash);
	//}
}
/**********************************OVER***********************************************/
