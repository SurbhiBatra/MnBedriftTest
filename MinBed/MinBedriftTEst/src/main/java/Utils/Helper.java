package Utils;

import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.MalformedURLException;
public class Helper {
    private String OS;
    private static String Platform;

    public static String getProperty(String key) {
	PropertiesConfiguration configuration;
	try {
	    configuration = new PropertiesConfiguration("config.properties");
	    return configuration.getProperty(key).toString();
	} catch (org.apache.commons.configuration.ConfigurationException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static Map<String, String> intializeTestData() {
	Map<String, String> dataMap = TestDataHelper.getTestData();

	// Get data from application.properties file and add data to test data map
	if (dataMap.get("OS") == null) {
	    TestDataHelper.addTestData("OS", getProperty("OS"));
	    setPlatform(getProperty("OS"));
	   
	}

	// Get data from config.properties file and add data to test data map
	TestDataHelper.addTestData("URL", getProperty("URL"));
	TestDataHelper.addTestData("OS", getProperty("OS"));
	return TestDataHelper.getTestData();

    }
   
    public static  WebDriver setLocalChromeDriverPath(String operatingSystem) {
	// TODO Auto-generated method stub
	String driverPath = null;
	if(operatingSystem.equals("Windows")){
	    driverPath= Helper.getProperty("windows_chrome_driver_path");	
	}
	else if(operatingSystem.equals("linux")) {
	    driverPath= Helper.getProperty("linux_chrome_driver_path");    
	}
	else if(operatingSystem.equals("mac")){
	    driverPath= Helper.getProperty("mac_chrome_driver_path");  
	}
	String parentPath = new File(System.getProperty("user.dir")).getParentFile().getAbsolutePath();
	driverPath = parentPath + driverPath;
	System.setProperty("webdriver.chrome.driver", driverPath);
	return new ChromeDriver(); 
    }




    private static void getPath() {
	// TODO Auto-generated method stub
	
    }

    public static void setPlatform(String OS) {
	OS = OS;
    }

    public void setOS(String OS) {
	this.OS = OS;
	TestDataHelper.addTestData("OS", OS);
    }

    public String getOS() {
	return OS;
    }

}
