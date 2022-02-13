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
public class AppprofeesData extends BaseData{
  
	private static final String ID 					= "id";
    private static final String APPLICATIONNO 		= "Application_No";
    private static final String PAYMODE 			= "Pay_Mode";
    private static final String PAYMODEREFNO 		= "Paymode_Refno";
    private static final String PAYMENTREFNO 		= "Payment_Refno";
    private static final String PROCESSINGFEE		= "Processing_Fee";
    private static final String PAYDATE 			= "Pay_Date";

      
    private String id 								= null;
    private String Application_No 					= null;
    private String Pay_Mode 						= null;
    private String Paymode_Refno 					= null;
    private String Payment_Refno 					= null;
    private String Processing_Fee 					= null;
    private String Pay_Date 						= null;


       
      
    private Map<String, Object> Appprofeesdata = null;
  
    public AppprofeesData(Map<String, Object> data) {
        Appprofeesdata = data;
        System.out.println("Appprofeesdata map object");       
    }
  
    public void createAppprofees() throws Exception {
		//System.out.println("entered into create AppprofeesDoc data");
        if(Appprofeesdata != null) {
            id	 			= (String) Appprofeesdata.get(AppprofeesData.ID);           
            Application_No 	= (String) Appprofeesdata.get(AppprofeesData.APPLICATIONNO);     
			Pay_Mode 		= (String) Appprofeesdata.get(AppprofeesData.PAYMODE);
			Paymode_Refno 	= (String) Appprofeesdata.get(AppprofeesData.PAYMODEREFNO);
			Payment_Refno 	= (String) Appprofeesdata.get(AppprofeesData.PAYMENTREFNO);
			Processing_Fee 	= (String) Appprofeesdata.get(AppprofeesData.PROCESSINGFEE);
			Pay_Date 		= (String) Appprofeesdata.get(AppprofeesData.PAYDATE);      
 
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
  
    public String getApplication_No() {
        return Application_No;
    }
    
    public String getPay_Mode() {
        return Pay_Mode;
    }
    
    public String getPaymode_Refno() {
        return Paymode_Refno;
    }
    
    public String getPayment_Refno() {
        return Payment_Refno;
    }
    
    public String getProcessing_Fee() {
        return Processing_Fee;
    }
    
    public String getPay_Date() {
        return Pay_Date;
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
