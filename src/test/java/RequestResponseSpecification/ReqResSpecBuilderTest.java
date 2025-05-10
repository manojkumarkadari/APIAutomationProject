package RequestResponseSpecification;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpecBuilderTest {
	public static RequestSpecification userReqSpec() {
		
		//request specification by using builder method
		
		RequestSpecification reqspec=new RequestSpecBuilder()
		.setBaseUri("https://gorest.co.in")
		.setContentType(ContentType.JSON)
		//.addHeader("Authorization", "Bearer ")
		.build();
		return reqspec;
	}
	
	
public static ResponseSpecification responseSpec() {
		
		//response specification by using builder method
		
		ResponseSpecification resspec=new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectHeader("header","cloudfare")
		.build();
		return resspec;
	}


@Test

public void getUsersTest() {
	
}


}
