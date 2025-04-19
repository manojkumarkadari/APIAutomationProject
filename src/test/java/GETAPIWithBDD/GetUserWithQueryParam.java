package GETAPIWithBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import  io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetUserWithQueryParam {
	
	@Test
	public void getSingleUserTest() {
		RestAssured.baseURI="https://gorest.co.in";
		ValidatableResponse response = 
				given()
				.queryParam("name", "naveen")
				.queryParam("status","active")
				.when()
				.get("/public/v2/users")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
				
				
	}
	@Test
	public void getSingleUserTestWithQueryParamsUsingHashMap() {
		RestAssured.baseURI="https://gorest.co.in";
		
		Map<String,String> userQueryMap = new HashMap<String,String>();
		userQueryMap.put("name", "naveen");
		userQueryMap.put("status", "active");
	//	ValidatableResponse response = 
				given()
				.queryParams(userQueryMap)
				.when()
				.get("/public/v2/users")
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
				
	}

	
}
