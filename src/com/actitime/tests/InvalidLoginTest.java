package com.actitime.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.LoginPage;


public class InvalidLoginTest extends BaseTest {

	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		String loginTitle = ExcelData.getData(file_path, "login", 1, 2);
		String ErrorMessage = ExcelData.getData(file_path, "login", 1, 4);
		int loginRC = ExcelData.getRowCount(file_path, "login");
		
		LoginPage lp = new LoginPage(driver);
		
		//verify loginpage
		lp.verifyTheTitle(loginTitle);
		
		Reporter.log("---------",true);
		
		for(int i = 2;i<=loginRC;i++)
		{
			String user = ExcelData.getData(file_path, "login", i, 0);
			String pass = ExcelData.getData(file_path, "title", i, 1);
			//enter the invalid username
			lp.setUN(user);
			
			//enter the invalid password
			lp.setPW(pass);
			
			//click on login
			lp.clickLogin();
			
			Thread.sleep(2000);
			
			//verify error message
			String aerrorMSG = lp.verifyErrorMessage();
			AssertJUnit.assertEquals(aerrorMSG,ErrorMessage );
			Reporter.log("message is matching"+ ErrorMessage,true);
			
			Reporter.log("-------------",true);
			
			
		}
		

	}
	
}
