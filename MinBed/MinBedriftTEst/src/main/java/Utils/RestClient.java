package Utils;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


public class RestClient {
   /* String authToken="Bearer eyJraWQiOm51bGwsImFsZyI6IlJTMjU2In0.eyJleHAiOjE0ODg5NjkzOTIsImlhdCI6MTQ4ODg4Mjk5MiwibmJmIjoxNDg4ODgyOTMyLCJzaWQiOiJYT2c2ekVXNEVGUFBqRERHIiwiY2lkIjoibWluYmVkcmlmdCIsImNodCI6IklOVF9XRUIiLCJkYyI6Ik5FVEwiLCJ0ciI6InRydWUifQ.Io3Avfbv6o0yh0yeAWhP3PHy80c4ihZLC0aWvRif4xKOb13VUHtCxZsInmWG8s2U67UGZIqbic3dYHnIhCXzqXsRhAbcTlIu08d206gv5W0CSrAHRnzowvZL_Z-noM9FoxjOTvcD--FtLbW_PEX4gKHYSCtVJ2IkqF-0W7H_xdn0grByHm5NLBkPgycGc-7mn9bn5uExJ4tHiZF1ShYxmhhV3ULjLFWVl-JOTh36pI912bOodDQP6bddKpJauQt0bJgiorKPJZEosNJQ3B8cTilmXPEKOTQp13hseLL_SOLS4XEl4-MhbqGH7Pte3TQPNTWjr5RW2o2fHxgap5qmdQ";
    String accept ="application/vnd.teliasonera.ordercapture.v4+json";
    String envURLDomain = "http://no-neo-at-02.netcom.no:9055/ordercapture/multi";
    // login to Vimond platform and store the Authorization and JWT tokens
   
  
    public JSONArray GetData() {
	String body = "[\n  {\n    \"resource\": \"/ordercapture/orders/akjh-1b4e-57f7-689f-72a6-b83e/content\",\n    \"method\": \"PUT\",\n    \"body\": {\n      \"subscriptions\": {\n        \"new:92059608\": {\n          \"product_user\": {\n            \"op_type\": \"add\",\n            \"individual\": {\n              \"first_name\": \"surabhi\",\n              \"surname\": \"batra\",\n              \"birthdate\": null,\n              \"title\": \"\"\n            },\n            \"street_address\": {\n              \"street_name\": \"\",\n              \"street_number\": \"\",\n              \"street_number_suffix\": \"\",\n              \"postcode\": \"0160\",\n              \"city\": \"OSLO\",\n              \"country_code\": \"NOR\"\n            }\n          },\n          \"product_user_marketing_preferences\": {\n            \"sms\": true,\n            \"telephone\": true,\n            \"op_type\": \"add\",\n            \"email\": false\n          },\n          \"directory_listing\": {\n            \"mode\": \"not_listed\",\n            \"op_type\": \"add\"\n          },\n          \"owning_account\": {\n            \"op_type\": \"add\",\n            \"existing_account_id\": \"808749212\"\n          },\n          \"main_offering\": {\n            \"op_type\": \"add\",\n            \"offering_code\": \"AVTALEPRIS_TB_M.REGULAR\"\n          },\n          \"additional_products\": {\n            \"VOICEMAIL_FREE\": {\n              \"op_type\": \"add\",\n              \"product_characteristics\": {\n                \"V-MAIL\": {\n                  \"config\": [\n                    {\n                      \"name\": \"LANGUAGE\",\n                      \"value\": \"NO\"\n                    }\n                  ]\n                }\n              }\n            },\n            \"RLH_NORDIC_BALTICS_B2B\": {\n              \"op_type\": \"add\"\n            },\n            \"TB_CHARGE\": {\n              \"op_type\": \"add\"\n            }\n          },\n          \"sim_main\": {\n            \"op_type\": \"add\",\n            \"hardware_item_reference_id\": \"68fe8c10e2e67f730ff24e8f\"\n          }\n        }\n      },\n      \"hardware_items\": {\n        \"68fe8c10e2e67f730ff24e8f\": {\n          \"hardware_delivery_reference_id\": \"766e78b0754101e2351d4b42\",\n          \"unit_sales_price_ex_vat\": {\n            \"kroner\": 0,\n            \"ore\": 0\n          },\n          \"final_vat\": {\n            \"percentage\": 25,\n            \"amount\": {\n              \"kroner\": 0,\n              \"ore\": 0\n            },\n            \"rounding\": 0\n          },\n          \"material_id\": \"4001112\",\n          \"quantity\": 1\n        }\n      },\n      \"hardware_deliveries\": {\n        \"766e78b0754101e2351d4b42\": {\n          \"shipment_delivery\": {\n            \"shipment_method\": \"LETTER\",\n            \"individual\": {\n              \"first_name\": \"surabhi\",\n              \"surname\": \"batra\"\n            },\n            \"organization\": \"nav\",\n            \"street_address\": {\n              \"city\": \"OSLO\",\n              \"postcode\": \"0133\",\n              \"street_name\": \"POSTBOKS 35 GRØNLAND\",\n              \"country_code\": \"NOR\"\n            }\n          }\n        }\n      },\n      \"client_meta\": {\n        \"order_description\": \"addNewSubscriber\"\n      }\n    }\n  },\n  {\n    \"resource\": \"/ordercapture/orders/akjh-1b4e-57f7-689f-72a6-b83e/checks?wait_for_result_timeout=120000\",\n    \"method\": \"POST\",\n    \"body\": null\n  },\n  {\n    \"resource\": \"/ordercapture/orders/akjh-1b4e-57f7-689f-72a6-b83e/submit\",\n    \"method\": \"POST\"\n  },\n  {\n    \"resource\": \"/ordercapture/orders/akjh-1b4e-57f7-689f-72a6-b83e\",\n    \"method\": \"GET\"\n  }\n]";
//	String body ="[\n  {\n    \"resource\": \"/ordercapture/orders/ytre-64d9-5d6b-2c31-7707-ba7b/content\",\n    \"method\": \"PUT\",\n    \"body\": {\n      \"subscriptions\": {\n        \"new:92068408\": {\n          \"product_user\": {\n            \"op_type\": \"add\",\n            \"individual\": {\n              \"first_name\": \"surabhi\",\n              \"surname\": \"batra\",\n              \"birthdate\": null,\n              \"title\": \"\"\n            },\n            \"street_address\": {\n              \"street_name\": \"\",\n              \"street_number\": \"\",\n              \"street_number_suffix\": \"\",\n              \"postcode\": \"0160\",\n              \"city\": \"OSLO\",\n              \"country_code\": \"NOR\"\n            }\n          },\n          \"product_user_marketing_preferences\": {\n            \"sms\": true,\n            \"telephone\": true,\n            \"op_type\": \"add\",\n            \"email\": false\n          },\n          \"directory_listing\": {\n            \"mode\": \"not_listed\",\n            \"op_type\": \"add\"\n          },\n          \"owning_account\": {\n            \"op_type\": \"add\",\n            \"existing_account_id\": \"922920012\"\n          },\n          \"main_offering\": {\n            \"op_type\": \"add\",\n            \"offering_code\": \"AVTALEPRIS_TB_M.REGULAR\"\n          },\n          \"additional_products\": {\n            \"VOICEMAIL_FREE\": {\n              \"op_type\": \"add\",\n              \"product_characteristics\": {\n                \"V-MAIL\": {\n                  \"config\": [\n                    {\n                      \"name\": \"LANGUAGE\",\n                      \"value\": \"NO\"\n                    }\n                  ]\n                }\n              }\n            },\n            \"RLH_NORDIC_BALTICS_B2B\": {\n              \"op_type\": \"add\"\n            },\n            \"TB_CHARGE\": {\n              \"op_type\": \"add\"\n            }\n          },\n          \"sim_main\": {\n            \"op_type\": \"add\",\n            \"hardware_item_reference_id\": \"20e0262fb0ba2951040evc55\"\n          }\n        }\n      },\n      \"hardware_items\": {\n        \"20e0262fb0ba2951040evc55\": {\n          \"hardware_delivery_reference_id\": \"727851b7162eadffd58f7gfd\",\n          \"unit_sales_price_ex_vat\": {\n            \"kroner\": 0,\n            \"ore\": 0\n          },\n          \"final_vat\": {\n            \"percentage\": 25,\n            \"amount\": {\n              \"kroner\": 0,\n              \"ore\": 0\n            },\n            \"rounding\": 0\n          },\n          \"material_id\": \"9054990\",\n          \"quantity\": 1\n        }\n      },\n      \"hardware_deliveries\": {\n        \"727851b7162eadffd58f7jfd\": {\n          \"shipment_delivery\": {\n            \"shipment_method\": \"LETTER\",\n            \"individual\": {\n              \"first_name\": \"surabhi\",\n              \"surname\": \"batra\"\n            },\n            \"organization\": \"nav\",\n            \"street_address\": {\n              \"city\": \"SANDVIKA\",\n              \"postcode\": \"1303\",\n              \"street_name\": \"POSTBOKS 626\",\n              \"country_code\": \"NOR\"\n            }\n          }\n        }\n      },\n      \"client_meta\": {\n        \"order_description\": \"addNewSubscriber\"\n      }\n    }\n  },\n  {\n    \"resource\": \"/ordercapture/orders/ytre-64d9-5d6b-2c31-7707-ba7b/checks?wait_for_result_timeout=120000\",\n    \"method\": \"POST\",\n    \"body\": null\n  },\n  {\n    \"resource\": \"/ordercapture/orders/ytre-64d9-5d6b-2c31-7707-ba7b/submit\",\n    \"method\": \"POST\"\n  },\n  {\n    \"resource\": \"/ordercapture/orders/ytre-64d9-5d6b-2c31-7707-ba7b\",\n    \"method\": \"GET\"\n  }\n]";
//String body="ethod\": \"PUT\",\n    \"body\": {\n      \"subscriptions\": {\n        \"new:97788890\": {\n          \"product_user\": {\n            \"op_type\": \"add\",\n            \"individual\": {\n              \"first_name\": \"surabhi\",\n              \"surname\": \"batra\",\n              \"birthdate\": null,\n              \"title\": \"\"\n            },\n            \"street_address\": {\n              \"street_name\": \"\",\n              \"street_number\": \"\",\n              \"street_number_suffix\": \"\",\n              \"postcode\": \"0160\",\n              \"city\": \"OSLO\",\n              \"country_code\": \"NOR\"\n            }\n          },\n          \"product_user_marketing_preferences\": {\n            \"sms\": true,\n            \"telephone\": true,\n            \"op_type\": \"add\",\n            \"email\": false\n          },\n          \"directory_listing\": {\n            \"mode\": \"not_listed\",\n            \"op_type\": \"add\"\n          },\n          \"owning_account\": {\n            \"op_type\": \"add\",\n            \"existing_account_id\": \"808749212\"\n          },\n          \"main_offering\": {\n            \"op_type\": \"add\",\n            \"offering_code\": \"AVTALEPRIS_TB_RESPONS.REGULAR\"\n          },\n          \"additional_products\": {\n            \"VOICEMAIL_FREE\": {\n              \"op_type\": \"add\",\n              \"product_characteristics\": {\n                \"V-MAIL\": {\n                  \"config\": [\n                    {\n                      \"name\": \"LANGUAGE\",\n                      \"value\": \"NO\"\n                    }\n                  ]\n                }\n              }\n            },\n            \"TB_CHARGE\": {\n              \"op_type\": \"add\"\n            }\n          },\n          \"sim_main\": {\n            \"op_type\": \"add\",\n            \"sim_card_number\": \"08947080026000010787\"\n          }\n        }\n      },\n      \"hardware_items\": {\n        \n      },\n      \"hardware_deliveries\": {\n        \n      },\n      \"client_meta\": {\n        \"order_description\": \"addNewSubscriber\"\n      },\n      \"orderer\": {\n        \"authentication_method\": \"PIN\",\n        \"telephone_number\": \"91660676\"\n      }\n    }\n  },\n  {\n    \"resource\": \"/ordercapture/orders/lkjh-890i-58c6-840c-56gt-f416/checks?wait_for_result_timeout=120000\",\n    \"method\": \"POST\",\n    \"body\": null\n  },\n  {\n    \"resource\": \"/ordercapture/orders/lkjh-890i-58c6-840c-56gt-f416/submit\",\n    \"method\": \"POST\"\n  },\n  {\n    \"resource\": \"/ordercapture/orders/lkjh-890i-58c6-840c-56gt-f416\",\n    \"method\": \"GET\"\n  }\n]";
	RestTemplate restTemplate = new RestTemplate();
	// set Authorization token in headers
	HttpHeaders requestHeaders = new HttpHeaders();
	requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	requestHeaders.set("Accept",accept);
	requestHeaders.set("Authorization", authToken);

	// create request
	HttpEntity<String> request = new HttpEntity<>(body, requestHeaders);
	//HttpEntity<String> request = new HttpEntity<String>(requestHeaders);

	// initialize a list to store all metadata that match the requirement
	List<String> requiredMetadataList = new ArrayList<String>();

	JSONArray jsonArray = null;
	try {
	    // execute API
	    ResponseEntity<String> metadataResponse = restTemplate.exchange(envURLDomain, HttpMethod.POST, request, String.class);

	    // if call is successfull, get the body data
	    if (metadataResponse.getStatusCode() == HttpStatus.OK) {
		// parse JSON from String response received
		JSONParser parser = new JSONParser();
		jsonArray = (JSONArray) parser.parse(metadataResponse.getBody());

	    }
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	 System.out.println(jsonArray);
	 return jsonArray;
	 }
    
    

    
     * method to fetch metadata fields definitions of content panel and return metadata that satisfies given requirements
     * 
     * Input: A list of (key,value) pairs that say what metadata attributes and their values are we looking for e.g.
     * (required, true) and (hidden, false)
     * 
     * Output: A list of metadata title values that satisfy the given requirements
     
   */

    
}
