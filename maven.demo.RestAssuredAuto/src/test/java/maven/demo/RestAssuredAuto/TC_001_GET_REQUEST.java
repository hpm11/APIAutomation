package maven.demo.RestAssuredAuto;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_001_GET_REQUEST {
	
	// by SDET youtube
	@Test
	public void getWeatherDetails()
	{
		
		//Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response Object
		
		Response response = httprequest.request(Method.GET , "/Hyderabad");
		
		String respBody = response.getBody().asString();
		System.out.println("Response is ::" +respBody);
		
		//Validation of status code 
		
		int statCode = response.getStatusCode();
		System.out.println("Status Code :" +statCode);
		Assert.assertEquals(200, statCode);
		
		
		
		//verify status line
	String statLine = response.getStatusLine();
	System.err.println("Status Line is :" +statLine);
          
	}

}
