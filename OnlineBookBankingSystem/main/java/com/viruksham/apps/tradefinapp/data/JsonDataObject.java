/**
 * 
 */
package com.viruksham.apps.tradefinapp.data;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * @author bala
 * 
 */
@JsonAutoDetect(value=JsonMethod.NONE)
public class JsonDataObject {

	protected Map<String, Object> data = new HashMap<String, Object>();
	protected static final String DATA_KEY = "data";

	public static JsonDataObject valueOf(String jsonData) {
		
		ObjectMapper om = new ObjectMapper();
		TypeReference<Map<String, Map<String, Object>>> type =
				new TypeReference<Map<String,Map<String,Object>>>() {};

		try {
			Map<String, Map<String, Object>> data = om.readValue(jsonData, type);
			return processData(data);
		}
		catch (Exception e) {
			throw new IllegalArgumentException("Invalid data: "+jsonData, e);
			
		}
	}

	public static JsonDataObject processData(Map<String, Map<String, Object>> dataMap) {
		JsonDataObject jsonDataObj = new JsonDataObject();
		jsonDataObj.data = dataMap.get(DATA_KEY);
		return jsonDataObj;
	}

	public Map<String, Object> getValue() {
		return data;
	}
}
