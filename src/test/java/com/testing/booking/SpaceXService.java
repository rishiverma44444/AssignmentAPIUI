package com.testing.booking;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class SpaceXService {
	
	Response response;
	@Test(enabled = true , priority = 1, description = "Verify API responding success")
	public void getSuccessValidation(){
		response = BaseAPI.getRequest(GlobalConstants.API_URI, null);
		Assert.assertEquals(response.getStatusCode()	, 200);
	}
	
	@Test(enabled = true , priority = 2, description = "Verify API Response", dependsOnMethods = "getSuccessValidation")
	public void getResponseValidation() throws JSONException, IOException{
		String expected = APIUtils.jsonFileConversion(GlobalConstants.JSON_REPSONSE).toString();
		String actual = response.getBody().asString();
		Assert.assertEquals(true,APIUtils.jsonComparator(expected, actual));
		
	}
	
	@Test(enabled = true , priority = 3, description = "Verify API Response", dependsOnMethods = "getResponseValidation")
	public void getIDValidation(){
		Assert.assertNotNull(APIUtils.getParameterFromResponse(response, "id"));
	}
		
}
