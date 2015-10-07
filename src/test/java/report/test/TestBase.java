package report.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.FileUtils;

import Util.ErrorUtil;
import Util.POM_Keywords;

//import report.pages.TopMenu;
import report.pages.ypLocalAds;

public class TestBase {
	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG=null;
	public static WebDriver driver=null;
	//public static TopMenu topMenu=null;
	public static boolean isLoggedIn=false;
	public String LoggedInUser;
	public ypLocalAds ypAds;
	
	//Setup POM_Keyword object
		static POM_Keywords app= POM_Keywords.getInstance();
		Logger log = POM_Keywords.Test_Logging();
		
		public void initConfigurations(){
			//Logging

			//APPLICATION_LOGS = TestUtil.initLogging(this.getClass());
			//Driver object setup	
				if(driver == null){
					//if(CONFIG.getProperty("browser").equals("MOZILLA"))
					if(app.getProp("browser").equals("MOZILLA")){
						System.out.println(app.getProp("browser"));
						driver = new FirefoxDriver();
					}
					else if(app.getProp("browser").equals("IE"))
						driver = new InternetExplorerDriver();
					else if(app.getProp("browser").equals("CHROME"))
						driver = new ChromeDriver();
				}
			}	
		
		public void quitDriver(){
			//isLoggedIn=false;
			//driver.get("https://ssoqa.yp.com/cas/logout");
			driver.quit();
			driver = null;
		}
		
	/*	public TopMenu getTopMenu(){
			if(topMenu==null){
				topMenu = PageFactory.initElements(driver, TopMenu.class);
			}
			return topMenu;
			
		}*/
		
		public void writeToLogFile(String textvalue){
			log.debug(textvalue);
		}

		public void gotoWebElementByMouse(WebDriver dr, WebElement obj){
			Actions a2 = new Actions(driver);
			a2.moveToElement(obj).click().perform();
		}
		
		public List<WebElement> getChildElements(String parentObject, String childObject, WebDriver driver){
			WebElement parentObject1 = driver.findElement(By.xpath(parentObject));
			List<WebElement> childObjects = parentObject1.findElements(By.xpath(childObject));
			return childObjects;
		}
		
		public HashMap<String, WebElement> createMapfromObjectList(List<WebElement> objectList, HashMap<String, WebElement> hmap, String section ){
			for(WebElement current : objectList){
				hmap.put("$$$$$$$$----" +section+ "--" +current.getText(),current);
				//System.out.println("Text for the current element in top section is---"+ current.getText());
				//System.out.println("size of list is---" + objectList.size());
			}
			return hmap;
			
		}
		
		public HashMap<WebElement, String> createMapfromObjectListNew(List<WebElement> objectList, HashMap<WebElement, String> hmap, String section ){
			for(WebElement current : objectList){
				hmap.put(current, "$$$$$$$$----" +section+ "--" +current.getText());
				System.out.println("Text for the current element in top section is---"+ current.getText());
				System.out.println("size of list is---" + objectList.size());
			}
			return hmap;
			
		}
		
		protected boolean isElementPresent(By by) {
			try {
				driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				return false;
			}
		}
		
		protected boolean isElementPresentWithWait(By by, int waitTime) {
			WebDriverWait wait = waitFor(driver, waitTime);
			
			try {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
				
				//driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				return false;
			}
		}
		
