package CreateUserWithPOJO;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUserTestWithPOJO {
	
	public String getRandomEmailId() {

		return "api"+System.currentTimeMillis()+"@opencart.com";
	}
	
	@Test
	public void addUserTest() {
	RestAssured.baseURI="https://gorest.co.in";
	user user =new user("manoj",getRandomEmailId(),"male","active");
	Integer id = given().log().all()
	.header("Authorization","")
	.contentType(ContentType.JSON)
	.body(user)
	.when()
	.post("/public/v2/users")
	.then().log().all()
	.statusCode(201)
	.extract().path("id");
	
	///Get API for created user

	}

}
