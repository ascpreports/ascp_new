package report.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Util.POM_Constants;

import report.test.TestBase;

public class ypConnect extends TestBase{
	
	public ypConnect(WebDriver dr){
		driver=dr;
		//tb.initConfigurations();
	}
	By LOCALADS_OVERVIEW = By.xpath("//*[@id='dvSubNav']/img");
	By unexp_error = By.xpath("html/body/div[1]/h2");
	By error_token = By.xpath("//*[@id='errorToken']");
	By guest_DateRange = By.xpath("//*[@id='dvDateRange']/div[3]");
	By guest_DateRangeText = By.cssSelector("#dvDRExplanation");
	By guest_Message = By.xpath("//*[@id='abar-body']/div[3]");
	By DATE_RANGE = By.xpath("//*[@id='DisplayDates']");
	
	@FindBy(xpath="html/body/center[1]/h1")
	public WebElement page_load_fail;
	
	@FindBy(xpath= POM_Constants.REPORTS)
	public WebElement reports_Nav;
	
	@FindBy(xpath= "//*[@id='header']/header/div/div/nav/ul[1]/li/ul/li[3]/a")
	public WebElement ypConnectHeader_Nav;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/img")
	public WebElement overview_tab;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/a[1]/img")
	public WebElement leads_tab;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/a[2]/img")
	public WebElement connections_tab;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/a[3]/img")
	public WebElement traffic_dist_tab;
	
	@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[2]")
	public WebElement overview_Text;
	
	@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[1]/*/*/*/*/*")
	public WebElement top_Section;
	
	@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[2]/*/*/*/*/*/*/*")
	public WebElement bottom_Section;
	
	public HashMap<String, WebElement> launchURL(String url){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		driver.get(url);
		if(!isElementPresent(LOCALADS_OVERVIEW)){
			if(driver.findElement(unexp_error).getText().equals("Unexpected Error")){
				hmap.put("error_token", driver.findElement(error_token));
				writeToLogFile("Page did not load successfully & Error Token is--" + driver.findElement(error_token).getText() );
				Assert.assertTrue(isElementPresent(DATE_RANGE));
			}
		}else{
				waitForPageToLoad();
				gotoWebElementByMouse(driver, reports_Nav);
				gotoWebElementByMouse(driver, ypConnectHeader_Nav);
				waitForPageToLoad();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				hmap.put("OVERVIEW", overview_tab);
				hmap.put("LEADS_TAB",  leads_tab);
				hmap.put("CONNECTIONS_TAB", connections_tab);
				hmap.put("TRAFFICBYDISTRIBUTION_TAB", traffic_dist_tab);
			}
		return hmap;
	}
	
	
	public HashMap<String, WebElement> ypConnectOverview(String guestMode){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		
		if(overview_tab.isEnabled()){
			writeToLogFile("Overview Tab for ypConnect is enabled");
		}else{
			overview_tab.click();
		}
		
		if(guestMode.equals("Y")){
			System.out.println("GuestMode is true");
			//Assert.assertEquals((driver.findElement(By.xpath("//*[@id='dvDateRange']/div[3]"))).getAttribute("class"), "blockUI blockOverlay");
			Assert.assertEquals(getAttributeWithWait(guest_DateRange, "class"), "blockUI blockOverlay");
			writeToLogFile("--Date Range is blocked--");
			Assert.assertEquals(getAttributeWithWait(guest_DateRangeText, "text"), "You must be signed in to modify date ranges.");
			writeToLogFile("--Desired text for date range is displayed--");
		}else{
			System.out.println("GuestMode is false");
		}
				
		List<WebElement> top_section = getChildElements(POM_Constants.PARENT_OBJECT_TOP_SECTION ,POM_Constants.CHILD_OBJECT_TOP_SECTION_2, driver);
		hmap = createMapfromObjectList(top_section,hmap, "top_Section");
		List<WebElement> bottom_section = getChildElements(POM_Constants.PARENT_OBJECT_TOP_SECTION ,POM_Constants.CHILD_OBJECT_BOTTOM_SECTION, driver);
		hmap = createMapfromObjectList(bottom_section,hmap, "bottom_Section");
		return hmap;
	}

}
