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
public class BookcopyData extends BaseData{
  
	private static final String BOOKCOPYID				= "bookcopyid";
    private static final String BOOKID        		    = "bookid";
    private static final String BOOKNO        		    = "bookno";
    private static final String RATE        		    = "rate";
    private static final String STATUS        		    = "status";
        
    private String bookcopyid 							= null;
    private String bookid                       		= null;
    private String bookno                       		= null;
    private String rate                       		    = null;
    private String status                       		= null;
    
    private Map<String, Object> Bookcopydata = null;
  
    public BookcopyData(Map<String, Object> data) {
        Bookcopydata = data;
        //System.out.println("Bookcopydata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createBookcopy() throws Exception {
		System.out.println("entered into create BookcopyDoc data");
        if(Bookcopydata != null) {			
            bookcopyid	 						= (String) Bookcopydata.get(BookcopyData.BOOKCOPYID);                   
            bookid   	 				        = (String) Bookcopydata.get(BookcopyData.BOOKID);
			bookno   	 				        = (String) Bookcopydata.get(BookcopyData.BOOKNO);
			rate   	 				            = (String) Bookcopydata.get(BookcopyData.RATE);
			status   	 				        = (String) Bookcopydata.get(BookcopyData.STATUS);
            //e.printstacktrace();       
	 }
}
  
  /*  public Map<String, Integer> getResponseData() {
        Map<String, Integer> responseData = new HashMap<String, Integer>();
        responseData.put("UserID", getUserID());
        return responseData;
    }*/
  
    public String getbookcopyid() {
        return bookcopyid;
    }
  
    public String getbookid() {
        return bookid;        
    }
    
    public String getbookno() {
        return bookno;        
    }
    
    public String getrate() {
        return rate;        
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
