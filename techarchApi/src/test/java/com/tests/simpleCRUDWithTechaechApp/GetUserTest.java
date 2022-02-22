package com.tests.simpleCRUDWithTechaechApp;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import com.test.utils.Util;
public  class GetUserTest {
	public static Response res;
	@Test(groups="dependent method" ,priority=2)
	public static void getUser()
	{
		if(UserServiceHelper.token==null)
			UserServiceHelper.getToken();
		System.out.println("in getUserTest");
		Header header1=new Header("token",UserServiceHelper.token);
	    res=	RestAssured.given().header(header1)
		.when().get(Util.getApplicationProperty("baseurl")+Endpoints.GET_DATA);
//	    res.then().body(matchesJsonSchemaInClasspath("getUserDataalidation.json"));
//	     String accNum= res.jsonPath().get("[0].accountno");
	    String userid1= res.jsonPath().get("[0].userid");
//	     System.out.println("user id is="+userid1);
	    
   String id1= res.jsonPath().get("[0].id");
    System.out.println(" id is="+id1);
    System.out.println(userid1);
//	     System.out.println("total number of record"+ res.jsonPath().get("body.size()"));
//	      System.out.println("firs set of Acc number is"+ accNum);
		
	}

}
