package com.telia.automation.tests;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.RestClient;
import Utils.UtilPage;

import com.telia.automation.PageObject.AddAdministratorPageObj;

public class RestTests {
    public static WebDriver driver;
    RestClient client = new RestClient();   



   @Test
   public void filterByMetaDataCheckTest() {
       ArrayList<String> metadataList = client.GetData();    
}}