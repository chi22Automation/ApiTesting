package com.test.tests;

import org.testng.annotations.Test;

import com.tests.simpleCRUDWithTechaechApp.DeleteUserDataTest;

public class TecharchApiTestScript 
{
	@Test(dependsOnGroups ="dependent method" )
 public void callAllTheTest()
 
 {    
		DeleteUserDataTest obj=new DeleteUserDataTest();
		obj.deleteUserwithPojo();
 }
}
