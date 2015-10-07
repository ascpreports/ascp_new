package report.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Util.ErrorUtil;
import Util.POM_Constants;

import report.test.TestBase;

public class ypClicks extends TestBase{
	
	public ypClicks(WebDriver dr){
		driver=dr;
		//tb.initConfigurations();
	}
	By unexp_error = By.xpath("html/body/div[1]/h2");
	By error_token = By.xpath("//*[@id='errorToken']");
	By guest_DateRange = By.id("divBlockDateInput");
	By guest_DateRangeText = By.xpath("//*[@id='rptfilter']/div[2]/ol/li[3]/div/div[3]");
	By guest_Message = By.xpath("//*[@id='abar-body']/div[3]");
	//Navigation objects
	@FindBy(xpath="html/body/center[1]/h1")
	public WebElement page_load_fail;
	
	@FindBy(xpath= "//*[@id='header']/header/div/div/nav/ul[1]/li/a")
	public WebElement reports_Nav;
	
	@FindBy(xpath= "//*[@id='header']/header/div/div/nav/ul[1]/li/ul/li[2]/a")
	public WebElement ypClicks_Nav;
	
	//@FindBy(xpath="html/body/div[1]/div/h1")
	//public WebElement page_Title;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/img")
	public WebElement overview_Tab;
	
	@FindBy(xpath= "")
	public WebElement overview_Tab_guest;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/a[1]/img")
	public WebElement traffic_by_dist_Tab;
	
	@FindBy(xpath= "")
	public WebElement traffic_by_dist_Tab_guest;
	
	@FindBy(xpath= "//*[@id='dvSubNav']/a[2]/img")
	public WebElement about_ypClicks_Tab;
	
	@FindBy(xpath= "")
	public WebElement about_ypClicks_Tab_guest;
	
	//Top Section
	By LOCALADS_OVERVIEW = By.xpath("//*[@id='dvSubNav']/img");
	By OVERVIEW_HEADING = By.xpath("//*[@id='rptfilter']/div[1]/h2");
	
	By OVERVIEW_TEXT= By.xpath("//*[@id='rptfilter']/div[1]/p");
	By CAMPAIGN_SELECTLIST = By.xpath("//*[@id='SelectedCampaign']");
	By ADGROUPS_SELECTLIST = By.xpath("//*[@id='SelectedAdGroup']");
	By DATERANGE_SELECTLIST = By.xpath("//*[@id='DisplayDates']");
	By GO_BUTTON = By.xpath("//*[@id='btnSubmit']");
	public final String PARENT_TOP_SECTION = "//*[@id='contentContainer']";
	public final String CHILD_TOP_SECTION = "//*[@id='contentContainer']/form/div/div[1]/*/*/*/*/*/*";
	public final String PARENT_BOTTOM_SECTION = "//*[@id='contentContainer']/form/div/div[2]";
	public final String CHILD_BOTTOM_SECTION = "//*[@id='contentContainer']/form/div/div[2]/*/*/*/*/*/*/*";
	//Bottom Section
	
	//@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[2]/*/*/*/*/*/*")
	//public WebElement bottom_Section;
	
	By INFOSECTION_TEXT = By.xpath("//*[@id='overview']/div[2]/div/div[1]/div");
	By SUMMARY_YPSEARCH = By.xpath("//*[@id='overview']/div[5]/div[1]");
	By PDF_REPORT = By.xpath("//*[@id='lnkPdf']");
	By YPSEARCH_GRAPH = By.xpath("//*[@id='highcharts-0']/svg/g[1]/g[1]/path[1]");
	By PERF_TABLE_HEAD = By.xpath("//*[@id='overview']/div[5]/div[2]/div[2]/table/thead/tr/th");
	By BUDGETSPENT_VALUE = By.xpath("//*[@id='overview']/div[5]/div[2]/div[2]/table/tbody/tr[1]/td[2]/strong");
	By IMPRESSIONS_VALUE = By.xpath("//*[@id='overview']/div[5]/div[2]/div[2]/table/tbody/tr[2]/td[2]/strong");
	By CLICKS_VALUE = By.xpath("//*[@id='overview']/div[5]/div[2]/div[2]/table/tbody/tr[3]/td[2]/strong");
	By CLICK_THROUGHRATE_VALUE = By.xpath("//*[@id='overview']/div[5]/div[2]/div[2]/table/tbody/tr[4]/td[2]/strong");
	By CLICK_VS_IMP= By.xpath("//*[@id='overview']/div[7]/div[1]/div/h2");
	By CLICKS_IMP_GRAPH = By.xpath("//*[@id='highcharts-2']/svg/rect");
	By KEYWORD_SNAPSHOT_TABLE = By.xpath("//*[@id='overview']/div[9]/table");
	By ADS_TABLE = By.xpath("//*[@id='overview']/div[11]/table");
	private WebElement ypSearchProHeader_Nav;
			
	
	public HashMap<String, WebElement> launchURL(String url, String guestMode){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		driver.get(url);
		waitForPageToLoad();
		
		if(!isElementPresent(LOCALADS_OVERVIEW)){
			if(driver.findElement(unexp_error).getText().equals("Unexpected Error")){
				hmap.put("error_token", driver.findElement(error_token));
				writeToLogFile("Page did not load successfully & Error Token is--" + driver.findElement(error_token).getText() );
				Assert.assertTrue(isElementPresent(OVERVIEW_HEADING));
			}
		}else{
			gotoWebElementByMouse(driver, reports_Nav);
			gotoWebElementByMouse(driver, ypClicks_Nav);
			waitForPageToLoad();
			if(guestMode.equals("Y")){
				hmap.put("OVERVIEW_TAB", overview_Tab_guest);
				hmap.put("TRAFFIC_TAB",  traffic_by_dist_Tab_guest);
				hmap.put("YPCLICKS_TAB", about_ypClicks_Tab_guest);
			}else{
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				hmap.put("OVERVIEW_TAB", overview_Tab);
				hmap.put("TRAFFIC_TAB",  traffic_by_dist_Tab);
				hmap.put("YPCLICKS_TAB", about_ypClicks_Tab);
			}


		}
		return hmap;
	}
	
	
	public HashMap<WebElement, String> ypClicksOverview(String guestMode) throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<WebElement, String> hmap = new HashMap<WebElement, String>();
		Thread.sleep(5000);
		/*if(overview_tab.isEnabled()){
			writeToLogFile("Overview Tab for ypConnect is enabled");
		}else{
			overview_tab.click();
		}*/
		
