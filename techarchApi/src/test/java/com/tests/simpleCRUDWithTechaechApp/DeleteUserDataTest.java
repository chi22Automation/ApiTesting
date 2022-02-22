package com.tests.simpleCRUDWithTechaechApp;

import org.testng.annotations.Test;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;
import com.test.models.DeleteUser;
import com.test.utils.Util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class DeleteUserDataTest 
{DeleteUser deleuser;
	@Test(dependsOnGroups ="dependent method" ) 
	public void deleteUserwithPojo()
	{ deleuser=new DeleteUser();
		System.out.println(UserServiceHelper.token);
		if(UserServiceHelper.token==null)
			UserServiceHelper.getToken();
		System.out.println("before deleting"+GetUserTest.res.jsonPath().get("[0]"));;
		Header header1=new Header("token",UserServiceHelper.token);
	//updatepojoObj.setUserid(userid1);
	//updatepojoObj.setId(id1);
		String userid1=GetUserTest.res.jsonPath().get("[0].userid");
		System.out.println(userid1);
		deleuser.setUserid(userid1);
		String id1=GetUserTest.res.jsonPath().get("[0].id");
		System.out.println(id1);
		deleuser.setId(id1);
		System.out.println(Util.getApplicationProperty("baseurl")+Endpoints.DELETE_DATA);
	String useidNid="{\"id\":\""+id1+"\",\"userid\":\""+userid1+"\"}";
	 Response res=	RestAssured.given().header(header1).contentType(ContentType.JSON).body(deleuser).when().
			 delete(Util.getApplicationProperty("baseurl")+Endpoints.DELETE_DATA);
	 
	 System.out.println("status is="+res.jsonPath().get("status"));
	 GetUserTest.getUser();
	 System.out.println("after delete"+GetUserTest.res.jsonPath().get("[0]"));;
	 //System.out.println(updatepojoObj.getUserid());
	}

}
