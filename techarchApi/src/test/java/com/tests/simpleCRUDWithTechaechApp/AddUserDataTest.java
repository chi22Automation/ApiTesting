package com.tests.simpleCRUDWithTechaechApp;

import com.test.models.AddUserPojo;
import com.test.utils.Util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;
//import pojos.AddUserPojo;
  

public class AddUserDataTest {
    AddUserPojo addpojObj;
    @Test(groups="dependent method" ,priority=2)
	public void createuserWithPojo()
{  System.out.println(UserServiceHelper.token);
		if(UserServiceHelper.token==null)
			UserServiceHelper.getToken();
		 addpojObj=new AddUserPojo();
		 addpojObj.setAccountno("TA-2222009");
		 addpojObj.setDepartmentno("9");
		 addpojObj.setSalary("345");
		 addpojObj.setPincode("456789");
System.out.println(Util.getApplicationProperty("baseurl")+Endpoints.ADD_DATA);
		Header header1=new Header("token",UserServiceHelper.token);
	   Response res=	 RestAssured.given().header(header1).contentType(ContentType.JSON)
		 .body(addpojObj)
		 
		 .when().post(Util.getApplicationProperty("baseurl")+Endpoints.ADD_DATA);
	 System.out.println(addpojObj);
	//System.out.println(deprtNumber);
	System.out.println();
		   System.out.println("status is="+res.jsonPath().get("status"));
		  
		
	}
}
