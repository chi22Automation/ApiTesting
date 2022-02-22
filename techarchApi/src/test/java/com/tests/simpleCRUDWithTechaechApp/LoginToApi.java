package com.tests.simpleCRUDWithTechaechApp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import com.test.helpers.UserServiceHelper;
public class LoginToApi   {
	@Test
	public void loginTest()
	{ 
		//UserServiceHelper.LoginToApplication();	
		System.out.println(UserServiceHelper.getToken());
		
	
	}
}
