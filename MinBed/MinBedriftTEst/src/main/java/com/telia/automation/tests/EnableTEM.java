package com.telia.automation.tests;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.telia.automation.PageObject.TEMPageObj;
import com.telia.automation.PageObject.bulkSimPageObj;
import Utils.Helper;
import Utils.TESTData;
import Utils.UtilPage;

public class EnableTEM {
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
    public void EnableTEMForTheFirstTime() throws InterruptedException {
	// click on Drop Down Menu on Home Page
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	driver.findElements(By.cssSelector(".dropdown")).get(0).click();
	driver.findElement(By.cssSelector(".dropped #menudropdown3")).click();

	driver.findElement(By.cssSelector("#addExpenseShare")).click();
	Thread.sleep(8000);
	driver.findElement(By.cssSelector(".columns.medium-4.medium-offset-8 .primaryButton.align-right")).click();
	bulkSimPageObj.ClickSubmitButton();
	Thread.sleep(2000);
	// Checking for the pass Text to load
	String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
	if (str == "") {
	    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

	}
	Assert.assertEquals("Mottatt!", str);
    }

    @Test
    public void TurnONOFFCostsharing() throws InterruptedException {
	// click on Drop Down Menu on Home Page
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	TEMPageObj temPageObj = PageFactory.initElements(driver, TEMPageObj.class);
	temPageObj.clickOnHomeDropdownMenu(0);
	temPageObj.clickOnAdministration();
	temPageObj.clickOnAdministrerkostnadsdeling();
	temPageObj.ClickOnTurnOnCostSharing();
	bulkSimPageObj.ClickSubmitButton();
	String Text = bulkSimPageObj.CheckforPassText();
	// Assertion
	Assert.assertEquals("Mottatt!", Text);
	temPageObj.clickOnLinkText("Lukk");

    }

    @Test
    public void CreateTEMProfile() throws InterruptedException {
	// click on Drop Down Menu on Home Page
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	TEMPageObj temPageObj = PageFactory.initElements(driver, TEMPageObj.class);
	temPageObj.clickOnHomeDropdownMenu(0);
	temPageObj.clickOnAdministration();
	temPageObj.clickOnAdministrerkostnadsdeling();
	temPageObj.ClickOnCreateProfile();
	WebElement ProfileName = temPageObj.getProfileName();
	// setting the value in number of sim card
	testUtil.setTextValue(ProfileName, "DemoTest");
	WebElement Description = temPageObj.getDescription();
	// setting the value in number of sim card
	testUtil.setTextValue(Description, "Simple Test Automation Profile");
	bulkSimPageObj.ClickSubmitButton();
	temPageObj.ClickOnStandardRadioButton();
	temPageObj.SetTemLimits();
	bulkSimPageObj.ClickSubmitButton();
	String Text = bulkSimPageObj.CheckforPassText();
	// Assertion
	Assert.assertEquals("Endring bestilt", Text);
	temPageObj.clickOnLinkText("Lukk");

    }

    @Test
    public void ChangeNameOfProfile() throws InterruptedException {
	// click on Drop Down Menu on Home Page
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	TEMPageObj temPageObj = PageFactory.initElements(driver, TEMPageObj.class);
	temPageObj.clickOnHomeDropdownMenu(0);
	temPageObj.clickOnAdministration();
	temPageObj.clickOnAdministrerkostnadsdeling();
	Thread.sleep(5000);
	driver.findElements(By.cssSelector(".columns.medium-5")).get(0).findElement(By.cssSelector("a")).click();
	String str = driver.findElements(By.cssSelector(".columns.large-6 input")).get(0).getAttribute("value");
	driver.findElement(By.cssSelector(".columns.large-6 input")).sendKeys(" updated");
	driver.findElement(By.cssSelector(".secondaryButton.pull-left")).click();

    }
    @Test
    public void AssignCostSharingProfile() throws InterruptedException {
	// click on Drop Down Menu on Home Page
	bulkSimPageObj bulkSimPageObj = PageFactory.initElements(driver, bulkSimPageObj.class);
	TEMPageObj temPageObj = PageFactory.initElements(driver, TEMPageObj.class);
	WebElement ClickButton = driver.findElement(By.cssSelector(".tsr-today-link"));
	testUtil.waitForElementFluently(ClickButton, 20);
	testUtil.setCssSelectorWithIndex(".tsr-today-link", 5);
	List<WebElement> rows=driver.findElements(By.cssSelector(".radio-container"));
	List<String> rowList = new ArrayList<String>();
	int a= rows.size();
	//WebElement e=driver.findElement(By.cssSelector("label"));
	for(int i=1;i<=a;i++)
	{
	    if(i==a)
	    {
	    driver.findElement(By.cssSelector("div.radio-container:nth-of-type(2)>label>span.radio")).click();
	    }
    }
	
	temPageObj.clickOnFinish();	
	// checking for the Mottatt Text to come on the Recipt page
			String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
			if (str == "") {
			    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

			}
			// Assertion
			Assert.assertEquals("Endring bestilt", str);
}}