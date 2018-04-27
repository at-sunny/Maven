package com.actitime.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest{

	@Test
	public void testvalidLoginLogout() throws InterruptedException
	{
		String loginTitle = ExcelData.getData(file_path, "login", 1, 2);
		String username = ExcelData.getData(file_path, "login", 1, 0);
		String password = ExcelData.getData(file_path,"login", 1, 1);
		String timeTrackTitle = ExcelData.getData(file_path, "entertimetrack",1, 0);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		//verify the login page
		lp.verifyTheTitle(loginTitle);
		
		//enter valid username
		Reporter.log("username is :"+ username,true);
		lp.setUN(username);
		
		//enter valid password
		Reporter.log("password is :"+password,true);
		lp.setPW(password);
		
		//click on login
		lp.clickLogin();
		
		//verify the enter time track page
		Reporter.log(timeTrackTitle,true);
		lp.verifyTheTitle(timeTrackTitle);
		
		
		Thread.sleep(2000);
		//click on logout
		ep.clickonLogout();
		
		// verify the login page
		ep.verifyTheTitle(loginTitle);
	}
}
