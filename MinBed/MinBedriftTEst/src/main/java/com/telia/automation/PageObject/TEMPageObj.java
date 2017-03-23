package com.telia.automation.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import Utils.UtilPage;

public class TEMPageObj {
    private WebDriver driver;
    UtilPage testUtil = new UtilPage(driver); 
    
    public TEMPageObj(WebDriver driver) {
	this.driver = driver;
}


    @FindBy(id = "name")
	public WebElement NameOfCostSharingProfile;

    @FindBy(id = "description")
   	public WebElement description;

    

    public void clickOnHomeDropdownMenu(int index) {
	// TODO Auto-generated method stub
	driver.findElements(By.cssSelector(".dropdown")).get(index).click();
    }





    public void clickOnAdministration() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector(".dropped #menudropdown3")).click();
    }





    public void clickOnAdministrerkostnadsdeling() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector("#addExpenseShare")).click();
    }





    public void ClickOnTurnOnCostSharing() throws InterruptedException  {
	// TODO Auto-generated method stub
	Thread.sleep(8000);
	driver.findElements(By.cssSelector(".secondaryButton")).get(1).click();
	
    }

    public void waitForElementFluently(WebElement identifyBy, int seconds) {
	int retry = 0;
	int retryCount = seconds < 25 ? 2 : 1;
	while (retry < retryCount) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(
							200, TimeUnit.MILLISECONDS);
			wait.until(ExpectedConditions.visibilityOf((identifyBy)));
		} catch (Exception ex) {
		}
		retry++;
	}
}





    public void clickOnLinkText(String text) {
	// TODO Auto-generated method stub
	  driver.findElement(By.linkText(text)).sendKeys(Keys.ENTER);
	
    }





    public void ClickOnCreateProfile() throws InterruptedException {
	// TODO Auto-generated method stub
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".columns.medium-8.align-right .primaryButton")).click();
	
	
    }





    public WebElement getProfileName() {
	// TODO Auto-generated method stub
	return this.NameOfCostSharingProfile;
    }





    public WebElement getDescription() {
	// TODO Auto-generated method stub
	return this.description;
    }





    public void ClickOnStandardRadioButton() throws InterruptedException {
	// TODO Auto-generated method stub
	Thread.sleep(8000);
	//clicking on standard 
	 driver.findElements(By.cssSelector(".radio-container")).get(1).findElement(By.cssSelector("label")).click();
	 
	

//	driver.findElement(By.cssSelector(".radio-container span.radio")).getText();
	
    }





    public void SetTemLimits() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector("#NON_INCLUDED_DATA_DOMESTIC")).sendKeys("100");
	driver.findElement(By.cssSelector("#DIRECTORY_SERVICES")).sendKeys("10");
	driver.findElement(By.cssSelector("#CONTENT_ENTERTAINMENT_AND_SERVICES")).sendKeys("20");
	driver.findElement(By.cssSelector("#SERVICE_NUMBERS")).sendKeys("40");
    }





    public void ChangeNameOfProfile() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector(".columns.medium-5 a")).click();
	String str=driver.findElement(By.cssSelector(".columns.large-6")).getAttribute("value");
	System.out.println(str);
	
	
    }





    public void clickOnFinish() {
	driver.findElement(By.cssSelector(".ts-icon-arrow-right.chevron-right")).click();
	
    }
}
