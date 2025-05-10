package RequestResponseSpecification;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.anyOf;

public class RequestResponseSpecTest {
	
	RequestSpecification reqspec;
	ResponseSpecification resspec,resspec_201;
	
	//reqspec and resspec are reusable specifications for rest api's 
	
	@BeforeTest
	public void setup() {
		reqspec = given().log().all()
				.baseUri("https://gorest.co.in")
				.header("","");
				
		resspec= expect()
		.statusCode(200).log().all()
		.header("Content-Type","application/json; charset=utf-8")
		.header("server","cloudfare")
		.time(lessThan(1000L));
		
		//another resspec 
		resspec_201= expect()
		.statusCode(201).log().all()
		.header("Content-Type","application/json; charset=utf-8")
		.header("server","cloudfare")
		.time(lessThan(1000L));
	}

@Test
public void getUsersTest() {
	reqspec.get("/public/v2/users")
	.then()
	.spec(resspec);
}
public void createUserTest() {
	
	reqspec.post();
}
}
