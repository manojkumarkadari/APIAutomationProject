package GETAPIWithBDD;

import org.hamcrest.collection.HasItemInArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.hamcrest.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class GetUserPostWithPathParam {
	
	@DataProvider
	public Object[][] getUserData(){
		return new Object[][] {
			{7820539,},
			{},
			{}
		};
		
	}
	
	@Test
	public void getUserPostWithPathParam() {
		RestAssured.baseURI="https://gorest.co.in";
		given().log().all()
		.pathParam("userId",7820539)
		.when()
		.get("/public/v2/users/{userId}/posts")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
		
	}
	
	@Test
	public void getUserPostWithPathParamUsingHashMapTest(int userId,String title) {
		RestAssured.baseURI="https://reques.in";
		Map<String,String> pathParamMap = new HashMap<String,String>();
		pathParamMap.put("firstPath", "api");
		pathParamMap.put("secondPath", "users");
		given().log().all()
		.pathParam("page",2)
		.when()
		.get("/{firstPath}/{secondPath}")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
		
	}


}
