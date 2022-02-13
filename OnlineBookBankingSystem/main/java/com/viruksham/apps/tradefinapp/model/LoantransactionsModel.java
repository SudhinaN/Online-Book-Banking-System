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

import com.viruksham.apps.tradefinapp.dao.LoantransactionsDao;
import com.viruksham.apps.tradefinapp.data.LoantransactionsData;
import com.viruksham.apps.tradefinapp.exceptions.DataMismatchException;
import com.viruksham.utils.security.SecurityUtil;



/**
 * @author brajagopal
 *
 */
public class LoantransactionsModel {
	
		private static final String GENERATED_KEY = "GENERATED_KEY";

	private LoantransactionsDao LoantransactionsDao = null;
	//private static Map<String, Object> mockLoantransactionsData = initMockLoantransactionsTypeData();

	public LoantransactionsModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		LoantransactionsDao = new LoantransactionsDao();
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
	
	public Object getLoantransactionsList() {
		
		return LoantransactionsDao.getLoantransactionsList();
	}

		public Object createLoantransactions(Map<String, Object> data) throws Exception {
System.out.println("entered into create Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.createLoantransactions(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
	}

		public Object updateLoantransactions(Map<String, Object> data) throws Exception {
System.out.println("entered into update Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.updateLoantransactions(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
	}

		public Object update1Loantransactions(Map<String, Object> data) throws Exception {
System.out.println("entered into update1 Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.update1Loantransactions(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
	}

		public Object statuseditLoantransactions(Map<String, Object> data) throws Exception {
System.out.println("entered into create Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.statuseditLoantransactions(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
	}

		public Object statusedit1Loantransactions(Map<String, Object> data) throws Exception {
System.out.println("entered into statusedit1 Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.statusedit1Loantransactions(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
	}
	
		public Object statusedit2Loantransactions(Map<String, Object> data) throws Exception {
System.out.println("entered into statusedit2 Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.statusedit2Loantransactions(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
	}
	
		public Object overdueinterest(Map<String, Object> data) throws Exception {
System.out.println("entered into overdue Loantransactions model");
		Map<String, Integer> retVal = null;
		LoantransactionsData LoantransactionsData = new LoantransactionsData(data);
		LoantransactionsData.createLoantransactions();
		System.out.println(data+"hi");
		System.out.println(LoantransactionsData+"hi");

		// Check if Loantransactions exists
		//if (!LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions())) {
		//	System.out.println(LoantransactionsDao.checkLoantransactionsExists(LoantransactionsData.getName_Loantransactions()));
			@SuppressWarnings("unchecked")
			Map<String, String> execResult =
					(Map<String, String>) (
							(List<Object>)LoantransactionsDao.overdueinterest(LoantransactionsData));

			retVal = new HashMap<String, Integer>();

			// Retrieve the uuid
			retVal.put("Enquiry_No", Integer.valueOf(execResult.get(GENERATED_KEY)));
		//}
		//else {
		//	throw new UnsupportedOperationException("Loantransactionsname already exists.");
		//}
		return retVal;
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
