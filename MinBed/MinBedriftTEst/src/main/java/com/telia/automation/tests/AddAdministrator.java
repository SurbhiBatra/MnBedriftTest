package com.telia.automation.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telia.automation.PageObject.AddAdministratorPageObj;
import com.telia.automation.PageObject.bulkSimPageObj;

import Utils.Helper;
import Utils.TESTData;
import Utils.UtilPage;

public class AddAdministrator {
	 public static WebDriver driver;
	    Map<String, String> dataMap;
	    UtilPage testUtil = null;
	    TESTData testData = null;

 @Before
 public  void openBrowser() throws MalformedURLException {
	dataMap = Helper.intializeTestData();
	String OS = Helper.getProperty("OS");
	driver = Helper.setLocalChromeDriverPath(OS);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get(dataMap.get("URL"));
	// Set drive for test util class
	testUtil = new UtilPage(driver);
	testData = new TESTData(driver);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
}

    
 
 
    
    @Test
    public void AddAdminstrator() throws InterruptedException {
	AddAdministratorPageObj administratorPageObj = PageFactory.initElements(driver, AddAdministratorPageObj.class);
	WebElement AddSubs = driver.findElement(By.cssSelector(".tsr-today-desc"));
	testUtil.waitForElementFluently(AddSubs, 20);
	testUtil.setCssSelectorWithIndex(".tsr-today-desc", 4);
	testUtil.setCssSelector(".tsr-today-link");
	WebElement telephonenummer = administratorPageObj.getPhoneNummerField();
	// setting the value in phone number field
	testUtil.setTextValue(telephonenummer, "90000005");
	administratorPageObj.getRole();
	administratorPageObj.selectRole();
	administratorPageObj.clickSaveButton();
	
	Thread.sleep(2000);
	boolean check =administratorPageObj.checkAdmin();
	if(check)
	{
	    assertTrue(true);
	  	} else {
	  	    assertTrue(false);
	  	}
}}
