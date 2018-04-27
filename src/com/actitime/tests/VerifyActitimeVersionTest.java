package com.actitime.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyActitimeVersionTest extends BaseTest  {
	@Test
	public void testVerifyVersion()
	{
		String eVersion = ExcelData.getData(file_path, "login", 1, 3);
		String title = ExcelData.getData(file_path, "login", 1 ,2);
		
		LoginPage lp = new LoginPage(driver);
		
		//verify the title
		lp.verifyTheTitle(title);
		
		//verify the version
		String aVersion = lp.verifyVersion();
		AssertJUnit.assertEquals(aVersion, eVersion);
		Reporter.log("version is matching : Actual version is "+ aVersion+" Expected version is "+ eVersion,true);
		
	}

}
