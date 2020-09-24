package com.testing.booking;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIUtils {
	
	//This method is used to get value on the basis of Field path in JSON
	public static String getParameterFromResponse(Response response, String key) {

		JsonPath jsonPathEvaluator = response.jsonPath();
		String value = jsonPathEvaluator.get(key).toString();
		return value;
	}
	
	//This method will convert JSON file into JSON Object
	public static JSONObject jsonFileConversion(String filePath) throws JSONException, IOException{
		FileInputStream file = new FileInputStream(filePath);
		return new JSONObject(IOUtils.toString(file, "UTF-8"));
	}
	
	//This method will compare two JSON Strings 
	public static boolean jsonComparator(String s1, String s2) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		if(mapper.readTree(s1).equals(mapper.readTree(s2))){
			return true;
		} else {
			return false;
		}
	}
}
