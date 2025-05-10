package FakeUserAPI;

import org.testng.annotations.Test;

import FakeUserAPI.FakeUser.address;
import FakeUserAPI.FakeUser.address.geolocation;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class FakeUserTest {
	
@Test
public void createFakeUserTest() {
	RestAssured.baseURI="https://fakestoreapi.com";

	
}

}
