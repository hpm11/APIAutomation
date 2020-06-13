package maven.demo.RestAssuredAuto;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.XmlConfig;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matcher;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.matcher.ResponseAwareMatcherComposer.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.mapper.ObjectMapperType;
import static io.restassured.path.json.JsonPath.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;



public class TestResources {
	
	//@Test
	public void testResource (){
		given().
		    get("http://jsonplaceholder.typicode.com/posts/3").
	    then().statusCode(200).log().all();
		
	}
		
		@Test
		public void CheckAllResponseData (){
			given().
			    get("http://jsonplaceholder.typicode.com/posts/3").
		    then().statusCode(200).log().all();
		
	}
	


// http://jsonplaceholder.typicode.com/posts/3

//https://jsonplaceholder.typicode.com/

//https://jsonplaceholder.typicode.com/posts

//https://jsonplaceholder.typicode.com/comments

//https://jsonplaceholder.typicode.com/photos

//https://jsonplaceholder.typicode.com/todos


}
