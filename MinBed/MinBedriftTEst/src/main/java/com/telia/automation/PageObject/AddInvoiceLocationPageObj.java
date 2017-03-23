package com.telia.automation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddInvoiceLocationPageObj {
    private WebDriver driver;
	public AddInvoiceLocationPageObj(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "additionalName")
	public WebElement Name;

	@FindBy(id = "invoiceReceiverName")
	public WebElement InvoiceReceiverName;
	
	@FindBy(id = "invoiceReceiverAdditionalname")
	public WebElement tilleggsinformasjon;
	
	
	@FindBy(css = ".medium-offset-1.medium-8.columns")
	public WebElement Fakturatype;
	
	@FindBy(id = "street_name")
	public WebElement streetName;
	
	@FindBy(id = "street_number")
	public WebElement streetNumber;
	
	public WebElement getAccountName() {
	    // TODO Auto-generated method stub
	    return this.Name;
	    }


	public WebElement getinvoiceReceiverName() {
	    // TODO Auto-generated method stub
	    return this.InvoiceReceiverName;
	}


	public WebElement getTilleggsinformasjon() {
	    // TODO Auto-generated method stub
	    return this.tilleggsinformasjon;
	}


	public WebElement getStreetName() {
	    // TODO Auto-generated method stub
	    return this.streetName;
	}
	
	public WebElement getStreetNumber() {
	    // TODO Auto-generated method stub
	    return this.streetNumber;
	}
}
