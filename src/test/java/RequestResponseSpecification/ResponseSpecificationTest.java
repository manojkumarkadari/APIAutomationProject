package RequestResponseSpecification;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class ResponseSpecificationTest {
	
@Test
public void responseSpecTest() {
	ResponseSpecification respSpec = expect()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.header("Server","cloudflare");
	
	
	
}

}
