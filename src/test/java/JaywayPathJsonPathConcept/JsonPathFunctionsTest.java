package JaywayPathJsonPathConcept;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class JsonPathFunctionsTest {
	
	@Test
	public void getProductAPITest_JsonPath() {
		RestAssured.baseURI ="https://fakestoreapi.com";
		Response response =given().when().get("/products");
		String jsonresponse = response.asString();
		System.out.println("response is " +jsonresponse);
		
		JsonPath.parse(jsonresponse);
	}

}
