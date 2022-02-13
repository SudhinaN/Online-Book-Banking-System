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
public class BookData extends BaseData{
  
	private static final String BOOKID 						= "bookid";
    private static final String BOOKNAME	    		    = "bookname";
    private static final String BOOKAUTHOR					= "bookauthor";
    private static final String STATUS  				   	= "status";
    private static final String RATE					    = "rate";
    
    private String bookid 									= null;
    private String bookname 								= null;
    private String bookauthor								= null;
    private String status						        	= null;
	private String rate 									= null;
	
    private Map<String, Object> Bookdata = null;
  
    public BookData(Map<String, Object> data) {
        Bookdata = data;
        //System.out.println("Bookdata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createBook() throws Exception {
		System.out.println("entered into create BookDoc data");
        if(Bookdata != null) {			
            bookid	 					= (String) Bookdata.get(BookData.BOOKID);                   
            bookname	 				= (String) Bookdata.get(BookData.BOOKNAME);           
            bookauthor					= (String) Bookdata.get(BookData.BOOKAUTHOR);           
            status	 				    = (String) Bookdata.get(BookData.STATUS);         
			rate	 					= (String) Bookdata.get(BookData.RATE); 
			
            //e.printstacktrace();       
	 }
}
  
  /*  public Map<String, Integer> getResponseData() {
        Map<String, Integer> responseData = new HashMap<String, Integer>();
        responseData.put("UserID", getUserID());
        return responseData;
    }*/
  
    public String getbookid() {
        return bookid;
    }
  
    public String getbookname() {
        return bookname;
    }
  
    public String getbookauthor() {
        return bookauthor;
    }
  
    public String getstatus() {
        return status;        
    }    
    public String getrate() {
        return rate;        
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
