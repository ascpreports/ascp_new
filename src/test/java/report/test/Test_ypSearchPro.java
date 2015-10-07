package report.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import report.pages.ypSearchPro;
import Util.ErrorUtil;
import Util.Xls_Reader_Vivek;

public class Test_ypSearchPro extends TestBase{

	
	@BeforeSuite(groups={"Smoke", "Regression"})
	public void initBase(){
		initConfigurations();
	}
	
	  private String url_new;
	  private String guestMode_new;
	  private static String env = app.getProp("env");
	  private static int rowCount_Data;
	  
	    @Factory(dataProvider = "get_url")
	    public Test_ypSearchPro(String url, String guestMode) {
	        this.url_new = url;
	        this.guestMode_new = guestMode;
	    }

	@Test(groups={"Smoke","Regression"})//(dataProvider="get_url")
	public void launchURLTestypSearch(){
		HashMap<String, WebElement> hmap = new HashMap<String, WebElement>();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(!(url_new==null)){
			System.out.println(url_new);
			log.debug("------- Starting Test for Launching URL ypSearchPro--------");
		
		//Instantiate ypSearchPro class object
		ypSearchPro	ypPro = PageFactory.initElements(driver, ypSearchPro.class);
		hmap = ypPro.launchURL(url_new, guestMode_new);
		Iterator<String> keySetIterator = hmap.keySet().iterator(); 
		if(hmap.size()>1){
			isLoggedIn=true;
		
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			try{
				Assert.assertTrue(hmap.get(key).isDisplayed(), key + "-- is displayed");
				log.debug(hmap.get(key).getText() + " ***********is displayed********* ");
			}catch(Throwable t){
				log.debug(t);
				ErrorUtil.addVerificationFailure(t);
			}
		}
		log.debug("---------URL Test------- for ypSearchPro is Complete");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		//ypRealYellowPagesOverviewTest(guestMode);
		}else{
			throw new SkipException("Skipping this exception");
		}
		}
	}	
	@Test(dependsOnMethods="launchURLTestypSearch", groups={"Smoke","Regression"})
	public void ypSearchProOverviewTest() throws InterruptedException{
		HashMap<WebElement, String> hmap_overview = new HashMap<WebElement, String>();
		log.debug("------- Starting Test for ypSearchPro Overview--------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Instantiate ypSearchPro class object
		ypSearchPro	ypPro = PageFactory.initElements(driver, ypSearchPro.class);
		//WebElement overview = ypAds.ypLocalAdsOverview(url);
		hmap_overview = ypPro.ypSearchProOverview(guestMode_new);
		log.debug("-------# OF ELEMENTS COLLECTED IS --"+ hmap_overview.size());
		try{
			Assert.assertEquals(hmap_overview.size(), 2);
		}catch(Throwable t){
			log.debug(t);
			ErrorUtil.addVerificationFailure(t);
		}
		/*Iterator<WebElement> keySetIterator = hmap_overview.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			WebElement key = keySetIterator.next(); 
			//System.out.println("key: " + key + " value: " + hmap_overview.get(key)); 
			 try{
				 
				  Assert.assertTrue(key.isDisplayed());
				  log.debug(key.getText() + " ***********is displayed********* ");
			}catch(Throwable t){
				  log.debug(t);
				  ErrorUtil.addVerificationFailure(t);
			}
		}*/
		log.debug("---------Overview Test is complete------------ for yConnect");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		log.debug("****************************");
		//ypLocalAdsCallsTest();
	}
	
	@Test(dependsOnMethods="ypSearchProOverviewTest", groups={"Regression"})
	public void ypSearchProTopSectionTest(){
		log.debug("------- Starting Test for ypSearch Top Section--------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ypSearchPro	ypPro = PageFactory.initElements(driver, ypSearchPro.class);
		int i = ypPro.ypSearchProTopSection();
		try{
			Assert.assertEquals(i, 7, "This is assertion result for Top Section --");
			//log.debug(" All elements in top section are validated");
		}catch(Throwable e){
			log.debug(e);
			ErrorUtil.addVerificationFailure(e);
		}
	}
	@Test(dependsOnMethods="ypSearchProOverviewTest", groups={"Regression"})
	public void ypSearchProBottomSectionTest(){
		log.debug("------- Starting Test for ypSearch Bottom Section--------");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ypSearchPro	ypPro = PageFactory.initElements(driver, ypSearchPro.class);
		int i = ypPro.ypSearchProBottomSection();
		try{
			Assert.assertEquals(i, 12, "This is assertion result for Bottom Section --");
			//log.debug(" All elements in bottom section are validated");
		}catch(Throwable t){
			log.debug(t);
			ErrorUtil.addVerificationFailure(t);
		}
	}

	
	@DataProvider
	public static Object[][] get_url(){
		Xls_Reader_Vivek xls = new Xls_Reader_Vivek(System.getProperty("user.dir") +"\\src\\test\\java\\data\\TestCases.xlsx");
		System.out.println(xls.path);
		String sheetName = "ypSearchPro" + "_" + env;
		System.out.println(sheetName);
		int obj_rowcount = 0;
		for(int rowNum1=2;rowNum1<=xls.getRowCount(sheetName);rowNum1++){
			if(xls.getCellData(sheetName,"Runmode",rowNum1).equals("Y")){
				obj_rowcount++;
			}
		}	
		rowCount_Data = xls.getRowCount(sheetName);
		Object data[][] = new Object[obj_rowcount][2];
		for(int rowNum=2;rowNum<=xls.getRowCount(sheetName);rowNum++){
			if(xls.getCellData(sheetName,"Runmode",rowNum).equals("Y")){
				String guestMode = xls.getCellData(sheetName,"GuestMode",rowNum);
				String url = xls.getCellData(sheetName, "Url", rowNum);
				data[obj_rowcount-1][0]=url;
				data[obj_rowcount-1][1]=guestMode;
				obj_rowcount++;
			
			}
		}
		//data[0][0] = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=48Hoh21ehUXlIUmN0AIm0UkX8REPa_D-cYGSnqlaXeCkarOiOsAdjn6nr9I-hhO1p8";
		//data[0][1] = "Y";
		//data[1][0] = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=24Hoh21ehUXlLq0sbGBy_AULq5zIxM9dfn";
		//data[1][1] = "N";

		return data;
		
	}
	
	/*@Test
	public void startExecution(){
		//create an object of the xls reader class.
		System.out.println(System.getProperty("user.dir"));
		Xls_Reader_Vivek xls = new Xls_Reader_Vivek(System.getProperty("user.dir") +"\\src\\test\\java\\data\\TestCases.xlsx");
		System.out.println(xls.path);
		System.out.println(app.getProp("env"));
		String sheetName = "ypRealYellowPages" + "_" + app.getProp("env");
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
	}
	*/

		
}