		if(guestMode.equals("Y")){
			System.out.println("GuestMode is true");
			//Assert.assertEquals((driver.findElement(By.xpath("//*[@id='dvDateRange']/div[3]"))).getAttribute("class"), "blockUI blockOverlay");
			try{
				Assert.assertTrue(isElementPresentBy(guest_DateRange, "xpath", 10));
				writeToLogFile("--Date Range is blocked--");
				Assert.assertEquals(getAttributeWithWait(guest_DateRangeText, "text"), "You must be signed in to view extended date ranges.");
				writeToLogFile("--Desired text for date range is displayed--");
			}catch(Throwable t){
				writeToLogFile(t.getMessage());
				ErrorUtil.addVerificationFailure(t);
			}

		}else{
			System.out.println("GuestMode is false");
		}
				
		List<WebElement> top_section = getChildElements(PARENT_TOP_SECTION,CHILD_TOP_SECTION, driver);
		hmap = createMapfromObjectListNew(top_section,hmap, "top_Section");
		List<WebElement> bottom_section = getChildElements(PARENT_BOTTOM_SECTION ,CHILD_BOTTOM_SECTION, driver);
		hmap = createMapfromObjectListNew(bottom_section,hmap, "bottom_Section");
		return hmap;
	}
	
	public int ypClicksTopSection(){
		int i=0;
		HashMap<String, By> hmap_bottom = new HashMap<String, By>();
		hmap_bottom.put("yourOverview", OVERVIEW_HEADING);
		hmap_bottom.put("overview_text", OVERVIEW_TEXT);
		hmap_bottom.put("campaign_select", CAMPAIGN_SELECTLIST);
		hmap_bottom.put("adgroups_select", ADGROUPS_SELECTLIST);
		hmap_bottom.put("date_range", DATERANGE_SELECTLIST);
		hmap_bottom.put("go_btn", GO_BUTTON);
		hmap_bottom.put("pdg_icon", PDF_REPORT);
		try{
			Assert.assertTrue(verifySelectListWithSelectedOption(CAMPAIGN_SELECTLIST, "All Campaigns"));
			Assert.assertTrue(verifySelectListWithSelectedOption(ADGROUPS_SELECTLIST, "All Ad Groups"));
			//Assert.assertTrue(verifySelectListWithSelectedOption(DATERANGE_SELECTLIST, "Last month"));
		}catch(Throwable t){
			writeToLogFile(t.getMessage());
			ErrorUtil.addVerificationFailure(t);
		}
		//String campaign_value = new Select(driver.findElement(CAMPAIGN_SELECTLIST)).getFirstSelectedOption().getText();
		
		Iterator<String> keySetIterator = hmap_bottom.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			try{
				Assert.assertTrue(isElementPresentWithWait(hmap_bottom.get(key),5));
				i++;
			}catch(Throwable t){
				writeToLogFile(t.getMessage());
				ErrorUtil.addVerificationFailure(t);
			}
		}
		
		return i;
	}


	public int ypClicksBottomSection(){
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
		
		/*try{
			Assert.assertTrue(isElementPresentWithWait(PDF_REPORT,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(TRENDS_IMPRESSIONS,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(TRENDS_CLICKS,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(TRENDS_CTR,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(IMPRESSIONS_PERF,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(TOTAL_IMPRESSIONS,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(AVG_IMPRESSIONS,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(AVG_CLICKTHROUGH,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(YOUR_CLICKS_TEXT,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(TOTAL_CLICK,5));
			i++;
			Assert.assertTrue(isElementPresentWithWait(AVG_CLICKSPM,5));
			i++;
		}catch(Throwable t){
			writeToLogFile(t.getMessage());
			ErrorUtil.addVerificationFailure(t);
		}*/
		return i;
	}

}
