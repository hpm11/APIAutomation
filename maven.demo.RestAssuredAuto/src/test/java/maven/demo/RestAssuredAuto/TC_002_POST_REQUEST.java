package maven.demo.RestAssuredAuto;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_002_POST_REQUEST {


	@Test
	public void postRequest()
	{
		
		//Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		
		//Reuqest Payload sending along with Json
		
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("FirstName", "1Hitesh");
		requestparams.put("LastName", "1Moharle");
		requestparams.put("UserName", "1Hitu1234");
		requestparams.put("Password", "1123Hitu");
		requestparams.put("Email", "hhitesh@gmail.com");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestparams.toJSONString());
		
		
		//Response Object
		
		Response response = httprequest.request(Method.POST , "/register");
		
		//Print response in Console
		
		String respBody = response.getBody().asString();
		System.out.println("Response is ::" +respBody);
		
		//Validation of status code 
		
		int statCode = response.getStatusCode();
		System.out.println("Status Code :" +statCode);
		Assert.assertEquals(201, statCode);
		
		
		
		//verify status line
	String statLine = response.getStatusLine();
	System.err.println("Status Line is :" +statLine);
          
	}
	
	
}
