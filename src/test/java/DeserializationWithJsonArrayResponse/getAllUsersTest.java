package DeserializationWithJsonArrayResponse;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CreateUserWithPOJO.user;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.*;

public class getAllUsersTest {

	@Test
	public void getAllUsersTest() {
		
		RestAssured.baseURI="https://gorest.co.in";
		Response response = given()
		.header("Authorization","Bearer 2ccef6850fb810e5876729630d94ad99fe5d592a63afe909524d3b89c68eba66")
		.when()
		.get("/public/v2/users");
		response.prettyPrint();
		
		
		//Deserialization :json to pojo
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			User[] userres =objectMapper.readValue(response.getBody().asString(), User[].class);
		
		
		for (User user :userres) {
			//System.out.println("user response is " +userres);
			System.out.println("user id is " +user.getId());
			System.out.println("user name is " +user.getName());
			System.out.println("user email is " +user.getEmail());
			System.out.println("user gender is " +user.getGender());
			System.out.println("user Status is " +user.getStatus());
			
		}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		
	}
}

