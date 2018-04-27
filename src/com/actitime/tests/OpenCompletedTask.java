package com.actitime.tests;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TaskList;

public class OpenCompletedTask extends BaseTest {

	@Test
	public void testOpenCompletedTaskTest() throws InterruptedException
	{
		String loginTitle = ExcelData.getData(file_path, "login", 1, 2);
		String username = ExcelData.getData(file_path, "login", 1, 0);
		String password = ExcelData.getData(file_path, "login", 1, 1);
		String enterTimeTrackTitle = ExcelData.getData(file_path, "entertimetrack", 1, 0);
		String taskListTitle = ExcelData.getData(file_path, "tasklist", 1,0);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		TaskList tl = new TaskList(driver);
		
		//verify the login page
		lp.verifyTheTitle(loginTitle);
		
		//enter the Username
		lp.setUN(username);
		
		//enter the password
		lp.setPW(password);
		
		//click on login
		lp.clickLogin();
		
		Thread.sleep(2000);
		//verify the enterTimeTrackTitle
		ep.verifyTheTitle(enterTimeTrackTitle);
		
		Thread.sleep(2000);
		//click on task menu
		ep.clickOnTask();
		
		Thread.sleep(2000);
		//verify the tasklist title
		tl.verifyTheTitle(taskListTitle);
		
		Thread.sleep(2000);
		//click on status filter
		tl.clickStatusFilter();
		
		Thread.sleep(2000);
		//select completed task
		tl.clickCompletedTask();
		
		Thread.sleep(2000);
		//verify the completed task
		tl.verifyStatusText();
		
		
		
	}
}
