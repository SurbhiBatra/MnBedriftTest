package Utils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class UtilPage {
    public UtilPage() {
    }

    private WebDriver driver = null;
    UtilPage elements;

    public UtilPage(WebDriver driver) {
	this.driver = driver;
    }

    public String names[] = { "Surbhi", "Monica", "Viggo", "Saurabh" };

    public String getName() {
	int num = random(0, 4);
	return names[num];
    }

    // For setting the input field value
    public void setTextValue(WebElement textField, String value) throws InterruptedException {
	System.out.println("entering values in input fields");
	// elements.waitForElementFluently(textField, 10);
	Thread.sleep(1000);
	textField.sendKeys(value);
    }

    public int random(int lowerBound, int upperBound) {
	return (lowerBound + (int) Math.round(Math.random() * (upperBound - lowerBound)));
    }

    // for setting CSS selector 
    public void setCssSelector(String cssSelector) throws InterruptedException {
	System.out.println("entering values in css selector");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(cssSelector)).click();
    }

    //Setting CSS Selector and Clicking on that Element
    public void setCssSelectorWithClick(String cssSelector) throws InterruptedException {
	System.out.println("entering values in css selector");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(cssSelector)).click();
	;
    }

    public void setCssSelectorWithIndex(String cssSelector, int index) {
	System.out.println("entering values in css selector");
	WebElement a =driver.findElements(By.cssSelector(cssSelector)).get(index);
	
	a.click();
    }

    //Wait Function for WebElement to get load on the page  
    public void waitForElementFluently(WebElement identifyBy, int seconds) {
	int retry = 0;
	int retryCount = seconds < 25 ? 2 : 1;
	while (retry < retryCount) {
	    try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
			.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.visibilityOf((identifyBy)));
	    } catch (Exception ex) {
	    }
	    retry++;
	}
    }

    public void waitForElementsFluently(List<WebElement> identifyBy, int seconds) {
	int retry = 0;
	int retryCount = seconds < 25 ? 2 : 1;
	while (retry < retryCount) {
	    try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
			.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElements(identifyBy));
	    } catch (Exception ex) {
	    }
	    retry++;
	}
    }

    public void waitForElementToBeInvisible(By locator, int seconds) {
	int retry = 0;
	int retryCount = 1;
	while (retry < retryCount) {
	    try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
			.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
	    } catch (Exception ex) {
	    }
	    retry++;
	}
    }
    
    //Wait Function to be Visible using locator
    public void waitForElementToBeVisible(By locator, int seconds) {
   	int retry = 0;
   	int retryCount = 1;
   	while (retry < retryCount) {
   	    try {
   		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
   			.pollingEvery(200, TimeUnit.MILLISECONDS);
   		wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
   	    } catch (Exception ex) {
   	    }
   	    retry++;
   	}
       }
    

    public void waitForElementToBeClickable(WebElement element, int seconds) {
	int retry = 0;
	int retryCount = 1;
	while (retry < retryCount) {
	    try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
			.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	    } catch (Exception ex) {
	    }
	    retry++;
	}
    }

    public void waitForElementAttributeToContainValue(WebElement element, String attribute, String value, int seconds) {
	int retry = 0;
	int retryCount = 1;
	while (retry < retryCount) {
	    try {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
			.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	    } catch (Exception ex) {
	    }
	    retry++;
	}
    }

    // Method to check if an element is present on the page
    public Boolean checkElementIsPresent(By locator) {
	this.waitForElementsFluently(driver.findElements(locator), 10);
	List<WebElement> result = driver.findElements(locator);
	if (result.size() > 0) {
	    return true;
	} else
	    return false;
    }

}
