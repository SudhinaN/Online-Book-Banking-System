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
public class BookbranchData extends BaseData{
  
	private static final String ID 						= "id";
    private static final String BOOKID        		    = "bookid";
    private static final String BRANCH        		    = "branch";
    private static final String SEM        		        = "sem";
    
    private String id 									= null;
    private String bookid                       		= null;
    private String branch                       		= null;
    private String sem                           		= null;
    
    private Map<String, Object> Bookbranchdata = null;
  
    public BookbranchData(Map<String, Object> data) {
        Bookbranchdata = data;
        //System.out.println("Bookbranchdata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createBookbranch() throws Exception {
		System.out.println("entered into create BookbranchDoc data");
        if(Bookbranchdata != null) {			
            id	 						= (String) Bookbranchdata.get(BookbranchData.ID);                   
            bookid   	 				= (String) Bookbranchdata.get(BookbranchData.BOOKID);
			branch   	 				= (String) Bookbranchdata.get(BookbranchData.BRANCH);
			sem      	 				= (String) Bookbranchdata.get(BookbranchData.SEM);
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
  
    public String getbookid() {
        return bookid;        
    }
    
    public String getbranch() {
        return branch;        
    }
    
    public String getsem() {
        return sem;        
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
