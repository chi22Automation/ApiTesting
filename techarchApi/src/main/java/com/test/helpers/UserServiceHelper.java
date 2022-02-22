package com.test.helpers;

import com.test.constants.Endpoints;
import com.test.models.LoginObjectsPOJO;
import com.test.utils.Util;
import static io.restassured.RestAssured.*;
import   io.restassured.response.Response;

public  class UserServiceHelper 
{
	public static  Response response;
	public static String token;
	public static String getBaseUri() 
	{
		String baseURI=Util.getApplicationProperty("baseurl");
		return baseURI;
		
	}
	public static Response LoginToApplication()
	{
		
		String username=Util.getApplicationProperty("username");
		String password=Util.getApplicationProperty("password");
		LoginObjectsPOJO loginob=new LoginObjectsPOJO(username,password);
		System.out.println("{\"username\":\"chitraemail22@ta.com\",\"password\":\"chitra@123\"}");
		System.out.println("uri is"+getBaseUri()+Endpoints.LOGIN);
		response=given().contentType("application/json")
				//.body(loginob).when().post(Util.getApplicationProperty("baseurl")+Endpoints.LOGIN);
				
				
				.body("{\"username\":\"chitraemail22@ta.com\",\"password\":\"chitra@123\"}").when().post(getBaseUri()+Endpoints.LOGIN);
		System.out.println("LoginToApplication method is called");
		return response;
	}
	public static String getToken()
	{
		response=LoginToApplication();
		token=response.jsonPath().get("[0].token");
		System.out.println("Get Token Method is called");
		return token;
	}

}
