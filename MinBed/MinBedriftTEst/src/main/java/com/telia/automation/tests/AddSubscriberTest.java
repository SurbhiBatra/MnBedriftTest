package com.telia.automation.tests;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telia.automation.PageObject.bulkSimPageObj;

import Utils.Helper;
import Utils.TESTData;
import Utils.UtilPage;

public class AddSubscriberTest {
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
    public void AddMobileSubscriber() throws InterruptedException {
	driver.get("http://minbedrift-demo.telia.no/area/demo/MM00331AC4PACEQB/#/overview/999999999");
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	Thread.sleep(2000);
	// Clicking on LEGG TIL ABONNENT
	WebElement AddSubs = driver.findElement(By.cssSelector(".tsr-today-desc"));
	testUtil.waitForElementFluently(AddSubs, 20);
	testUtil.setCssSelectorWithIndex(".tsr-today-desc", 1);
	Thread.sleep(1000);
	// Clicking on 1 step Submit Button
	bulkSimPageObj.ClickSubmitButton();
	// Click on Fakturasteder
	bulkSimPageObj.ClickButton();
	// Choosing an Invoice Location
	bulkSimPageObj.ClickSubmitButton();
	// Choosing a Price Plan
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Additional Services page Submit button
	Thread.sleep(2000);
	bulkSimPageObj.ClickSubmitButton();
	Thread.sleep(2000);
	// Getting First Name field
	WebElement FirstNameField = bulkSimPageObj.getFirstName();
	// Setting the value in First Name Field
	testUtil.setTextValue(FirstNameField, testData.USERNAME);
	// Getting Last Name field
	WebElement LastNameField = bulkSimPageObj.getLastName();
	// Setting the value in Last Name Field
	testUtil.setTextValue(LastNameField, testData.LASTNAME);
	// Getting Post Nummer field
	WebElement PostNummerField = bulkSimPageObj.getPostNummer();
	// Setting the value in postNummer field
	testUtil.setTextValue(PostNummerField, testData.Postalnumber);
	String postalName = driver.findElement(By.cssSelector("#streetadr_city")).getText();
	// Checking if PostName is Empty
	while (postalName == "") {
	    PostNummerField.clear();
	    testUtil.setTextValue(PostNummerField, testData.Postalnumber);
	}
	Thread.sleep(2000);
	// Clicking on submit button after Filling data
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Radio Button for Sim Card
	testUtil.setCssSelectorWithClick(".medium-4.columns.end .radio");
	// Getting First Name field
	WebElement FirstName = bulkSimPageObj.getFirstNamee();
	// Setting the value in First Name Field
	testUtil.setTextValue(FirstName, testData.USERNAME);
	// Getting Last Name field
	WebElement LastName = bulkSimPageObj.getLastNamee();
	// Setting the value in Last Name Field
	testUtil.setTextValue(LastName, testData.LASTNAME);
	// Getting Company Name field
	WebElement CompanyName = bulkSimPageObj.getCompanyName();
	// Setting Org Name
	testUtil.setTextValue(CompanyName, testData.OrgName);
	// clicking on Submit Button
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Submit Button for Receipent Page
	bulkSimPageObj.ClickSubmitButton();
	// checking for the Mottatt Text to come on the Recipt page
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	// Assertion
	Assert.assertEquals("Mottatt!", str);

    }

