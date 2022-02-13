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
public class ApplicationData extends BaseData{
  
	private static final String ID 						= "id";
    private static final String REGISTRATIONNUMBER	    = "Regno";
    private static final String NAME					= "Name";
    private static final String SEX				     	= "Sex";
    private static final String ADDRESS					= "Address";
    private static final String CITY            	    = "city";
    private static final String PIN					    = "pin";
    private static final String STATE			     	= "state";
    private static final String DATEOFBIRTH 			= "dateofbirth";
    private static final String FATHERNAME 				= "fathername";
    private static final String MOBILENUMBER			= "mobno";
    private static final String LANDLINE				= "landline";
    private static final String EMAILID					= "emailid";
    private static final String COLLEGENAME 			= "colname";
    private static final String SPECIALIZATIONBRANCH	= "spebranch";
    private static final String SEMESTER			 	= "sem";
    private static final String EXAMINATIONNUMBER		= "examno";
    private static final String TITLE           		= "title";
    private static final String CODEUSERROLE   		    = "codeuserrole";
    private static final String IDMENUGROUP        		= "idmenugroup";
    private static final String STATUS        		    = "status";
    private static final String DEPOSIT        		    = "deposit";
    private static final String REGFEES        		    = "regfees";
    
    private String id 									= null;
    private String Regno 								= null;
    private String Name								    = null;
    private String Sex 							        = null;
	private String Address 								= null;
	private String city							    	= null;
    private String pin 							        = null;
	private String state 								= null;
    private String dateofbirth							= null;
    private String fathername 							= null;
    private String mobno								= null;
    private String landline 							= null;
	private String emailid 								= null;
    private String colname 								= null;
    private String spebranch							= null;
    private String sem 							        = null;
	private String examno 								= null;  
    private String title 								= null;  
    private String codeuserrole 						= null;  
    private String idmenugroup 							= null;  
    private String status                       		= null;
    private String deposit                       		= null;
    private String regfees                       		= null;
    
    private Map<String, Object> Applicationdata = null;
  
    public ApplicationData(Map<String, Object> data) {
        Applicationdata = data;
        //System.out.println("Applicationdata map object");       
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//System.out.println(data);    
    }
  
    public void createApplication() throws Exception {
		System.out.println("entered into create ApplicationDoc data");
        if(Applicationdata != null) {			
            id	 						= (String) Applicationdata.get(ApplicationData.ID);                   
            Regno	 					= (String) Applicationdata.get(ApplicationData.REGISTRATIONNUMBER);           
            Name						= (String) Applicationdata.get(ApplicationData.NAME);           
            Sex	 				        = (String) Applicationdata.get(ApplicationData.SEX);         
			Address	 					= (String) Applicationdata.get(ApplicationData.ADDRESS); 
			city				    	= (String) Applicationdata.get(ApplicationData.CITY);           
            pin	 				        = (String) Applicationdata.get(ApplicationData.PIN);         
			state	 					= (String) Applicationdata.get(ApplicationData.STATE);
			dateofbirth	 			    = (String) Applicationdata.get(ApplicationData.DATEOFBIRTH);           
            fathername	 				= (String) Applicationdata.get(ApplicationData.FATHERNAME);           
            mobno						= (String) Applicationdata.get(ApplicationData.MOBILENUMBER);           
            landline	 				= (String) Applicationdata.get(ApplicationData.LANDLINE);         
			emailid	 					= (String) Applicationdata.get(ApplicationData.EMAILID); 
			colname	 					= (String) Applicationdata.get(ApplicationData.COLLEGENAME);           
            spebranch	 				= (String) Applicationdata.get(ApplicationData.SPECIALIZATIONBRANCH);           
            sem						    = (String) Applicationdata.get(ApplicationData.SEMESTER);           
            examno	 				    = (String) Applicationdata.get(ApplicationData.EXAMINATIONNUMBER); 
			title	 				    = (String) Applicationdata.get(ApplicationData.TITLE);
            codeuserrole	 		    = (String) Applicationdata.get(ApplicationData.CODEUSERROLE); 
			idmenugroup	 				= (String) Applicationdata.get(ApplicationData.IDMENUGROUP);
            status   	 				= (String) Applicationdata.get(ApplicationData.STATUS);
			deposit   	 				= (String) Applicationdata.get(ApplicationData.DEPOSIT);
			regfees   	 				= (String) Applicationdata.get(ApplicationData.REGFEES);
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
  
    public String getRegno() {
        return Regno;
    }
  
    public String getName() {
        return Name;
    }
  
    public String getSex() {
        return Sex;        
    }    
    public String getAddress() {
        return Address;        
    }
    
    public String getcity() {
        return city;
    }
  
    public String getpin() {
        return pin;
        
    }
    
    public String getstate() {
        return state;        
    }
    
    
    public String getdateofbirth() {
        return dateofbirth;
    }
  
    public String getfathername() {
        return fathername;
    }
  
    public String getmobno() {
        return mobno;
    }
  
    public String getlandline() {
        return landline;
        
    }
    
    public String getemailid() {
        return emailid;        
    }
    
     public String getcolname() {
        return colname;
    }
  
    public String getspebranch() {
        return spebranch;
        
    }
    
    public String getsem() {
        return sem;        
    }
    
    public String getexamno() {
        return examno;        
    }
    
    public String gettitle() {
        return title;        
    }
    
    public String getcodeuserrole() {
        return codeuserrole;        
    }
    
    public String getidmenugroup() {
        return idmenugroup;        
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
