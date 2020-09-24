package com.testing.booking;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseAPI {

	public static Response getRequest(String uri, Map<String, String> requestHeaders) {

		if (requestHeaders == null) {
			System.out.print("================GET REQUEST WITHOUT HEADER================");
			Response response = RestAssured.given().contentType(ContentType.JSON).accept("application/json").when().relaxedHTTPSValidation().log().all().get(uri);
			return response;
		} else {
			System.out.print("================GET REQUEST WITH HEADER================");
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").headers(requestHeaders).when().log().all().get(uri);
			return response;
		}
	}

	public static Response postRequest(String uri, Object requestBody, Map<String, String> requestHeaders) {

		if (requestHeaders == null) {
			System.out.print("================POST REQUEST WITHOUT HEADER================");
			System.out.print("Request Body =" + requestBody);
			Response response = RestAssured.given().contentType(ContentType.JSON).accept("application/json").body(requestBody).log().all().post(uri);
			return response;
		} else {
			System.out.print("================POST REQUEST WITH HEADER================");
			System.out.print("Request Body =" + requestBody);
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").headers(requestHeaders).body(requestBody).when().log().all().post(uri);
			return response;
		}
	}

	public static Response putRequest(String uri, Object requestBody, Map<String, String> requestHeaders) {

		if (requestHeaders == null) {
			System.out.print("================PUT REQUEST WITHOUT HEADER================");
			System.out.print("Request Body =" + requestBody);
			Response response = RestAssured.given().contentType(ContentType.JSON).accept("application/json").body(requestBody).log().all().put(uri);
			return response;
		} else {
			System.out.print("================PUT REQUEST WITH HEADER================");
			System.out.print("Request Body =" + requestBody);
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").headers(requestHeaders).body(requestBody).when().relaxedHTTPSValidation().log().all().put(uri);
			return response;
		}
	}

	public static Response deleteAPIRequest(String uri, Object requestBody, Map<String, String> requestHeaders) {

		if (requestHeaders == null) {
			System.out.print("================DELETE REQUEST WITHOUT HEADER================");
			System.out.print("Request Body =" + requestBody);
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").body(requestBody).when().relaxedHTTPSValidation().log().all().delete(uri);
			return response;
		} else {
			System.out.print("================DELETE REQUEST WITH HEADER================");
			System.out.print("Request Body =" + requestBody);
			Response response = RestAssured.given().config(RestAssured.config()).contentType("application/json").headers(requestHeaders).body(requestBody).when().relaxedHTTPSValidation().log().all().delete(uri);
			return response;
		}
	}
}
