package com.telia.automation.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Helper;

import com.google.api.client.googleapis.testing.TestUtils;
import com.telia.automation.PageObject.AddInvoiceLocationPageObj;
import com.telia.automation.PageObject.bulkSimPageObj;



import Utils.TESTData;
import Utils.UtilPage;

public class AddInvoiceLocation {
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
    public void AddNewAccount() throws InterruptedException {
	AddInvoiceLocationPageObj addInvoicePageObj = PageFactory.initElements(driver, AddInvoiceLocationPageObj.class);
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	// Clicking on Add New Account from the action button
	//WebElement AddSubs = driver.findElement(By.cssSelector("a.tsr-today-link"));
	//testUtil.waitForElementFluently(AddSubs, 20);
	
	testUtil.setCssSelectorWithIndex(".tsr-today-link", 2);
	// getting Account Name field
	WebElement invoiceNameField = addInvoicePageObj.getAccountName();
	// Setting the value in First Name Field
	testUtil.setTextValue(invoiceNameField, testData.InvoiceName);
	WebElement invoiceReceiverName = addInvoicePageObj.getinvoiceReceiverName();
	// Setting the value in First Name Field
	testUtil.setTextValue(invoiceReceiverName, testData.InvoiceReceiverName);
	WebElement Tilleggsinformasjon = addInvoicePageObj.getTilleggsinformasjon();
	// Setting the value in First Name Field
	testUtil.setTextValue(Tilleggsinformasjon, testData.Tilleggsinformasjon);

	WebElement StreetName = addInvoicePageObj.getStreetName();
	// Setting the value in First Name Field
	testUtil.setTextValue(StreetName, testData.StreetName);
	WebElement StreetNumber = addInvoicePageObj.getStreetNumber();
	// Setting the value in First Name Field
	testUtil.setTextValue(StreetNumber, testData.StreetNumber);
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
	bulkSimPageObj.ClickSubmitButton();
	// Checking for the pass Text to load
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	Assert.assertEquals("Mottatt!", str);

    }

}
