package com.viruksham.apps.tradefinapp.data;
  
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
  
import java.util.List;
import java.util.*;
import java.sql.*;
  
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
  
import com.viruksham.utils.security.SecurityUtil;
  
/**
 * @author bala
 *
 */
@JsonAutoDetect(value=JsonMethod.NONE)
public class AppData extends BaseData{
  
    private static final String ID      		= "id";
    private static final String FIRSTNAME 		= "firstname";
    private static final String LASTNAME	    = "lastname";
    private static final String GENDER			= "gender";
    private static final String ADDRESS		   	= "address";
    private static final String SUBJECT			= "Subject";
    
    
    private String id       					= null;
    private String firstname 					= null;
    private String lastname 					= null;
    private String gender						= null;
    private String address 						= null;
	private String Subject 						= null;
	
    
    
    private Map<String, Object> Appdata = null;
  
    public AppData(Map<String, Object> data) {
        Appdata = data;
        //System.out.println("Appdata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createApp() throws Exception {
		System.out.println("entered into create AppDoc data");
        if(Appdata != null) {
			id			                = (String) Appdata.get(AppData.ID);
            firstname	 				= (String) Appdata.get(AppData.FIRSTNAME);                   
            lastname	 				= (String) Appdata.get(AppData.LASTNAME);           
            gender						= (String) Appdata.get(AppData.GENDER);           
            address	 				    = (String) Appdata.get(AppData.ADDRESS);         
			Subject	 					= (String) Appdata.get(AppData.SUBJECT);			
            //e.printstacktrace();       
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
    
    public String getfirstname() {
        return firstname;
    }
  
    public String getlastname() {
        return lastname;
    }
  
    public String getgender() {
        return gender;
    }
  
    public String getaddress() {
        return address;        
    }    
    public String getSubject() {
        return Subject;        
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
