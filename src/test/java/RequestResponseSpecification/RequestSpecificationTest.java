package RequestResponseSpecification;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationTest {
	
	@Test
	public void reqSpecTest() {
		RequestSpecification reqspec=RestAssured.given()
		.baseUri("https://jsonplaceholder.typicode.com")
		.header("Content-Type","application/json");
		
		//above reqspec can be used multiple times
		
		reqspec.get("/posts")
		.then().log().all()
		.statusCode(200);
		
		reqspec.get("/comments")
		.then().log().all()
		.statusCode(200);
		
		reqspec.post("/posts")
		.then().log().all()
		.statusCode(201);	
		
	}
	@Test
	public void reqSpecGoRestWithQueryParamTest() {
		
		RequestSpecification reqsp = RestAssured.given()
				.baseUri("https://gorest.co.in")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer ");
	}
	
	

}
