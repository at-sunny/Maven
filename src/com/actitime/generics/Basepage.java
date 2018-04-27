package com.actitime.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Basepage{
	
	public WebDriver driver;
	
	@FindBy(xpath = " //a[.='Logout']")
	private WebElement logoutBTN;
	
	@FindBy(xpath = "(//div[contains(text(),'Help')])[1]")
	private WebElement help;
	
	@FindBy(xpath = "//a[.='About your actiTIME']")
	private WebElement aboutActitime;
	
	@FindBy(xpath="//span[.='(build 40065)']")
	private WebElement buildNumber;
	
	public Basepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyTitle(String eTitle) { 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.titleContains(eTitle));
		Reporter.log("Title is matching "+ eTitle,true);
		}
		catch(Exception e) {
			Reporter.log("Title is not matching" , true);
			Reporter.log("Actual title is  " + driver.getTitle()+"Expected tiltle is "+ eTitle,true);
			Assert.fail();
		}
	}
	
	public void verifyElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element is present",true);
		}
		
		catch(Exception e) {
			Reporter.log("Element is not present",true);
			Assert.fail();
		}
	}
	
	public void clickonHelp() 
	{
	  verifyElement(help);	
	  help.click();	
	}
	
	public void clockOnAboutActitime()
	{
		verifyElement(aboutActitime);
		aboutActitime.click();
	}
	
	public String verifyBuildNumber()
	{
		verifyElement(buildNumber);
		String actualbuildNum = buildNumber.getText();
		return actualbuildNum;
	}
	
	public void clickonLogout()
	{
		logoutBTN.click();
	}


}
