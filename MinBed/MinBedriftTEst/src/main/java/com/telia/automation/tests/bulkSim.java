package com.telia.automation.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Helper;
import Utils.TESTData;
import Utils.UtilPage;

import com.telia.automation.PageObject.bulkSimPageObj;

public class bulkSim {
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
    public void OrderBulkSimCard() throws InterruptedException {
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	// For Clicking Bulk Order Sim Card from Action Button
	WebElement OrderBulkSimCard = driver.findElement(By.cssSelector(".tsr-today-desc"));
	// waiting for the element to get load
	testUtil.waitForElementFluently(OrderBulkSimCard, 10);
	testUtil.setCssSelectorWithIndex(".tsr-today-desc", 0);
	// For getting the sim card number field
	WebElement simnumberField = bulkSimPageObj.getSimCardNumber();
	// setting the value in number of sim card
	testUtil.setTextValue(simnumberField, "2");
	// For getting the Name Of Recipient field
	WebElement recipientField = bulkSimPageObj.getNameOfRecipient();
	// setting the value in Recipient field
	testUtil.setTextValue(recipientField, testData.USERNAME);
	// For getting the Email field of Recipient
	WebElement recipientEmailField = bulkSimPageObj.getRecipientEmail();
	// Setting the value in email field
	testUtil.setTextValue(recipientEmailField, testData.EMAIL);
	// For getting the Phone Number field of Recipient
	WebElement recipientPhoneField = bulkSimPageObj.getrecipientPhone();
	// Setting the value in Phone Number Field
	testUtil.setTextValue(recipientPhoneField, testData.PhoneNumber);
	// For getting the Postal Code field
	WebElement PostnummerField = bulkSimPageObj.getPostnummer();
	// setting the value in postal number field
	testUtil.setTextValue(PostnummerField, testData.Postalnumber);
	String postalName = driver.findElement(By.cssSelector("#streetadr_city")).getText();
	// checking if postal Name is empty
	while (postalName == "") {
	    PostnummerField.clear();
	    testUtil.setTextValue(PostnummerField, testData.Postalnumber);
	}

	Thread.sleep(2000);
	// clicking on Submit Button
	WebElement submitButton = bulkSimPageObj.getSubmitButton();
	Thread.sleep(2000);
	submitButton.click();
	Thread.sleep(2000);
	// Checking for the pass Text to load
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	Assert.assertEquals("Mottatt!", str);

    }

    @After
    public void closeBrowser() {
	System.out.println("Closing Chrome browser");
	driver.quit();
    }

}