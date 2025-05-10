package XmlPathQuery;

import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class XmlPathTest {
	
@Test
public void MRDataXmlTest() {
	Response response =given().when()
	.get("https://ergast.com/api/f1/2017/circuits.xml");
	
	String responseBody = response.body().asString();
	XmlPath xmlpath = new XmlPath(responseBody);
	List<String> circuitNames =xmlpath.getList("MRData.CircuitTable.Circuit.CircuitName");
	System.out.println("size is "+circuitNames.size());
	for(String e :circuitNames) {
		System.out.println("circuit names are "+e);
	}
	// fetch locality where circuiteId = "americas"
	
	String locality = xmlpath.getString("**.find{it.@circuitId =='americas'}.Location.Locality");
	System.out.println("Locality is"+locality);
	
	String country = xmlpath.getString("**.find{it.@circuitId =='americas'}.Location.Country");
	System.out.println("Locality is"+country);
	
	List<String> localities = xmlpath.getList("**.findAll{it.@circuitId =='americas'}.Location.Locality");
	System.out.println("Locality is"+localities);
	
	List<String> countries = xmlpath.getList("**.findAll{it.@circuitId =='americas'}.Location.Country");
	System.out.println("Locality is"+countries);
	
	System.out.println("--------------------");
	
	//fetch Locality where circuit id = "americas" or circuitId ="bahrain" -->Austin,sakhir
	
	List<String> multiplecountries = xmlpath.getList("**.findAll{it.@circuitId =='americas' || it.@circuitId =='bahrain'}.Location.Country");
	System.out.println("Multiple countries are"+multiplecountries);
	
}

}
