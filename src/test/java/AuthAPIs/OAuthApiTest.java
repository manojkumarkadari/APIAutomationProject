package AuthAPIs;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OAuthApiTest {
	
@BeforeMethod
public void getAccessToken() {
	RestAssured.baseURI ="https://test.api.amadeus.com";
	
	Response response = RestAssured.given()
			.contentType(ContentType.URLENC)
			.
			
}

}
