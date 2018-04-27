package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.Basepage;

public class EnterTimeTrackPage extends Basepage {
	
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement task;	
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTheTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public void clickOnTask()
	{
		task.click();
	}
	
	
}
