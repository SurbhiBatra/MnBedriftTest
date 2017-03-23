package com.telia.automation.PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAdministratorPageObj {
    private WebDriver driver;
	public AddAdministratorPageObj(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(id = "local_number")
	public WebElement PhoneNumber;
	
	
	
	
    public WebElement getPhoneNummerField() {
		return this.PhoneNumber;
	}


    public void getRole() {
	driver.findElement(By.cssSelector("#addRole")).click();
	
    }


    public void selectRole() {
	WebElement e=driver.findElements(By.cssSelector(".dropped")).get(1).findElements(By.cssSelector("ul>li")).get(0);
	e.findElement(By.tagName("a")).click();
	
	
	//WebElement e=driver.findElements(By.cssSelector(".dropped")).get(1).findElements(By.cssSelector("ul>li")).get(0);
	//e.findElement(By.tagName("a")).click();
	
    }


    public void clickSaveButton() {
	driver.findElement(By.cssSelector(".secondaryButton.loadingButton")).click();
	
    }


    public boolean checkAdmin() {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(".table>tbody>tr")));
	boolean flag=false;
	List<WebElement> rows=driver.findElements(By.cssSelector(".table>tbody>tr"));
	List<String> rowList = new ArrayList<String>();
	for(int i=0;i<rows.size();i++)
	{
	    rowList.add(rows.get(i).findElements(By.cssSelector("td")).get(1).getText());
	if(rowList.contains("90000005"));
	{ flag=true;}
	}
	return flag;
    }

}
    


