package com.telia.automation.PageObject;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.api.client.googleapis.testing.TestUtils;

public class bulkSimPageObj {
	private WebDriver driver;

	private final String SimNumber = "12";

	public bulkSimPageObj(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".tsr-today-desc")
	public WebElement SimCardButton;
	
	@FindBy(id = "streetadr_postcode")
	public WebElement PostNummer;
	
	@FindBy(id = "amountOfSimcards")
	public WebElement simCardNumber;
	
	@FindBy(id = "first_name")
	public WebElement FirstName;
	
	@FindBy(id = "firstName")
	public WebElement FirstNamee;
	
	@FindBy(id = "lastName")
	public WebElement LastNamee;

	@FindBy(id = "surname")
	public WebElement LastName;

	@FindBy(id = "recipientCompanyName")
	public WebElement CompanyName;

	@FindBy(id = "recipientName")
	public WebElement recipientName;

	@FindBy(css = ".chevron > a.ts-icon-arrow-right.chevron-right")
	public WebElement SubmitButton;

	@FindBy(css = ".tsr-action-icon.ts-icon-newcontact > .tsr-today-desc")
	public WebElement AddNewSubscriberButton;

	@FindBy(id = "recipientPhone")
	public WebElement recipientPhone;

	@FindBy(id = "recipientEmail")
	public WebElement recipientEmail;

	public WebElement getSimCardNumber() {
		return this.simCardNumber;
	}

	public WebElement getFirstName() {
		return this.FirstName;
	}

	public WebElement getFirstNamee() {
		return this.FirstNamee;
	}

	public WebElement getLastNamee() {
		return this.LastNamee;
	}

	public WebElement getCompanyName() {
		return this.CompanyName;
	}

	public WebElement getLastName() {
		return this.LastName;
	}

	public WebElement getPostNummer() {
		return this.PostNummer;
	}

	public WebElement getNameOfRecipient() {
		return this.recipientName;
	}

	public WebElement getSubmitButton() {
		return this.SubmitButton;
	}
	public WebElement getRecipientEmail() {
		return this.recipientEmail;
	}
	
	public void getSubmitButtonClick() {
	this.SubmitButton.click();
	}

	public String getValidSimNumber() {
		return SimNumber;
	}

    public void ClickSubmitButton() throws InterruptedException {
		System.out.println("clicking submit button image");
		WebElement Button = driver.findElement(By
				.cssSelector(".ts-icon-arrow-right.chevron-right"));
		Thread.sleep(1000);
		Button.click();
		Thread.sleep(2000);

	}

	private void click(WebElement button) {
		System.out.println("Clicking on  button");
		waitForElementFluently(button, 20);
		button.click();
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

	public void clickOnButton(String button) {
		try {
			Thread.sleep(2000);
			if (button == "SimCardButton") {
				click(SimCardButton);
			}

			else if (button == "AddNewSubscriber") {
				click(AddNewSubscriberButton);
			} else if (button == "Submit") {
				click(SubmitButton);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement getrecipientPhone() {
		return this.recipientPhone;
	}

	public WebElement getPostnummer() {
		return this.PostNummer;
	}

	public void ClickButton() throws InterruptedException {
		driver.findElement(
				By.cssSelector(".chevron-top.slideToggle-switch.ts-icon-arrow-down.closed > .showToggle"))
				.click();
		Thread.sleep(2000);
	}

	public String CheckforPassText() {
	    // TODO Auto-generated method stub
	    String str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();
		if (str == "") {
		    str = driver.findElement(By.cssSelector(".medium-12.columns.end h3")).getText();

		}
		return str;
	}
}