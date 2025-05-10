package RequestResponseSpecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ReqspecBuilderTest {
	public static RequestSpecification userReqSpec() {
		
		//request specification by using builder method
		
		RequestSpecification reqspec=new RequestSpecBuilder()
		.setBaseUri("https://gorest.co.in")
		.setContentType(ContentType.JSON)
		//.addHeader("Authorization", "Bearer ")
		.build();
		return reqspec;
	}

	@Test
	public void getUsersTest() {
		given()
		.spec(userReqSpec())
		.get();
	}
}
