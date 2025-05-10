package ContactsAPITESTS;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;


public class ContactAPITest {
	
	
@BeforeMethod
public void getToken() {
	RestAssured.baseURI ="https://thinking-tester-contact-list.herokuapp.com";
	LoginToken logintoken = new LoginToken().LoginTokenBuilder()
	given().log().all()
	.when()
	.body(null)
}

	
	

}