    @Test
    public void AddMobileBroadbandSubscriber() throws InterruptedException {
	driver.get("http://minbedrift-demo.telia.no/area/demo/MM00331AC4PACEQB/#/overview/999999999");
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	Thread.sleep(2000);
	// Clicking on Order Mobile BroadBand
	WebElement AddSubs = driver.findElement(By.cssSelector(".tsr-today-desc"));
	testUtil.waitForElementFluently(AddSubs, 20);
	testUtil.setCssSelectorWithIndex(".tsr-today-desc", 3);
	Thread.sleep(2000);
	// Clicking on 1 step Submit Button
	bulkSimPageObj.ClickButton();
	// Click on Fakturasteder
	// bulkSimPageObj.ClickSubmitButton();
	// Choosing an Invoice Location
	bulkSimPageObj.ClickSubmitButton();
	// Choosing a Price Plan
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Additional Services page Submit button
	bulkSimPageObj.ClickSubmitButton();
	Thread.sleep(2000);
	// Getting First Name field
	WebElement FirstNameField = bulkSimPageObj.getFirstName();
	// Setting the value in First Name Field
	testUtil.setTextValue(FirstNameField, testData.USERNAME);
	// Getting Last Name field
	WebElement LastNameField = bulkSimPageObj.getLastName();
	// Setting the value in Last Name Field
	testUtil.setTextValue(LastNameField, testData.LASTNAME);
	// Getting Post Nummer field
	WebElement PostNummerField = bulkSimPageObj.getPostNummer();
	// Setting the value in postNummer field
	testUtil.setTextValue(PostNummerField, testData.Postalnumber);
	String postalName = driver.findElement(By.cssSelector("#streetadr_city")).getText();
	// Checking if PostName is Empty
	while (postalName == "") {
	    PostNummerField.clear();
	    testUtil.setTextValue(PostNummerField, testData.Postalnumber);
	}
	Thread.sleep(2000);
	// Clicking on submit button after Filling data
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Radio Button for Sim Card
	testUtil.setCssSelectorWithClick(".medium-4.columns.end .radio");
	// Getting First Name field
	WebElement FirstName = bulkSimPageObj.getFirstNamee();
	// Setting the value in First Name Field
	testUtil.setTextValue(FirstName, testData.USERNAME);
	// Getting Last Name field
	WebElement LastName = bulkSimPageObj.getLastNamee();
	// Setting the value in Last Name Field
	testUtil.setTextValue(LastName, testData.LASTNAME);
	// Getting Company Name field
	WebElement CompanyName = bulkSimPageObj.getCompanyName();
	// Setting Org Name
	testUtil.setTextValue(CompanyName, testData.OrgName);
	// clicking on Submit Button
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Submit Button for Receipent Page
	bulkSimPageObj.ClickSubmitButton();
	// checking for the Mottatt Text to come on the Recipt page
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	// Assertion
	Assert.assertEquals("Mottatt!", str);

    }

    @Test
    public void AddM2M() throws InterruptedException {
	driver.get("http://minbedrift-demo.telia.no/area/demo/MM00331AC4PACEQB/#/overview/999999999");
	//driver.get("https://minbedrift-at.telia.no/#/overview/920144950");
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	Thread.sleep(4000);
	// Clicking on Order Mobile BroadBand
	WebElement AddSubs = driver.findElement(By.cssSelector(".tsr-today-desc"));
	testUtil.waitForElementFluently(AddSubs, 20);
	testUtil.setCssSelectorWithIndex(".tsr-today-desc", 5);
	Thread.sleep(2000);
	// Clicking on 1 step Submit Button
	bulkSimPageObj.ClickButton();
	// Click on Fakturasteder
	// bulkSimPageObj.ClickSubmitButton();
	// Choosing an Invoice Location
	Thread.sleep(2000);
	bulkSimPageObj.ClickSubmitButton();
	// Choosing a Price Plan
	bulkSimPageObj.ClickSubmitButton();
	Thread.sleep(2000);
	// Clicking on Additional Services page Submit button
	bulkSimPageObj.ClickSubmitButton();
	// Getting Last Name field
	WebElement LastNameField = bulkSimPageObj.getLastName();
	// Setting the value in Last Name Field
	testUtil.setTextValue(LastNameField, testData.LASTNAME);
	// Getting Post Nummer field
	WebElement PostNummerField = bulkSimPageObj.getPostNummer();
	// Setting the value in postNummer field
	testUtil.setTextValue(PostNummerField, testData.Postalnumber);
	String postalName = driver.findElement(By.cssSelector("#streetadr_city")).getText();
	// Checking if PostName is Empty
	while (postalName == "") {
	    PostNummerField.clear();
	    testUtil.setTextValue(PostNummerField, testData.Postalnumber);
	}
	Thread.sleep(2000);
	// Clicking on submit button after Filling data
	bulkSimPageObj.ClickSubmitButton();
	// Clicking on Radio Button for Sim Card
	testUtil.setCssSelectorWithClick(".medium-4.columns.end .radio");
	// Getting First Name field
	WebElement FirstName = bulkSimPageObj.getFirstNamee();
	// Setting the value in First Name Field
	testUtil.setTextValue(FirstName, testData.USERNAME);
	// Getting Last Name field
	WebElement LastName = bulkSimPageObj.getLastNamee();
	// Setting the value in Last Name Field
	testUtil.setTextValue(LastName, testData.LASTNAME);
	// Getting Company Name field
	WebElement CompanyName = bulkSimPageObj.getCompanyName();
	// Setting Org Name
	testUtil.setTextValue(CompanyName, testData.OrgName);
	// clicking on Submit Button
	bulkSimPageObj.ClickSubmitButton();
	Thread.sleep(1000);
	// Clicking on Submit Button for Receipent Page
	bulkSimPageObj.ClickSubmitButton();
	// checking for the Mottatt Text to come on the Recipt page
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	// Assertion
	Assert.assertEquals("Mottatt!", str);

    }

    @AfterClass
    public static void closeBrowser() {
	System.out.println("Closing Chrome browser");
	driver.quit();
    }

}
