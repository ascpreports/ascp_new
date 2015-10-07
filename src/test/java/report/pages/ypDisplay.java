package report.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Util.ErrorUtil;
import Util.POM_Constants;

import report.test.TestBase;

public class ypDisplay extends TestBase{
	
	public ypDisplay(WebDriver dr){
		driver=dr;
		//tb.initConfigurations();
	}
	By LOCALADS_OVERVIEW = By.xpath("//*[@id='dvSubNav']/img");
	By unexp_error = By.xpath("html/body/div[1]/h2");
	By error_token = By.xpath("//*[@id='errorToken']");
	By guest_DateRange = By.xpath("//*[@id='dvDateRange']/div[3]");
	By guest_DateRangeText = By.cssSelector("#dvDRExplanation");
	By guest_Message = By.xpath("//*[@id='abar-body']/div[3]");
	
	@FindBy(xpath="html/body/center[1]/h1")
	public WebElement page_load_fail;
	
	@FindBy(xpath= POM_Constants.REPORTS)
	public WebElement reports_Nav;
	
	@FindBy(xpath= "//*[@id='header']/header/div/div/nav/ul[1]/li/ul/li[3]/a")
	public WebElement ypDisplayHeader_Nav;
	
	@FindBy(xpath= "//*[@id='contentContainer']/div[5]/div/span[1]")
	public WebElement campaign_Details;
	
	@FindBy(xpath= "//*[@id='dvCampaignUrl']/a[1]")
	public WebElement campaign_url;
	
	@FindBy(xpath= "//*[@id='dvCategories']")
	public WebElement target_category;
	
	@FindBy(xpath= "//*[@id='dvGeographies']")
	public WebElement target_geography;
	
	@FindBy(xpath= "//*[@id='dvYourEmail']/a")
	public WebElement your_email;
	
	@FindBy(xpath="//*[@id='dvSalesEmail']/a")
	public WebElement your_sales_rep_email;
	
	@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[2]")
	public WebElement display_Text;
	
	@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[1]/*/*/*/*/*/*")
	public WebElement top_Section;
	
	@FindBy(xpath= "//*[@id='contentContainer']/form/div/div[2]/*/*/*/*/*/*")
	public WebElement bottom_Section;
	
	By DATE_RANGE = By.xpath("//*[@id='DisplayDates']");
	
	//Bottom Section
	By INFOSECTION_TEXT = By.xpath("//*[@id='ibar-body']/span");
	By PDF_REPORT = By.xpath("//*[@id='lnkPdf']");
	By TRENDS_IMPRESSIONS = By.xpath("//*[@id='trendByImpressionOn']/div[2]");
	By TRENDS_CLICKS = By.xpath("//*[@id='trendByClicksLink']");
	By TRENDS_CTR = By.xpath("//*[@id='trendByCTRLink']");
	By IMPRESSIONS_PERF = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[1]/td/h3");
	By TOTAL_IMPRESSIONS = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[2]/td[1]/div/div[2]");
	By AVG_IMPRESSIONS = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[2]/td[2]/div/div[2]");
	By AVG_CLICKTHROUGH = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[2]/td[2]/div/div[2]");
	By YOUR_CLICKS_TEXT = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[4]/td/h3");
	By TOTAL_CLICK = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[5]/td[1]/div/div[2]");
	By AVG_CLICKSPM = By.xpath("//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[5]/td[2]/div/div[2]");
			
	
	public HashMap<String, WebElement> launchURL(String url){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		driver.get(url);
		waitForPageToLoad();
		if(!isElementPresent(LOCALADS_OVERVIEW)){
			if(driver.findElement(unexp_error).getText().equals("Unexpected Error")){
			hmap.put("error_token", driver.findElement(error_token));
			writeToLogFile("Page did not load successfully & Error Token is--" + driver.findElement(error_token).getText() );
			Assert.assertTrue(isElementPresent(DATE_RANGE));
			}
		}else{
			gotoWebElementByMouse(driver, reports_Nav);
			gotoWebElementByMouse(driver, ypDisplayHeader_Nav);
			waitForPageToLoad();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			hmap.put("CAMPAIGN_DETAILS_TEXT", campaign_Details);
			hmap.put("CAMPAIGN_URL_TEXT",  campaign_url);
			hmap.put("TARGET_CATEGORY_TEXT", target_category);
			hmap.put("TARGET_GEOGRAPHY_TEXT", target_geography);
			hmap.put("YOUR_EMAIL", your_email);
			hmap.put("YOUR_SALES_REP_EMAIL", your_sales_rep_email);
			hmap.put("DISPLAY_TEXT", display_Text);
		}
		return hmap;
	}
	
	
	public HashMap<WebElement, String> ypDisplayOverview(String guestMode) throws InterruptedException{
		
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
				Assert.assertEquals(getAttributeWithWait(guest_DateRange, "class"), "blockUI blockOverlay");
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
				
		List<WebElement> top_section = getChildElements(POM_Constants.PARENT_OBJECT_TOP_SECTION ,POM_Constants.CHILD_OBJECT_TOP_SECTION_2, driver);
		hmap = createMapfromObjectListNew(top_section,hmap, "top_Section");
		List<WebElement> bottom_section = getChildElements(POM_Constants.PARENT_OBJECT_TOP_SECTION ,POM_Constants.CHILD_OBJECT_BOTTOM_SECTION, driver);
		hmap = createMapfromObjectListNew(bottom_section,hmap, "bottom_Section");
		return hmap;
	}
	
	public int ypDisplayBottomSection(){
		int i=0;
		HashMap<String, By> hmap_bottom = new HashMap<String, By>();
		hmap_bottom.put("pdf_icon", PDF_REPORT);
		hmap_bottom.put("trends_impressions", TRENDS_IMPRESSIONS);
		hmap_bottom.put("trends_clicks", TRENDS_CLICKS);
		hmap_bottom.put("trends_ctr", TRENDS_CTR);
		hmap_bottom.put("imp_perf", IMPRESSIONS_PERF);
		hmap_bottom.put("total_imp", TOTAL_IMPRESSIONS);
		hmap_bottom.put("avg_imp", AVG_IMPRESSIONS);
		hmap_bottom.put("avg_clickthrough", AVG_CLICKTHROUGH);
		hmap_bottom.put("clicks_text", YOUR_CLICKS_TEXT);
		hmap_bottom.put("total_clicks", TOTAL_CLICK);
		hmap_bottom.put("avg_clicks", AVG_CLICKSPM);
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
