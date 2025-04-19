package POSTAPITESTS;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.http.ContentType;

public class CreateUserTest {

	//Post-create user test -201 -user id created
	//

	String emailId = getRandomEmailId();
	String json = new String(Files.readAllBytes(Paths.get("./src/test/resources/user.json")));
	String updatedJson = json.replace("{{emailId}}",emailId);

	Integer id =given().log().all()
	.header("Authorization","")
	.contentType(ContentType.JSON)
	.body(updatedJson)
	.when()
	.post("/contacts")
	.then()
	.extract().path("id");
    //System.out.println("user id is" +id);
	
	
	
	public String getRandomEmailId() {

		return "api"+System.currentTimeMillis()+"@opencart.com";
	}
}



