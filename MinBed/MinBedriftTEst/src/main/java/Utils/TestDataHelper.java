package Utils;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestDataHelper {
    static Map<String, String> tempMap = null;
    // Map to store test data
    static Map<String, String> dataMap = new HashMap<String, String>();

    // Method to get TestData for a test script
    public static Map<String, String> getTestData() {
	return dataMap;
    }

    // Method to populate test data from TestRail
    public static void setTestData(String testDataFromTestRail) {
	
	if (tempMap != null) {
	    try {
		// if dataMap is null, then copy the tempMap directly
		if (dataMap == null) {
		   // dataMap = new HashMap<>(tempMap);
		} else {
		    dataMap.putAll(tempMap);
		}
	    } catch (Exception e) {
		System.out.println(e.getMessage());
	    }
	}
    }

    
    

    // Method to add values to test data individually
    public static void addTestData(String key, String value) {
	try {
	    // check if dataMap is not null
	    if (dataMap == null) {
		dataMap = new HashMap<String, String>();
	    }
	    dataMap.put(key, value);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
