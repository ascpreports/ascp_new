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

public class ypRealYellowPages extends TestBase{
	
	public ypRealYellowPages(WebDriver dr){
		driver=dr;
		//tb.initConfigurations();
	}
	By LOCALADS_OVERVIEW = By.xpath("//*[@id='dvSubNav']/img");
	By unexp_error = By.xpath("html/body/div[1]/h2");
	By error_token = By.xpath("//*[@id='errorToken']");
	By guest_DateRange = By.xpath("//*[@id='dvDateRange']/div[3]");
	By guest_DateRangeText = By.cssSelector("#dvDRExplanation");
	By guest_Message = By.xpath("//*[@id='abar-body']/div[3]");
	By test_overview1 = By.xpath("//*[@id='dvSubNav']/img");
	
	
	@FindBy(xpath= POM_Constants.REPORTS)
	public WebElement reports_Nav;
	
	@FindBy(xpath= POM_Constants.ypREALYELLOWPAGES_HEADER)
	public WebElement ypRealHeader_Nav;
	
	@FindBy(xpath= POM_Constants.ypREAL_OVERVIEW_TAB)
	public WebElement overview_tab;
	
	@FindBy(xpath= POM_Constants.ypREAL_CALLS_TAB)
	public WebElement calls_tab;
	
	@FindBy(xpath= POM_Constants.ypREAL_PURL_TAB)
	public WebElement purl_tab;
	
	@FindBy(xpath= POM_Constants.ypREAL_OVERVIEW_TEXT)
	public WebElement overview_Text;
	
	@FindBy(xpath= POM_Constants.ypREAL_OVERVIEW_TOPSECTION)
	public WebElement top_Section;
	
	@FindBy(xpath= POM_Constants.ypREAL_OVERVIEW_BOTTOMSECTION)
	public WebElement bottom_Section;
	
	public void navigate_To_ypReal(){

	}
	
	public HashMap<String, WebElement> launchURL(String url){
		
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		driver.get(url);
		waitForPageToLoad();
		if(!isElementPresent(LOCALADS_OVERVIEW)){
			if(driver.findElement(unexp_error).getText().equals("Unexpected Error")){
				hmap.put("error_token", driver.findElement(error_token));
				writeToLogFile("Page did not load successfully & Error Token is--" + driver.findElement(error_token).getText() );
				Assert.assertTrue(isElementPresent(test_overview1));
			}
		}else{
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			gotoWebElementByMouse(driver, reports_Nav);
			gotoWebElementByMouse(driver, ypRealHeader_Nav);
			waitForPageToLoad();
			hmap.put("OVERVIEW", overview_tab);
			hmap.put("CALLs_TAB",  calls_tab);
			hmap.put("Clicks_TAB", purl_tab);
		}


		return hmap;
	}
	
	
	public HashMap<String, WebElement> ypRealOverview(String guestMode){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		
		if(overview_tab.isEnabled()){
			writeToLogFile("Overview Tab for ypREALYELLOWPAGES is enabled");
		}else{
			overview_tab.click();
		}
		
		if(guestMode.equals("Y")){
			System.out.println("GuestMode is true");
			//Assert.assertEquals((driver.findElement(By.xpath("//*[@id='dvDateRange']/div[3]"))).getAttribute("class"), "blockUI blockOverlay");
			Assert.assertEquals(getAttributeWithWait(guest_DateRange, "class"), "blockUI blockOverlay");
			writeToLogFile("--Date Range is blocked--");
			Assert.assertEquals(getAttributeWithWait(guest_DateRangeText, "text"), "You must be signed in to view extended date ranges.");
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
