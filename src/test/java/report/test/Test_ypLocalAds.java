package report.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import report.pages.ypLocalAds;
import report.pages.ypWebsites;

import Util.ErrorUtil;
import Util.POM_Constants;
import Util.SendMail;
import Util.TestUtil;
import Util.Xls_Reader_Vivek;

public class Test_ypLocalAds extends TestBase{
	//Logger log=TestUtil.initLogging(this.getClass());
			

	@BeforeSuite(groups={"Smoke", "Regression"})
	public void initBase(){
		initConfigurations();
	}
	
	  private String url_new;
	  private String guestMode_new;
	  private static String env = app.getProp("env");
	  private static int rowCount_Data;
	  
	    @Factory(dataProvider = "get_url")
	    public Test_ypLocalAds(String url, String guestMode) {
	        this.url_new = url;
	        this.guestMode_new = guestMode;
	    }

	
	/*@Test
	public void startExecution(){
		//create an object of the xls reader class.
		System.out.println(System.getProperty("user.dir"));
		Xls_Reader_Vivek xls = new Xls_Reader_Vivek(System.getProperty("user.dir") +"\\src\\test\\java\\data\\TestCases.xlsx");
		System.out.println(xls.path);
		System.out.println(app.getProp("env"));
		String sheetName = "ypLocalAds" + "_" + app.getProp("env");
		System.out.println(sheetName);
		for(int rowNum=2;rowNum<=xls.getRowCount(sheetName);rowNum++){
			System.out.println(xls.getRowCount(sheetName));
			if(xls.getCellData(sheetName,"Runmode",rowNum).equals("Y")){
				String guestMode = xls.getCellData(sheetName,"GuestMode",rowNum);
				System.out.println(xls.getCellData(sheetName, "TCID", rowNum));
				String url = xls.getCellData(sheetName, "Url", rowNum);
				System.out.println(url);
				launchURLTest(url, guestMode);
			}else{
				//throw new SkipException("Skipping this exception--" + xls.getCellData("ypLocalAds", "TCID", rowNum) );
				System.out.println("Skipping the test-- " +  xls.getCellData("ypLocalAds", "TCID", rowNum));
				log.debug("Skipping the test-- " +  xls.getCellData("ypLocalAds", "TCID", rowNum));
			}
		}
	}*/

