package report.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import report.test.TestBase;

import Util.ErrorUtil;
import Util.POM_Constants;
import Util.POM_Keywords;

public class ypLocalAds extends TestBase {
	
	
	public WebDriver driver;
	
	public ypLocalAds(WebDriver dr){
		driver=dr;
		//tb.initConfigurations();
	}
	By LOCALADS_OVERVIEW = By.xpath("//*[@id='dvSubNav']/img");
	By unexp_error = By.xpath("html/body/div[1]/h2");
	By error_token = By.xpath("//*[@id='errorToken']");
	//By test_overview = By.id("dvSubNav");
	By test_overview1 = By.xpath("//*[@id='dvSubNav']/img");
	//@FindBy(id = "dvSubNav")
	//public WebElement test_overviewBy;
	
	@FindBy(xpath= POM_Constants.OVERVIEW_IMAGE)
	public WebElement overview;
	
	By call_Tab = By.xpath(POM_Constants.CALL_TAB);
	@FindBy(xpath= POM_Constants.CALL_TAB)
	public WebElement call_tab;
	
	@FindBy(xpath= POM_Constants.CLICKS_TAB)
	public WebElement clicks_tab;
	
	@FindBy(xpath= POM_Constants.IMPRESSIONS_TAB)
	public WebElement Impressions_Tab;
	
	@FindBy(xpath= POM_Constants.ypVideo_360_TAB)
	public WebElement ypvideo;
	By ypVideo_New = By.xpath("//*[@id='dvSubNav']/a[4]/img");

	@FindBy(xpath= POM_Constants.REPORTS)
	public WebElement Reports;
	
	//top Section Objects--------
	By SNAPSHOT_CALLS_SECTION = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[1]/td/div[1]/a");
	By SNAPSHOT_CLICKS_SECTION = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[4]/td/div[1]/a");
	By SNAPSHOT_IMPRESSIONS_SECTION = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[7]/td/div[1]/a");
	By SNAPSHOT_YPVIDEO_SECTION = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[10]/td/div[1]/a");
	By YOUR_OVERVIEW_TEXT = By.xpath("//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[1]");
	By PARENT_OBJECT_TOP_SECTION = By.xpath("//*[@id='contentContainer']");
	By CHILD_OBJECT_TOP_SECTION_1 = By.xpath("//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/*/*");
	By CHILD_OBJECT_TOP_SECTION_2 =By.xpath("//*[@id='contentContainer']/form/div/div[1]/*/*/*/*/*/*");
	By CHILD_OBJECT_BOTTOM_SECTION = By.xpath("//*[@id='contentContainer']/form/div/div[2]/*/*/*/*/*/*/*");
	By LISTING_DROPLIST_HEADER = By.xpath("//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[2]/div/div/div[1]");
	By LISTING_DROPLIST = By.xpath("//*[@id='FilterDDL']");
	By LISTING_DROPLIST_GUEST = By.xpath("//*[@id='selectedListing']/span");
	By guest_DateRange = By.xpath("//*[@id='dvDateRange']/div[3]");
	By guest_DateRangeText = By.cssSelector("#dvDRExplanation");
	By DATE_RANGE_HEADER = By.xpath("//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[2]/div/div/div[4]");
	By DISPLAY_DATES = By.xpath("//*[@id='DisplayDates']");
	By GO_BUTTON = By.xpath("//*[@id='btnSubmit']");
	By LIST_DATE_INFO_TEXT = By.xpath("//*[@id='ibar-body']/span");
	By TOTAL_CALLS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[2]/td[1]/div/div[2]");
	By AVG_CALLS_PER_MONTH = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[2]/td[2]/div/div[2]");
	By CALLS_LAST_30_DAYS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[2]/td[3]/div/div[2]");
	By TOTAL_CLICKS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[5]/td[1]/div/div[2]");
	By AVG_CLICKS_PER_MONTH = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[5]/td[2]/div/div[2]");
	By CLICKS_LAST_30_DAYS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[5]/td[3]/div/div[2]");
	By TOTAL_IMPRESSIONS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[8]/td[1]/div/div[2]");
	By AVG_IMP_PER_MONTH = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[8]/td[2]/div/div[2]");
	By IMP_LAST_30_DAYS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[8]/td[3]/div/div[2]");
	By TOTAL_VISITS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[11]/td[1]/div/div[2]");
	By AVG_VISITS_PER_MONTH = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[11]/td[2]/div/div[2]");
	By VISITS_LAST_30_DAYS = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[11]/td[3]/div/div[2]");
	By YP_VIDEO_360_TEXT = By.xpath("//*[@id='ibar']/div[5]/table/tbody/tr[10]/td/div[4]");
	By PDF_REPORT = By.xpath("//*[@id='lnkPdf']");
	
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
			hmap.put("OVERVIEW", overview);
			hmap.put("CALLs_TAB",  call_tab);
			hmap.put("Clicks_TAB",clicks_tab);
			hmap.put("Impressions_TAB", Impressions_Tab);
			System.out.println();
			
