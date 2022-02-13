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
public class FeedData extends BaseData{
  
	private static final String ID 						= "id";
    private static final String FID	    		        = "fid";
    private static final String NAME					= "Name";
    private static final String EMAILID  				= "emailid";
    private static final String RATING				    = "rating";
    private static final String COMMENT			        = "comment";
    
    private String id 									= null;
    private String fid 								    = null;
    private String Name								    = null;
    private String emailid						        = null;
	private String rating 								= null;
	private String comment  							= null;
	
    private Map<String, Object> Feeddata = null;
  
    public FeedData(Map<String, Object> data) {
        Feeddata = data;
        //System.out.println("Feeddata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createFeed() throws Exception {
		System.out.println("entered into create FeedDoc data");
        if(Feeddata != null) {			
            id	 					= (String) Feeddata.get(FeedData.ID);                   
            fid	 				    = (String) Feeddata.get(FeedData.FID);           
            Name					= (String) Feeddata.get(FeedData.NAME);           
            emailid	 			    = (String) Feeddata.get(FeedData.EMAILID);         
			rating	 				= (String) Feeddata.get(FeedData.RATING); 
			comment  	 			= (String) Feeddata.get(FeedData.COMMENT); 
			
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
  
    public String getfid() {
        return fid;
    }
  
    public String getName() {
        return Name;
    }
  
    public String getemailid() {
        return emailid;        
    }   
     
    public String getrating() {
        return rating;        
    }
    
    public String getcomment() {
        return comment;        
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
