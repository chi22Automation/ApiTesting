package com.tests.simpleCRUDWithTechaechApp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import com.test.helpers.UserServiceHelper;
import com.test.models.UpdateUserPojo;
import com.test.utils.Util;

import org.testng.annotations.Test;

import com.test.constants.Endpoints;
import com.test.helpers.ReusableMethods;

import com.tests.simpleCRUDWithTechaechApp.*;
public class UpdateUserDataTest 
{ UpdateUserPojo updatepojoObj;
String tokenfromMethod;
@Test(groups="dependent method" ,priority=3)
	public void updateUserWithPojo() 
	{ System.out.println("in update test" +UserServiceHelper.token);
	if(UserServiceHelper.token==null)
		tokenfromMethod=UserServiceHelper.getToken();
	//ReusableMethods.getResponse(tokenfromMethod, updatepojoObj);
	Header header1=new Header("token",UserServiceHelper.token);
	//GetUserTest.res.getBody().prettyPrint();
	 updatepojoObj=new UpdateUserPojo();
	 System.out.println("Beforeupdating"+GetUserTest.res.jsonPath().get("[0]"));
	 System.out.println(GetUserTest.res.jsonPath().get("[0].accountno"));
	 
	   
	String accNumForUpdate=GetUserTest.res.jsonPath().get("[0].accountno");
	System.out.println("account number is"+accNumForUpdate);
	updatepojoObj.setAccountno(accNumForUpdate);
	updatepojoObj.setDepartmentno("7");
	String salary=GetUserTest.res.jsonPath().get("[0].salary");
	updatepojoObj.setSalary(salary);
	String pincode=GetUserTest.res.jsonPath().get("[0].pincode");
	updatepojoObj.setPincode(pincode);
	String userid=GetUserTest.res.jsonPath().get("[0].userid");
	System.out.println(userid);
	updatepojoObj.setUserid(userid);
	
	String id=GetUserTest.res.jsonPath().get("[0].id");
	updatepojoObj.setId(id);
	System.out.println("id is"+id);
	System.out.println("accNumForUpdate"+accNumForUpdate);
	
	
	
	
   Response res=	RestAssured.given().header(header1).contentType(ContentType.JSON).body(updatepojoObj).when().
	put(Util.getApplicationProperty("baseurl")+Endpoints.UPDATE_DATA);
   
   
  
	System.out.println("status is="+res.jsonPath().get("status"));
	
	 System.out.println(updatepojoObj.getUserid());
	 GetUserTest.getUser();
	 System.out.println("after update="+GetUserTest.res.jsonPath().get("[0]"));
	}
	
	

}
