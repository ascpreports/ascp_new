package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class POM_Keywords {
	
	Logger Application_Log;
	Properties prop;
	WebDriver driver;
	static POM_Keywords k;
	
	public POM_Keywords() throws IOException {//Constructor
    	
     	//initialize the properties
    	prop = new Properties();
    	FileInputStream fs = new FileInputStream(POM_Constants.PROPERTIES_FILE_PATH);
		prop.load(fs);
		
	}
	
	public String getProp(String propName){
		
		return(prop.getProperty(propName));
	}
	
	public static POM_Keywords getInstance() {//singleton class : to ensure only one driver exists for each browser type
		if (k==null){
			try {
				k = new POM_Keywords();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return k;
	}
	
	public static Logger Test_Logging() {
		// add log4j.jar
		//add log4j.properties directly inside the src folder
		//create the object in the code
		//BasicConfigurator.configure();
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		//APPLICATION_LOGS.debug(text_to_be_displayed);
		//APPLICATION_LOGS.debug("We are writing in the log file");
		//APPLICATION_LOGS.debug("starting the test case");
		return APPLICATION_LOGS;
	}
	
	public void gotoElement(WebDriver driver, WebElement obj){
		Actions a2 = new Actions(driver);
		a2.moveToElement(obj).click().perform();
		
		
	}

}

