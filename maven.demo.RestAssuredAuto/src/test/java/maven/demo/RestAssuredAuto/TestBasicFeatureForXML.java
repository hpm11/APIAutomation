package maven.demo.RestAssuredAuto;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestBasicFeatureForXML {

	
	/**
	 * To Test xml response for single body content
	 */
	
	//@Test
	public void testSingleContent(){
		given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then().
			body("CUSTOMER.ID", equalTo("10")).
			log().all();
		
		
	}
	@Test
	public void testInXpath(){
		
		given().
			get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
		then().
			body(hasXPath("/INVOICEList/INVOICE[text()='40']")).log().all();
		
	}
}
