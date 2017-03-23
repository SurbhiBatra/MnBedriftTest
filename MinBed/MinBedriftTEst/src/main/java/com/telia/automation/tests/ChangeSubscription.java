package com.telia.automation.tests;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Helper;
import Utils.TESTData;
import Utils.UtilPage;

import com.telia.automation.PageObject.bulkSimPageObj;

public class ChangeSubscription {
    public static WebDriver driver;
    Map<String, String> dataMap;
    UtilPage testUtil = null;
    TESTData testData = null;

    @Before
    public void openBrowser() throws MalformedURLException {
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
    public void ChangeSubscription() throws InterruptedException {
	
	driver.get("http://minbedrift-demo.telia.no/area/demo/MM00331AC4PACEQB/#/overview/999999999/10000002/47/90000046");
	testUtil.setCssSelectorWithIndex(".tsr-today-link", 0);
	testUtil.setCssSelector(".ts-icon-arrow-right.chevron-right");
	testUtil.setCssSelector(".chevron-top.slideToggle-switch.ts-icon-arrow-down.closed");
	testUtil.setCssSelector("span.checkbox");
	testUtil.setCssSelector(".ts-icon-arrow-right.chevron-right");	
	testUtil.setCssSelector(".ts-icon-arrow-right.chevron-right");
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	// Assertion
	Assert.assertEquals("Mottatt!", str);
    }
    
    
}