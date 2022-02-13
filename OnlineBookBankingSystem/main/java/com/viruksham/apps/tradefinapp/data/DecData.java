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
public class DecData extends BaseData{
  
	private static final String ID 						= "id";
    private static final String STATUS        		    = "status";
    
    private String id 									= null;
    private String status                       		= null;
     
    private Map<String, Object> Decdata = null;
  
    public DecData(Map<String, Object> data) {
        Decdata = data;
        //System.out.println("Decdata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createDec() throws Exception {
		System.out.println("entered into create DecDoc data");
        if(Decdata != null) {			
            id	 						= (String) Decdata.get(DecData.ID);                   
            status   	 				= (String) Decdata.get(DecData.STATUS);
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
  
    public String getstatus() {
        return status;        
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
