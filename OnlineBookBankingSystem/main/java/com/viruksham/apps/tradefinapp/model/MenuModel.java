/**
 * 
 */
package com.viruksham.apps.tradefinapp.model;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.viruksham.apps.tradefinapp.dao.MenuDao;

/**
 * @author brajagopal
 *
 */
public class MenuModel {

	private MenuDao menuDao = null;
	private static Map<String, Object> mockUserData = initMockUserData();

	public MenuModel() throws ClassNotFoundException, SQLException, FileNotFoundException {
		menuDao = new MenuDao();
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
	 
	 	public Object getMenuList() {
		return menuDao.getMenuList();
	}
	 
	public Object getMenuGet(String userid) {
		
		return menuDao.getMenuGet(userid);
	}

	 	public Object getUserMenuList() {
		return menuDao.getUserMenuList();
	}
	
	
	/**
	 * Validate the user based on the supplied credentials
	 * TODO Implement API keys
	 *
	 * @param userName The username supplied from the client
	 * @param hash The secret hash
	 * @return Authentication result
	 */
	/*public boolean isValidUser(String userName, String hash) {
		return menuDao.validateUser(userName, hash);
	}*/
}
