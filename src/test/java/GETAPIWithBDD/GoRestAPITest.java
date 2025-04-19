package GETAPIWithBDD;
import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class GoRestAPITest {
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI="https://gorest.co.in";
		
	}
	@Test
	public void getSingleUser() {
		Response response =given()
		//.header("Authorization","Bearer ")
		.get("/public/v2/users/7817908");
		System.out.println(response.asPrettyString());
		
		JsonPath js = response.jsonPath();
		int userId = js.getInt("id");
		System.out.println("User id is "+userId);
		Assert.assertEquals(userId, 7817908);
		
		JsonPath js1 = response.jsonPath();
		String name = js1.getString("name");
		System.out.println("Name is "+name);
		Assert.assertEquals(name, "Bhargavi Bharadwaj VM");
	}
	
	@Test
	public void getAllUsers() {
		Response response =given()
		//.header("Authorization","Bearer ")
		.get("/public/v2/users");
		//System.out.println(response.asPrettyString());
		
		JsonPath js = response.jsonPath();
		List<Integer>idList =js.getList("id");
		System.out.println("id list is "+idList);

	}

}
