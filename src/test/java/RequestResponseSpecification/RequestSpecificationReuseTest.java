package RequestResponseSpecification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationReuseTest {
	
	RequestSpecification reqspec;
	
	@BeforeMethod
	public void setup() {
		reqspec = RestAssured.given()
				.baseUri("https://gorest.co.in")
				.header("Content-Type","application/json")
				.header("Authorization","Bearer ");
		
	}
	
	@Test
	public void getUserTest() {
		reqspec.when()
		.get("/public/v2/users")
		.then()
		.assertThat().statusCode(200);
	}
@Test
public void getSingleUserTest() {
	reqspec.when()
	.get("/public/v2/users/2345")
	.then()
	.assertThat().statusCode(200);
}
}
