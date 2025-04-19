package GETAPIWithBDD;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ContactListAPITest {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
	}
	
	@Test
	public void getContactsAPITest() {
		
		given()
		.header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDg3MWE2NmY2ZDEzYzAwMTM3Y2IzMWEiLCJpYXQiOjE3NDQwMzkzOTF9.9CXlIJZHb0EbjJ4iCdf3-IIVVD3loSzu1i0RPmRvH9c")
		.when()
		.get("/contacts")
		.then().log().all()
		.assertThat()
		.statusCode(200);	
		
	}
	
	@Test
	public void getContactsAPITestAuthError() {
		
		given()
		.header("Authorization","wrongautheyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDg3MWE2NmY2ZDEzYzAwMTM3Y2IzMWEiLCJpYXQiOjE3NDQwMzkzOTF9.9CXlIJZHb0EbjJ4iCdf3-IIVVD3loSzu1i0RPmRvH9c")
		.when()
		.get("/contacts")
		.then().log().all()
		.assertThat()
		.statusCode(401); //status code should be 401 for unauthorized	
		
	}
	@Test
	public void getContactsAPITestInvalidTokenTest() {
		
		String errorMsg =given()
		.header("Authorization","wrong-auth-eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NDg3MWE2NmY2ZDEzYzAwMTM3Y2IzMWEiLCJpYXQiOjE3NDQwMzkzOTF9.9CXlIJZHb0EbjJ4iCdf3-IIVVD3loSzu1i0RPmRvH9c")
			.when()
				.get("/contacts")
					.then().log().all()
						.extract().path("error");
		System.out.println("error msg is "+errorMsg);
		Assert.assertEquals(errorMsg, "Please authenticate.");
		
	}

}
