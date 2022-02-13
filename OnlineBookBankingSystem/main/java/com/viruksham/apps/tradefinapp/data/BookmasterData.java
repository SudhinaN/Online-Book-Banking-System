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
public class BookmasterData extends BaseData{
  
	private static final String BOOKID 						= "bookid";
    private static final String BOOKNO        		        = "bookno";
    private static final String BOOKNAME        		    = "bookname";
    private static final String BOOKAUTHOR        		    = "bookauthor";
    private static final String BOOKEDITION        		    = "bookedition";
    
    private String bookid 									= null;
    private String bookno                       		    = null;
    private String bookname                       		    = null;
    private String bookauthor                       		= null;
    private String bookedition                       		= null;
    
    private Map<String, Object> Bookmasterdata = null;
  
    public BookmasterData(Map<String, Object> data) {
        Bookmasterdata = data;
        //System.out.println("Bookmasterdata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createBookmaster() throws Exception {
		System.out.println("entered into create BookmasterDoc data");
        if(Bookmasterdata != null) {			
            bookid	 						= (String) Bookmasterdata.get(BookmasterData.BOOKID);                   
            bookno   	 				    = (String) Bookmasterdata.get(BookmasterData.BOOKNO);
			bookname   	 				    = (String) Bookmasterdata.get(BookmasterData.BOOKNAME);
			bookauthor   	 				= (String) Bookmasterdata.get(BookmasterData.BOOKAUTHOR);
			bookedition   	 				= (String) Bookmasterdata.get(BookmasterData.BOOKEDITION);
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
  
    public String getbookno() {
        return bookno;        
    }
    
    public String getbookname() {
        return bookname;        
    }
    
    public String getbookauthor() {
        return bookauthor;        
    }
    
     public String getbookedition() {
        return bookedition;        
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
