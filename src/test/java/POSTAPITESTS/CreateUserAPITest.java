package POSTAPITESTS;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateUserAPITest {
	
@BeforeTest
 public void BeforeMethod() {
	RestAssured.baseURI="https://gorest.co.in";
}
	
@Test
public void createUserWithJSONStringTest() {
	//File userJsonFile = new File("./src/test/resources/user.json");
	
	given()  
	.header("Authorization","Bearer 2ccef6850fb810e5876729630d94ad99fe5d592a63afe909524d3b89c68eba66")
	.contentType(ContentType.JSON)
	.body(new File("./src/test/resources/user.json"))
	.when()
	.post("/public/v2/users")
	.then().log().all()
	.assertThat()
	.statusCode(200);
	
}

@Test
public void createUserWithJSONFileWithStringReplacementTest() throws IOException{
	
	String emailId = getRandomEmailId();
	String json = new String(Files.readAllBytes(Paths.get("./src/test/resources/user.json")));
	String updatedJson = json.replace("{{emailId}}",emailId);

	given().log().all()
	.header("Authorization","")
	.contentType(ContentType.JSON)
	.body(updatedJson)
	.when()
	.post("/contacts")
	.then()
	.extract().path("id");
}

private String getRandomEmailId() {

	return "api"+System.currentTimeMillis()+"@opencart.com";
}


	
	

}
