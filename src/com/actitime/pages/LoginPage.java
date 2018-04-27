package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseTest;
import com.actitime.generics.Basepage;

public class LoginPage extends Basepage {

	//Declaration
	@FindBy(id = "username")
	private WebElement usernameTB;
	
	@FindBy(name = "pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath = "//nobr[contains(.,'actiTIME')]")
	private WebElement version;
	
	@FindBy(xpath = "//span[contains(.,'invalid')]")
	private WebElement errMSG;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void setUN(String un)
	{
		usernameTB.sendKeys(un);
	}
	
	public void setPW(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	
	public void clickLogin()
	{
		loginBTN.click();
	}
	
	public void verifyTheTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public String verifyErrorMessage()
	{
		verifyElement(errMSG);
		String actualerrMSG = errMSG.getText();
		return actualerrMSG;
	}
	
	public String verifyVersion()
	{
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
	}
	
	
	

}

