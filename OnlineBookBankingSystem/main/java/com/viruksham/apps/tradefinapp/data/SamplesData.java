package com.viruksham.apps.tradefinapp.data;
  
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
  
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
  
import com.viruksham.utils.security.SecurityUtil;
  
/**
 * @author bala
 *
 */
@JsonAutoDetect(value=JsonMethod.NONE)
public class SamplesData extends BaseData{
  
    private static final String ID		 								= "id";
    private static final String SAMPLESONE		 							= "samplesone";
    private static final String SAMPLESTWO 									= "samplestwo";
    private static final String SAMPLESTHREE 									= "samplesthree";
    private static final String SAMPLESFOUR 									= "samplesfour";
  
    private String id		 									= null;
    private String samplesone		 								= null;
    private String samplestwo 										= null;
    private String samplesthree 										= null;
    private String samplesfour 										= null;


    private Map<String, Object> samplesdata = null;
  
    public SamplesData(Map<String, Object> data) {
        samplesdata = data;
        System.out.println("Samplesdata map object");
    }
  
    public void createSamples() throws Exception {
		//System.out.println("entered into create Samples data");
        if(samplesdata != null) {
            id		 								= (String) samplesdata.get(SamplesData.ID);
            samplesone		 							= (String) samplesdata.get(SamplesData.SAMPLESONE);
            samplestwo 									= (String) samplesdata.get(SamplesData.SAMPLESTWO);            
            samplesthree 									= (String) samplesdata.get(SamplesData.SAMPLESTHREE);
            samplesfour 									= (String) samplesdata.get(SamplesData.SAMPLESFOUR);

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
  
    public String getsamplesone() {
        return samplesone;
    }
  
    public String getsamplestwo() {
        return samplestwo;
    }
  
    public String getsamplesthree() {
        return samplesthree;
    }
  
    public String getsamplesfour() {
        return samplesfour;
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
