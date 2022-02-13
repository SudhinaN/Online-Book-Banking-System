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
public class ActiveData extends BaseData{
  
	private static final String ID 						= "id";
    private static final String STATUS        		    = "status";
    private static final String DEPOSIT        		    = "deposit";
    private static final String REGFEES        		    = "regfees";
    
    private String id 									= null;
    private String status                       		= null;
    private String deposit                       		= null;
    private String regfees                       		= null;
    
    private Map<String, Object> Activedata = null;
  
    public ActiveData(Map<String, Object> data) {
        Activedata = data;
        //System.out.println("Activedata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createActive() throws Exception {
		System.out.println("entered into create ActiveDoc data");
        if(Activedata != null) {			
            id	 						= (String) Activedata.get(ActiveData.ID);                   
            status   	 				= (String) Activedata.get(ActiveData.STATUS);
			deposit   	 				= (String) Activedata.get(ActiveData.DEPOSIT);
			regfees   	 				= (String) Activedata.get(ActiveData.REGFEES);
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
    
    public String getdeposit() {
        return deposit;        
    }
    
    public String getregfees() {
        return regfees;        
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
