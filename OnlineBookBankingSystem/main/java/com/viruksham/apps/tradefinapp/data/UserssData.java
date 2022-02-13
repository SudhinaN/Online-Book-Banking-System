package com.viruksham.apps.tradefinapp.data;
  
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
  
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
  
import com.viruksham.utils.security.SecurityUtil;
  
/**
 * @author bala
 *
 */
@JsonAutoDetect(value=JsonMethod.NONE)
public class UserssData extends BaseData{
  
    private static final String ID		 								= "id";
    private static final String USER_ID		 							= "user_id";
    private static final String USER_NAME 									= "user_name";
    private static final String USER_PASSWORD 									= "user_password";
    private static final String USER_ROLE 									= "user_role";
  
    private String id		 									= null;
    private String user_id		 								= null;
    private String user_name 										= null;
    private String user_password 										= null;
    private String user_role 										= null;


    private Map<String, Object> userssdata = null;
  
    public UserssData(Map<String, Object> data) {
        userssdata = data;
        System.out.println("Userssdata map object");
    }
  
    public void createUserss() throws Exception {
		//System.out.println("entered into create Userss data");
        if(userssdata != null) {
            id		 								= (String) userssdata.get(UserssData.ID);
            user_id		 							= (String) userssdata.get(UserssData.USER_ID);
            user_name 									= (String) userssdata.get(UserssData.USER_NAME);            
            user_password 									= (String) userssdata.get(UserssData.USER_PASSWORD);
            user_role 									= (String) userssdata.get(UserssData.USER_ROLE);

    }
}
  
  /*  public Map<String, Integer> getResponseData() {
        Map<String, Integer> responseData = new HashMap<String, Integer>();
        responseData.put("UserID", getUserID());
        return responseData;
    }*/
  
    public String getid() {
        return id;
    }
  
    public String getuser_id() {
        return user_id;
    }
  
    public String getuser_name() {
        return user_name;
    }
  
    public String getuser_password() {
        return user_password;
    }
  
    public String getuser_role() {
        return user_role;
    }

      /**
     * @param uuid the uuid to set
     */
/*  public void setUuid(int uuid) {
        this.uuid = uuid;
    }
*/
}
/********************************OVER******************************************/