	@Test(groups={"Smoke","Regression"})//(dataProvider="get_url")
	public void launchURLTestypLocal(){
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(!(url_new==null)){
			System.out.println(url_new);
			log.debug(url_new);
			log.debug("------- Starting Test for Launching URL --------");

		//Instantiate ypLocalAds class object
		ypLocalAds ypAds = PageFactory.initElements(driver, ypLocalAds.class);
		hmap = ypAds.launchURL(url_new);
		Iterator<String> keySetIterator = hmap.keySet().iterator(); 
		if(hmap.size()>0){
			isLoggedIn=true;
		}
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			try{
				Assert.assertTrue(hmap.get(key).isDisplayed(), key + "-- is displayed");
				log.debug(key + " ***********is displayed********* ");
			}catch(Throwable t){
				log.debug(t);
				ErrorUtil.addVerificationFailure(t);
			}
		}
		log.debug("---------URL Test------- for ypLocalAds is Complete");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		//ypLocalAdsOverviewTest(guestMode_new);
		}else{
			throw new SkipException("Skipping this exception");
		}
	}	
		
	
	@Test(dependsOnMethods="launchURLTestypLocal", groups={"Smoke","Regression"})
	public void ypLocalAdsOverviewTest(){
		HashMap<String, WebElement> hmap_overview = new HashMap<String, WebElement>();
		log.debug("------- Starting Test of ypLocalAds Overview--------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug(url_new);
		//Instantiate LoginPage class object
		ypLocalAds ypAds = PageFactory.initElements(driver, ypLocalAds.class);
		//WebElement overview = ypAds.ypLocalAdsOverview(url);
		hmap_overview = ypAds.ypLocalAdsOverview(guestMode_new);
		log.debug("size of map is +++++++++++"+ hmap_overview.size());
		Iterator<String> keySetIterator = hmap_overview.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			//System.out.println("key: " + key + " value: " + hmap_overview.get(key)); 
			 try{
				  Assert.assertTrue(hmap_overview.get(key).isDisplayed(), key + "-- is displayed");
				  log.debug(key + " ***********is displayed********* ");
			}catch(Throwable t){
				  log.debug(t);
				  ErrorUtil.addVerificationFailure(t);
			}
		}
		log.debug("---------Overview Test is complete------------ for ypLocalAds");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		//ypLocalAdsCallsTest();
	}

	@Test(dependsOnMethods="ypLocalAdsOverviewTest", groups={"Regression"})
	public void ypLocalAdsTopSectionTest(){
		log.debug("------- Starting Test for ypLocalAds Top Section--------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ypLocalAds ypAds = PageFactory.initElements(driver, ypLocalAds.class);
		log.debug(url_new);
		int i = ypAds.ypAdsTopSection(guestMode_new);
		try{
			if(guestMode_new.equals("Y")){
				Assert.assertEquals(i, 4, "All Assertions are met and elements are displayed");
			}else{
				Assert.assertEquals(i, 6, "All Assertions are met and elements are displayed");
			}
			
			log.debug(" All elements in Top section are validated");
		}catch(Throwable t){
			log.debug(t);
			ErrorUtil.addVerificationFailure(t);
		}
	}
	/*
	@Test(dependsOnMethods="ypWebsitesOverviewTest", groups={"Regression"})
	public void ypWebsitesBottomSectionTest(){
		log.debug("------- Starting Test for ypDisplay Overview--------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug(url_new);
		ypWebsites ypWeb = PageFactory.initElements(driver, ypWebsites.class);
		int i = ypWeb.ypWebsitesBottomSection();
		try{
			Assert.assertEquals(i, 11, "All Assertions are met and elements are displayed");
			log.debug(" All elements in bottom section are validated");
		}catch(Throwable t){
			log.debug(t);
			ErrorUtil.addVerificationFailure(t);
		}
	}
		
	@Test(dependsOnMethods="ypLocalAdsOverviewTest", groups={"Regression"})
	public void ypLocalAdsCallsTest(){
		if(!isLoggedIn){
			log.debug("---------- User is not logged in-----------------");
			log.debug(url_new);
			ypAds = PageFactory.initElements(driver, ypLocalAds.class);
			//ctnLandPage = lp.doLogin(app.getProp("uname"),app.getProp("password"));
		}else{
			log.debug("user is logged in");
			//ctnLandPage = getTopMenu().gotoCTNLandingPage();
		}
	}
	*/
	@DataProvider
	public static Object[][] get_url(){
		Xls_Reader_Vivek xls = new Xls_Reader_Vivek(System.getProperty("user.dir") +"\\src\\test\\java\\data\\TestCases.xlsx");
		System.out.println(xls.path);
		
		String sheetName = "ypLocalAds" + "_" + env;
		System.out.println(sheetName);
		int obj_rowcount = 0;
		for(int rowNum1=2;rowNum1<=xls.getRowCount(sheetName);rowNum1++){
			if(xls.getCellData(sheetName,"Runmode",rowNum1).equals("Y")){
				obj_rowcount++;
			}
		}
		rowCount_Data = xls.getRowCount(sheetName);
		Object data[][] = new Object[obj_rowcount][2];
		obj_rowcount=0;
		for(int rowNum=2;rowNum<=xls.getRowCount(sheetName);rowNum++){
			if(xls.getCellData(sheetName,"Runmode",rowNum).equals("Y")){
				String guestMode = xls.getCellData(sheetName,"GuestMode",rowNum);
				String url = xls.getCellData(sheetName, "Url", rowNum);
				data[obj_rowcount][0]=url;
				data[obj_rowcount][1]=guestMode;
				obj_rowcount++;
			}
		}
		//data[0][0] = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=48Hoh21ehUXlIUmN0AIm0UkX8REPa_D-cYGSnqlaXeCkarOiOsAdjn6nr9I-hhO1p8";
		//data[0][1] = "Y";
		//data[1][0] = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=24Hoh21ehUXlLq0sbGBy_AULq5zIxM9dfn";
		//data[1][1] = "N";

		return data;
		
	}

	
}
