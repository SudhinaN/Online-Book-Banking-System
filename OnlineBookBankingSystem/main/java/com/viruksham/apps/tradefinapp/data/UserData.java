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
public class UserData extends BaseData{
  
    private static final String ID = "id";
    private static final String USERID = "UserID";
    private static final String USERNAME = "Name_User";
    private static final String TEXTPASSWORD = "Text_Password";
    private static final String CODEUSERROLE = "Code_UserRole";
    private static final String CODEUSERGROUP = "Code_UserGroup";
    private static final String IDMENUGROUP = "ID_MenuGroup";
  
    private String id = null;
    private String UserID = null;
    private String Name_User = null;
    private String Text_Password = null;
    private String Code_UserRole = null;
    private String Code_UserGroup = null;
    private String ID_MenuGroup = null;

  
    private Map<String, Object> userdata = null;
  
    public UserData(Map<String, Object> data) {
        userdata = data;
        System.out.println("userdata map object");
        
        
    }
  
    public void createUser() throws Exception {
		//System.out.println("entered into create user data");
        if(userdata != null) {
            id = (String) userdata.get(UserData.ID);
            UserID = (String) userdata.get(UserData.USERID);
           //System.out.println(UserID);
            Name_User = (String) userdata.get(UserData.USERNAME);
            //System.out.println(Name_User);
			Text_Password = (String) userdata.get(UserData.TEXTPASSWORD);
			//System.out.println(Text_Password);
			Code_UserRole = (String) userdata.get(UserData.CODEUSERROLE);
			//System.out.println(Code_UserRole);
			Code_UserGroup = (String) userdata.get(UserData.CODEUSERGROUP);
			//System.out.println(Code_UserGroup);
			ID_MenuGroup = (String) userdata.get(UserData.IDMENUGROUP);
			//System.out.println(ID_MenuGroup);

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
  
    public String getUserID() {
        return UserID;
    }
  
    public String getName_User() {
        return Name_User;
    }
  
  
    public String getText_Password() {
        return Text_Password;
    }
    
    public String getCode_UserRole() {
        return Code_UserRole;
    }
    
    public String getCode_UserGroup() {
        return Code_UserGroup;
    }
    
    public String getID_MenuGroup() {
        return ID_MenuGroup;
    }
  
    public Map<String, Object> getUserdata() {
        return userdata;
    }
  
  /*  public int getUuid() {
        return uuid;
    }*/
  
    /**
     * @param uuid the uuid to set
     */
  /*  public void setUuid(int uuid) {
        this.uuid = uuid;
    }*/
}
