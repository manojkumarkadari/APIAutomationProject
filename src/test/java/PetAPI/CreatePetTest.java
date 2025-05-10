package PetAPI;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PetAPI.Pet.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreatePetTest {
	
	@Test
	public void createPetTest() throws JsonMappingException {
		RestAssured.baseURI= "https://petstore3.swagger.io";
		
		Pet.Category category = new Pet.Category(1, "name");  //Inner class of Pet
		
		List<String> photourls = Arrays.asList("https://ex.com","https://dog.com");
		
		Pet.Tag tag1 = new Pet.Tag(1, "Red");
		Pet.Tag tag2 = new Pet.Tag(2, "Blaks");
		List<Tag> tags = Arrays.asList(tag1,tag2);
		
		Pet pet = new Pet(1,"manoj","available",category,photourls,tags);
		
		Response response=given().log().all()
		.contentType(ContentType.JSON)
		.body(pet)
		.when().log().all()
		.post("/api/v3/pet");
		
		System.out.println(response.asPrettyString());
		
		//De-serialization
		//json to pojo
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			Pet petres = objectMapper.readValue(response.getBody().asString(), Pet.class);
			System.out.println(petres.getName());
			System.out.println(petres.getId());
			System.out.println(petres.getStatus());
			System.out.println(petres.getCategory().getName());
			System.out.println(petres.getCategory().getId());
			System.out.println(petres.getPhotoUrls());
			System.out.println(petres.getTags().get(1));			
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
