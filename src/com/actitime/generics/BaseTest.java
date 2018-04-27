package com.actitime.generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConstant {

	public WebDriver driver;
	
	@Parameters({"nodeurl","browser","appurl"})
	@BeforeMethod
	public void preCondition(String nodeurl,String browser,String appurl) throws MalformedURLException {
//		System.setProperty(chrome_key,chrome_value);
//		System.setProperty(gecko_key, gecko_value);
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    driver.get("http://localhost/login.do");
		
		URL url = new URL(nodeurl);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver = new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appurl);
	}
	
	
	@AfterMethod
	public void postCondition(ITestResult res) {
		int status = res.getStatus();
		String name = res.getMethod().getMethodName();
		if(status == 2)
		{
			GenericUtils.getScreenshot(driver,name);
		}
		
		driver.close();
	}
	
}
