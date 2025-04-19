package POSTAPITESTS;

import org.testng.annotations.Test;
import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class POSTAPIWithDifferentBody {
	
	@Test
	public void bodyWithTexttest() {
		RestAssured.baseURI ="https://postman-echo.com";
		String payload ="this is manoj";
		given()
		.contentType(ContentType.TEXT)
		.body(payload)
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}
	
	@Test
	public void bodyWithJscripttest() {
		RestAssured.baseURI ="https://postman-echo.com";
		String payload ="<script>\r\n"
				+ "function myFunction() {\r\n"
				+ "  document.getElementById(\"demo\").innerHTML = \"Paragraph changed.\";\r\n"
				+ "}\r\n"
				+ "</script>";
		given()
		.contentType("application/javascript;charset=utf-8")
		.body(payload)
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}
	
	@Test
	public void bodyWithHtmlTest() {
		RestAssured.baseURI ="https://postman-echo.com";
		String payload ="<html>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h2>Demo JavaScript in Body</h2>\r\n"
				+ "\r\n"
				+ "<p id=\"demo\">A Paragraph.</p>\r\n"
				+ "\r\n"
				+ "<button type=\"button\" onclick=\"myFunction()\">Try it</button>\r\n"
				+ "\r\n"
				+ "<script>\r\n"
				+ "function myFunction() {\r\n"
				+ "  document.getElementById(\"demo\").innerHTML = \"Paragraph changed.\";\r\n"
				+ "}\r\n"
				+ "</script>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html> ";
		given()
		.contentType(ContentType.HTML)
		.body(payload)
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}
	
	@Test
	public void bodyWithXmlTest() {
		RestAssured.baseURI ="https://postman-echo.com";
		String payload ="<dependency>\r\n"
				+ "    <groupId>io.rest-assured</groupId>\r\n"
				+ "    <artifactId>rest-assured</artifactId>\r\n"
				+ "    <version>5.5.1</version>\r\n"
				+ "    <scope>test</scope>\r\n"
				+ "</dependency> ";
		given()
		.contentType("application/xml;charset=utf-8")
		.body(payload)
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}
	
	@Test
	public void bodyWithMultiPart() {
		RestAssured.baseURI ="https://postman-echo.com";
		given()
		.contentType(ContentType.MULTIPART)
		.multiPart("resume","filepath")
		.multiPart("name","naveen")
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}
	@Test
	public void bodyWithPDFFiletest() {
		RestAssured.baseURI ="https://postman-echo.com";
		given()
		.contentType("application/pdf")
		.body(new File ("filepath"))
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}
	
	@Test
	public void bodyWithImagetest() {
		RestAssured.baseURI ="https://postman-echo.com";
		given()
		.contentType("application/pdf")
		.body(new File ("filepath"))
		.when()
		.post("/post")
		.then().log().all()
		.assertThat().statusCode(200);
		
	}

}