		protected boolean waitAndClick(By by, int waitTime) {
			WebDriverWait wait = waitFor(driver, waitTime);
			
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
				element.click();
				//driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				return false;
			}
		}
		
		
		public void gotoElement(WebDriver driver, WebElement obj){
			Actions a2 = new Actions(driver);
			a2.moveToElement(obj).click().perform();
			
			
		}
		
		/*
		 * This method handles the pop windows
		 * @param parentWindowHandler pass the parent window
		 * @param path pass the xpath of the element
		 */
		public void handlePopup(String parentWindowHandler, String path) {

			String subWindowHandler = null;
			Set<String> handles = driver.getWindowHandles(); // get all window
			// handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			try {
				if (subWindowHandler != null) {
					driver.switchTo().window(subWindowHandler);
					if (path != null)
						driver.findElement(By.xpath(path)).click();
				}
				// } catch (NoSuchElementException ne) {
				// // Do Nothing if there is no Popup window
				// }
			} catch (Exception ne) {
				// Do Nothing if there is no Popup window
			}

			driver.switchTo().window(parentWindowHandler); // switch back to parent
			// window
		}
		
		public boolean verifyElementPresentWithText(String xpath, String text) {

			boolean value;
			try {
				WebElement element = findElementByXPath(xpath);
				if (!element.getText().equals(text))
					value = false;
				else
					value = true;
			} catch (NoSuchElementException e) {
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				value = false;
			}
			return value;
		}
		
		public boolean verifyElementPresentWithTextBy(By by, String text) {

			boolean value;
			try {
				WebElement element = findElementBy(by);
				if (!element.getText().equals(text))
					value = false;
				else
					value = true;
			} catch (NoSuchElementException e) {
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				value = false;
			}
			return value;
		}
		
		public boolean verifySelectListWithSelectedOption(By by, String text) {

			boolean value;
			try {
				WebElement element =new Select(driver.findElement(by)).getFirstSelectedOption();
				if (!element.getText().equals(text))
					value = false;
				else
					value = true;
			} catch (NoSuchElementException e) {
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				value = false;
			}
			return value;
		}
		
		public static WebElement findElementByXPath(String xpath) {

			return driver.findElement(By.xpath(xpath));
		}
		
		protected WebElement findElementBy(By by) {

			return driver.findElement(by);

		}
		
		public boolean isElementPresentBy(By by, String type, int timeout) {
			driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
			String elementData = "";
			while (elementData.equals("")) {
				try {
					//waitSomeTime(2);
					if ("value".equalsIgnoreCase(type)) {
						elementData = findElementBy(by).getAttribute("value");
					} else if ("text".equalsIgnoreCase(type)) {
						elementData = findElementBy(by).getText();
					} else if ("class".equalsIgnoreCase(type)) {
						elementData = findElementBy(by).getAttribute("class");
					} else {
						elementData = findElementBy(by).getTagName();
					}

				} catch (StaleElementReferenceException se) {
					// DO nothing when you get this error
				}
			}
			return elementData.equals("") ? false : true;
		}
		
		public String getNumberWithNoDecimals(String number, String decimal) {

			return StringUtils.remove(number, decimal);
		}

		public static WebDriverWait waitFor(WebDriver webDriver, int milisec) {

			return new WebDriverWait(webDriver, milisec);
		}

		public void waitForPageToLoad(){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			while (!js.executeScript("return document.readyState").toString().equals("complete"))//not complete
			try {
				log.debug("Waiting for page to load");
				Thread.sleep(8000);
			}catch(InterruptedException e){
				log.debug(e);
				ErrorUtil.addVerificationFailure(e);
				e.printStackTrace();
			}
		}
		
		public String getAttributeWithWait(By by, String type){
			String elementData = "";
			if(isElementPresentBy(by, type, 10)){
				
				while (elementData.equals("")) {
					try {
						//waitSomeTime(2);
						if ("value".equalsIgnoreCase(type)) {
							elementData = findElementBy(by).getAttribute("value");
						} else if ("text".equalsIgnoreCase(type)) {
							elementData = findElementBy(by).getText();
						} else if ("class".equalsIgnoreCase(type)) {
							elementData = findElementBy(by).getAttribute("class");
						} else {
							elementData = findElementBy(by).getTagName();
						}

					} catch (StaleElementReferenceException se) {
						// DO nothing when you get this error
					}
				}
			}
			return elementData;
		}
		
		/*public void clickWhenReady(By locator, int timeout) {
		 
		WebElement element = null;
		 
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;
		 
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		 
		element.click();
		 
		 }*/
		


}
