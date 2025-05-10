package RequestResponseSpecification;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;

import org.testng.annotations.Test;

public class ResponseSpecBuilderTest {
public static ResponseSpecification responseSpec() {
		
		//request specification by using builder method
		
		ResponseSpecification resspec=new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectHeader("header","cloudfare")
		.build();
		return resspec;
	}

@Test
public void getUsersTest() {
	RestAssured.baseURI ="https://gorest.co.in";
	RestAssured.given()
	.when()
	.get("/public/v2/users")
	.then()
	.assertThat()
.statusCode(200); //need to change code here 

}
	

}
