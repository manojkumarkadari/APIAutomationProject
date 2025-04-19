package GETAPIWithNonBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GetContactsAPITest {
	
	@Test
	public void getContactsAPI() {
		RestAssured.baseURI ="https://thinking-tester-contact-list.herokuapp.com";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDg3MWE2NmY2ZDEzYzAwMTM3Y2IzMWEiLCJpYXQiOjE3NDQyOTYxODd9.fuvNfFfOEkewX4BpvimTwKF86plLQdlsf8YhXVLYPmY");
		Response response = request.get("/contacts");
		
		response.prettyPrint();
		//write code to get and put it in list
		
		
		
	}

}
