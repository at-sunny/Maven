package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.Basepage;

public class TaskList extends Basepage {

    //declaration
	
 	@FindBy(xpath= "//div[@class='statusFilterButton']")
	private WebElement taskStatus;
	
	@FindBy(xpath = "//div[.='Completed tasks']")
	private WebElement completedTasks;
	
	@FindBy(xpath = "//div[.='Completed']")
	private WebElement statusText;
	
	
	//initialization
	
	public TaskList(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//implementation
	
    public void verifyTheTitle(String eTitle)
    {
    	verifyTitle(eTitle);
    }
	
	public void clickStatusFilter()
	{
		taskStatus.click();
	}
	
	public void clickCompletedTask()
	{
		completedTasks.click();
	}
	
	public String verifyStatusText()
	{
		verifyElement(statusText);
		String astatusText = statusText.getText();
		return astatusText;
	}
	
}
