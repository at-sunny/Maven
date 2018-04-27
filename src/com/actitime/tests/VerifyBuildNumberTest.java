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
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNumberTest extends BaseTest {

	@Test
	public void testVerifyBuild() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "login", 1, 2);
		String user = ExcelData.getData(file_path,"login",1, 0);
		String pass = ExcelData.getData(file_path, "login",1, 1);
		String entertimetrackTitle = ExcelData.getData(file_path, "entertimetract", 1, 0);
		String ebuildNumber = ExcelData.getData(file_path, "entertimetrack", 1, 1);
		
		Reporter.log(ebuildNumber,true);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		lp.verifyTheTitle(title);
		
		lp.setUN(user);
		
		lp.setPW(pass);
		
		lp.clickLogin();
		
		ep.verifyTitle(entertimetrackTitle);
		
		Thread.sleep(2000);
		
		ep.clickonHelp();
		
		Thread.sleep(2000);
		
		ep.clockOnAboutActitime();
				
		Thread.sleep(2000);
		
		String aBuildNum = ep.verifyBuildNumber();
		Reporter.log(aBuildNum,true);
		Reporter.log(ebuildNumber,true);
				
		AssertJUnit.assertEquals(aBuildNum, ebuildNumber);
		
		Reporter.log("bulidnum is matching Actual Build number is "+aBuildNum+ " Expected B uild number is "+ ebuildNumber,true);
		
	}
}
