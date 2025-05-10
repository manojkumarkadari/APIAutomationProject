package AuthAPIs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class AuthAPIsTest {
	
	//basic
	//digest
	//api key
	//Oauth1
	//Oauth2
	//JWT
	//Bearer Token
	@Test
	public void basicAuthAPITest() {
		RestAssured.baseURI="https://the-internet.herokuapp.com";
		
		given()
		.auth()
		.basic("admin", "admin")
		.when()
		.get("/basic_auth")
		.then().log().all()
		.assertThat().statusCode(200);
	}
	
	
	@Test
	public void digestAuthAPITest() {
		RestAssured.baseURI= "https:/postman-echo.com";
	
		given().log().all()
		.auth()
		.digest("postman", "password")
		.when()
		.get("/digest-auth")
		.then().log().all()
		.assertThat().statusCode(200);
	}

}
