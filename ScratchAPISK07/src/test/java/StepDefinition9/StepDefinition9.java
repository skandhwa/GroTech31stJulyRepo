package StepDefinition9;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import TestData.POJOImplementation;
import TestData.TestDataExcel;
import Utilities.FetchDataFromProperty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition9 {
	
	
	String base_URI=FetchDataFromProperty.readDataFromProperty().getProperty("base_uri");
	String base_URI_gorest=FetchDataFromProperty.readDataFromProperty().getProperty("base_uri_gorest");
	String auth_token;
	RequestSpecification req,res;
	ResponseSpecification respec;
	Response response;
	
	
	
	@Given("user opens the application")
	public void user_opens_the_application() {
		req=new RequestSpecBuilder().setBaseUri(base_URI).setContentType(ContentType.JSON)
				.build();
	}
	
	@When("user enters the payload")
	public void user_enters_the_payload() throws JsonProcessingException {
		
		res=given().log().all().headers("x-api-key","reqres-free-v1")
				.relaxedHTTPSValidation().spec(req)
				.body(POJOImplementation.createUserData());

		System.out.println("Hello");
		
		
	    
	}


@When("user submits a new request with an {string}")
public void user_submits_a_new_request_with_an(String endpoint) {
	
	respec=new ResponseSpecBuilder().build();
	
	response=	res.when().post(endpoint).then().log().all().extract().response();

	System.out.println("Hi");

	Syste,out.println("Hello");
    
}

@Given("user hit the gorest site with URI")
public void user_hit_the_gorest_site_with_uri() {
	
	req=new RequestSpecBuilder().setBaseUri(base_URI_gorest).setContentType(ContentType.JSON)
			.build();
	
	
    
}

@Given("user enters the authentication token")
public void user_enters_the_authentication_token() {
	
	auth_token=FetchDataFromProperty.readDataFromProperty().getProperty("AuthToken");
	
	
    
}

@Given("user passes the payload for request")
public void user_passes_the_payload_for_request() throws IOException {
	
	res=given().log().all().headers("Authorization",auth_token)
			.relaxedHTTPSValidation().spec(req)
			.body(TestDataExcel.getDataFromExcel());
	
	
	
	
	
   
}

@When("user will submit the gorest site with {string}")
public void user_will_submit_the_gorest_site_with(String endpoint) {
	
	
respec=new ResponseSpecBuilder().build();
	
	response=	res.when().post(endpoint).then().log().all().extract().response();
	
   
}


@Then("validate the payload in response body")
public void validate_the_payload_in_response_body() throws IOException {
	
	JsonPath js=new JsonPath(response.asString());
	String name=js.getString("name");
	String gender=js.getString("gender");
	String expected_name=TestDataExcel.getDataFromExcel().get("name").toString();
	String expected_gender=TestDataExcel.getDataFromExcel().get("gender").toString();
	Assert.assertEquals(name, expected_name);
	Assert.assertEquals(gender, expected_gender);
	
	
	
	
	
	
	
	
    
}









		
		
	    
	

	@Then("validate that user is created and status code is {string}")
	public void validate_that_user_is_created_and_status_code_is(String status_code) {
	   
	long time=	response.getTime();
	if(time>5000)
	{
	  Assert.assertTrue(false);
	}
	
	else
	{
		System.out.println("Test case passed ");
	}
	
int actualStatusCode=	response.getStatusCode();
String s=status_code;
int expectedStatusCode=Integer.parseInt(s);
Assert.assertEquals(actualStatusCode, expectedStatusCode);
	
		
		
		
	}

	

}
