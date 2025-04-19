package GETAPIWithBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matcher.*;

import java.util.List;

public class ProductAPITest {
	
	@Test
	public void getProductTest() {
		RestAssured.baseURI= "https://fakestoreapi.com";
		Response response = given()
		.when()
		.get("/products");
		
		System.out.println(response.statusCode());
		System.out.println(response.asPrettyString());
		JsonPath js = response.jsonPath();
		List<Integer> ids = js.getList("id");
		System.out.println(ids);
		List<Integer> priceList = js.getList("price");
		System.out.println(priceList);
		
		List<Double> rateList = js.getList("rating.rate");
		System.out.println(rateList);
		for(int i=0;i<= ids.size();i++) {
			int id = ids.get(i);
			Object price = priceList.get(i);
			Object rate = rateList.get(i);
			System.out.println();

		}
		
	}
	
@Test
public void getProductCount() {
	RestAssured.baseURI= "https://fakestoreapi.com";
	given()
	.when()
	.get("/products")
	.then()
	.assertThat()
	.statusCode(200);
	//.and()
	//.body("$.size()", equalTo(20));
}

}
