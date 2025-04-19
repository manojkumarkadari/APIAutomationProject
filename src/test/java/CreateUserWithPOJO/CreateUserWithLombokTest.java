package CreateUserWithPOJO;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CreateUserWithPOJO.UserLombok.UserLombokBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUserWithLombokTest {
	
	public String getRandomEmailId() {

		return "api"+System.currentTimeMillis()+"@opencart.com";
	}
	
	
@Test	
public void addUserLombokTest() {
	RestAssured.baseURI="https://gorest.co.in";
	UserLombok user = new UserLombok("seema",getRandomEmailId(),"female","active");
	
	System.out.println("user is"+user);
	
	Integer id = given().log().all()
	.header("Authorization","")
	.contentType(ContentType.JSON)
	.body(user)
	.when()
	.post("/public/v2/users")
	.then().log().all()
	.statusCode(201)
	.extract().path("id");
	
	//2-Get use id 
	given().log().all()
	.header("Authorization","")
	.when()
	.get("/public/v2/users/+id+");
}

@Test
public void addUserLombokBuilderTest() {
	RestAssured.baseURI="https://gorest.co.in";
//	UserLombok user = new UserLombok("seema",getRandomEmailId(),"female","active");
UserLombok user = new UserLombok.UserLombokBuilder()
.name("seema")
.email(getRandomEmailId())
.gender("male")
.status("active").build();
	
	System.out.println("user is"+user);
	
	Integer id = given().log().all()
	.header("Authorization","")
	.contentType(ContentType.JSON)
	.body(user)
	.when()
	.post("/public/v2/users")
	.then().log().all()
	.statusCode(201)
	.extract().path("id");

}
}