			/*if(isElementPresent(ypVideo_New)){
				hmap.put("ypVideo_TAB",driver.findElement(ypVideo_New));
			}	*/		
		}
		return hmap;
	}
	
	public HashMap<String, WebElement> ypLocalAdsOverview(String guestMode){

		if(isElementPresent(test_overview1)){
			overview.click();
			System.out.println("overview is clicked");
			waitForPageToLoad();
		}
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		
		if(guestMode.equals("Y")){
			System.out.println("GuestMode is true");
			Assert.assertTrue(driver.findElement(LISTING_DROPLIST_GUEST).isEnabled());
			Assert.assertEquals((driver.findElement(By.xpath("//*[@id='dvDateRange']/div[3]"))).getAttribute("class"), "blockUI blockOverlay");
			//Assert.assertEquals(getAttributeWithWait(guest_DateRange, "class"), "blockUI blockOverlay");
			writeToLogFile("--Date Range is blocked--");
			Assert.assertEquals(getAttributeWithWait(guest_DateRangeText, "text"), "You must be signed in to view extended date ranges.");
			writeToLogFile("--Desired text for date range is displayed--");
		}else{
			System.out.println("GuestMode is false");
		}
				
		List<WebElement> top_section = getChildElements(POM_Constants.PARENT_OBJECT_TOP_SECTION ,POM_Constants.CHILD_OBJECT_TOP_SECTION_2, driver);
		hmap = createMapfromObjectList(top_section,hmap, "Top_Section");
		List<WebElement> bottom_section = getChildElements(POM_Constants.PARENT_OBJECT_TOP_SECTION ,POM_Constants.CHILD_OBJECT_BOTTOM_SECTION, driver);
		hmap = createMapfromObjectList(bottom_section,hmap, "Bottom_Section");
		return hmap;
	}
	
	public int ypAdsTopSection(String guestMode){
		int i=0;
		HashMap<String, By> hmap_bottom = new HashMap<String, By>();
		hmap_bottom.put("yourOverview", YOUR_OVERVIEW_TEXT);
		hmap_bottom.put("overview_text", LISTING_DROPLIST_HEADER);
		if(!guestMode.equals("Y")){
			try{
				Assert.assertTrue(driver.findElement(LISTING_DROPLIST).isEnabled());
				hmap_bottom.put("campaign_select", LISTING_DROPLIST);
				Assert.assertTrue(driver.findElement(DISPLAY_DATES).isEnabled());
				hmap_bottom.put("go_btn", DISPLAY_DATES);
								
			}catch(Throwable t){
				writeToLogFile(t.getMessage());
				ErrorUtil.addVerificationFailure(t);
			}
		}
		hmap_bottom.put("adgroups_select", DATE_RANGE_HEADER);
		hmap_bottom.put("pdg_icon", PDF_REPORT);
		//String campaign_value = new Select(driver.findElement(CAMPAIGN_SELECTLIST)).getFirstSelectedOption().getText();
		
		Iterator<String> keySetIterator = hmap_bottom.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			try{
				Assert.assertTrue(isElementPresentWithWait(hmap_bottom.get(key),10));
				System.out.println();
				i++;
			}catch(Throwable t){
				writeToLogFile(t.getMessage());
				ErrorUtil.addVerificationFailure(t);
			}
		}
		
		return i;
	}


/*	public int ypSearchProBottomSection(){
		int i=0;
		HashMap<String, By> hmap_bottom = new HashMap<String, By>();
		hmap_bottom.put("info", INFOSECTION_TEXT);
		hmap_bottom.put("summary_header", SUMMARY_YPSEARCH);
		hmap_bottom.put("ypSearch_graph", YPSEARCH_GRAPH);
		hmap_bottom.put("perf_table_heading", PERF_TABLE_HEAD);
		hmap_bottom.put("budget_val", BUDGETSPENT_VALUE);
		hmap_bottom.put("imp_val", IMPRESSIONS_VALUE);
		hmap_bottom.put("clicks_val", CLICKS_VALUE);
		hmap_bottom.put("clicks_rate_val", CLICK_THROUGHRATE_VALUE);
		hmap_bottom.put("clicks_vs_imp", CLICK_VS_IMP);
		hmap_bottom.put("clicks_imp_graph", CLICKS_IMP_GRAPH);
		hmap_bottom.put("keyword_table", KEYWORD_SNAPSHOT_TABLE);
		hmap_bottom.put("ads_table", ADS_TABLE);
		Iterator<String> keySetIterator = hmap_bottom.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			try{
				Assert.assertTrue(isElementPresentWithWait(hmap_bottom.get(key),15));
				i++;
			}catch(Throwable t){
				writeToLogFile(t.getMessage());
				ErrorUtil.addVerificationFailure(t);
			}
		}
		

		return i;
	}*/
	
	
}
