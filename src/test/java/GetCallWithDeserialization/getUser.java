package GetCallWithDeserialization;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class getUser {
	
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://gorest.co.in";
	}
	
	
	@Test
	public void getSingleUserTest() {
		Response res = given()
				//.header("Authorization","")
				.when()
				.get("/public/v2/users/7834409");
		//deserialization
		
		String responseBody = res.asString();
		ObjectMapper mapper = new ObjectMapper();
		try {
			User userres = mapper.readValue(res.getBody().asString(), User.class);
			System.out.println("response is "+userres);
					
		}
		catch(JsonProcessingException e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	

}
