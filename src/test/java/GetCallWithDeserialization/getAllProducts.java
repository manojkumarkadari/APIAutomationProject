package GetCallWithDeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.response.*;


public class getAllProducts {
	
@Test
public void getProducts() {
	
	RestAssured.baseURI="https://fakestoreapi.com";
	Response response = given()
	.when()
	.get("products");
	response.prettyPrint();
	
	//Deserialization :json to pojo
	ObjectMapper Mapper = new ObjectMapper();
	try {
		Product[] product =Mapper.readValue(response.getBody().asString(), Product[].class);
		for(Product p:product) {
			System.out.println(" id is " +p.getId());
			System.out.println(" Title is " +p.getTitle());
			System.out.println(" price is " +p.getPrice());
			System.out.println(" description is " +p.getDescription());
			System.out.println(" category is " +p.getCategory());
			System.out.println(" image is " +p.getImage());
			System.out.println("rating is "+p.getRating().getRate());
			System.out.println("Rating count is"+p.getRating().getCount());
		}
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}