package Util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POM_Constants {
	//POM Xpath's for Call Cloud
	
		//File Path
		public static final String PROPERTIES_FILE_PATH=System.getProperty("user.dir")+"/src/test/java/Util/config.properties";
		public static final String SCREENSHOT_PATH=System.getProperty("user.dir")+"/ExecutionInfo/Screenshots"; 
		
		//---------------ypLocalAds-------------------------
		public static final String YP_LOCAL_ADS_BASE_URL_1 = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=24Hoh21ehUXlLq0sbGBy_AULq5zIxM9dfn ";
		public static final String YP_LOCAL_ADS_BASE_URL_2 = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=24Hoh21ehUXlLq0sbGBy_AULq5zIxM9dfn ";
			//---------ypLocalAds OVERVIEW TAB Objects xpath------------
			public static final String OVERVIEW_IMAGE = "//*[@id='dvSubNav']/img";
			public static final String CALL_TAB = "//*[@id='dvSubNav']/a[1]/img";
			public static final String CLICKS_TAB="//*[@id='dvSubNav']/a[2]/img";
			public static final String IMPRESSIONS_TAB = "//*[@id='dvSubNav']/a[3]/img";
			public static final String ypVideo_360_TAB = "//*[@id='dvSubNav']/a[4]/img";
			public static final String SNAPSHOT_CALLS_SECTION = "//*[@id='ibar']/div[5]/table/tbody/tr[1]/td/div[1]/a";
			public static final String SNAPSHOT_CLICKS_SECTION = "//*[@id='ibar']/div[5]/table/tbody/tr[4]/td/div[1]/a";
			public static final String SNAPSHOT_IMPRESSIONS_SECTION = "//*[@id='ibar']/div[5]/table/tbody/tr[7]/td/div[1]/a";
			public static final String SNAPSHOT_YPVIDEO_SECTION = "//*[@id='ibar']/div[5]/table/tbody/tr[10]/td/div[1]/a";
			public static final String YOUR_OVERVIEW_TEXT = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[1]";
			public static final String PARENT_OBJECT_TOP_SECTION = "//*[@id='contentContainer']";
			public static final String CHILD_OBJECT_TOP_SECTION_1 = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/*/*";
			public static final String CHILD_OBJECT_TOP_SECTION_2 ="//*[@id='contentContainer']/form/div/div[1]/*/*/*/*/*/*";
			public static final String CHILD_OBJECT_BOTTOM_SECTION = "//*[@id='contentContainer']/form/div/div[2]/*/*/*/*/*/*/*";
			public static final String LISTING_DROPLIST_HEADER = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[2]/div/div/div[1]";
			public static final String LISTING_DROPLIST = "//*[@id='FilterDDL']/div";
			public static final String DATE_RANGE_TEXT = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[2]/div/div/div[4]";
			public static final String DISPLAY_DATES = "//*[@id='DisplayDates']";
			public static final String GO_BUTTON = "//*[@id='btnSubmit']";
			public static final String LIST_DATE_INFO_TEXT = "//*[@id='ibar-body']/span";
			public static final String TOTAL_CALLS = "//*[@id='ibar']/div[5]/table/tbody/tr[2]/td[1]/div/div[2]";
			public static final String AVG_CALLS_PER_MONTH = "//*[@id='ibar']/div[5]/table/tbody/tr[2]/td[2]/div/div[2]";
			public static final String CALLS_LAST_30_DAYS = "//*[@id='ibar']/div[5]/table/tbody/tr[2]/td[3]/div/div[2]";
			public static final String TOTAL_CLICKS = "//*[@id='ibar']/div[5]/table/tbody/tr[5]/td[1]/div/div[2]";
			public static final String AVG_CLICKS_PER_MONTH = "//*[@id='ibar']/div[5]/table/tbody/tr[5]/td[2]/div/div[2]";
			public static final String CLICKS_LAST_30_DAYS = "//*[@id='ibar']/div[5]/table/tbody/tr[5]/td[3]/div/div[2]";
			public static final String TOTAL_IMPRESSIONS = "//*[@id='ibar']/div[5]/table/tbody/tr[8]/td[1]/div/div[2]";
			public static final String AVG_IMP_PER_MONTH = "//*[@id='ibar']/div[5]/table/tbody/tr[8]/td[2]/div/div[2]";
			public static final String IMP_LAST_30_DAYS = "//*[@id='ibar']/div[5]/table/tbody/tr[8]/td[3]/div/div[2]";
			public static final String TOTAL_VISITS = "//*[@id='ibar']/div[5]/table/tbody/tr[11]/td[1]/div/div[2]";
			public static final String AVG_VISITS_PER_MONTH = "//*[@id='ibar']/div[5]/table/tbody/tr[11]/td[2]/div/div[2]";
			public static final String VISITS_LAST_30_DAYS = "//*[@id='ibar']/div[5]/table/tbody/tr[11]/td[3]/div/div[2]";
			public static final String YP_VIDEO_360_TEXT = "//*[@id='ibar']/div[5]/table/tbody/tr[10]/td/div[4]";
			public static final String PDF_REPORT = "//*[@id='lnkPdf']";
			
			//--------------------CALLS TAB OBJECTS--------------------------------------------------------------
			public static final String FILTER_BY_CTN_HEADER = "//*[@id='dvEditFilters']/div[1]";
			public static final String FILTER_BY_CTN_LINK = "//*[@id='lnkFilterCTNs']";
			public static final String EXCEL_REPORT = "//*[@id='lnkExcelExport']";
			public static final String CALL_CHART = "//*[@id='highcharts-8']/svg/rect";
			public static final String VIEW_CALL_TRENDS_TEXT = "//*[@id='ibar']/div[5]/div[1]/div[1]";
			public static final String YOUR_CALL_SUMMARY = "//*[@id='ibar']/div[5]/div[3]/div";
			public static final String TOTAL_CALLS_CALLS_TAB = "//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[1]/td[1]/div/div[2]";
			public static final String CALLS_30_DAYS = "//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[1]/td[2]/div/div[2]";
			public static final String ANSWERED_CALLS = "//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[1]/td[2]/div/div[2]";
			public static final String PERCENT_ANS_CALLS = "//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[3]/td[1]/div/div[2]";
			public static final String CALLS_AVG_LENGTH = "//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[3]/td[2]/div/div[2]";
			public static final String AVG_CALLS_PM = "//*[@id='ibar']/div[5]/div[3]/table/tbody/tr[3]/td[3]/div/div[2]";
			public static final String CALLS_BY_CATEGORY_GRAPH_TEXT = "//*[@id='ibar']/div[5]/div[5]/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/div[1]";
			public static final String CALLS_BY_CATEGORY_GRAPH = "//*[@id='highcharts-10']/svg/rect";
			public static final String CALLS_BY_GEOGRAPHY_TEXT = "//*[@id='ibar']/div[5]/div[5]/table/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/div[1]";
			public static final String CALLS_BY_GEOGRAPHY_GRAPH = "//*[@id='highcharts-2']/svg/rect";
			public static final String VIEW_RECVD_CALLS = "//*[@id='ibar']/div[5]/div[7]";
			public static final String VIEW_CALLER_GOOGLE_MAP = "//*[@id='ibar']/div[5]/div[8]";
			public static final String YOUR_CALLS_HEADER = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[1]";
			public static final String YOUR_CALLS_TEXT = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[2]";

			
			//-------------------CLICKS TAB OBJECTS--------------------------------------------------------------
			public static final String YOUR_CLICKS_TEXT = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[2]";
			public static final String YOUR_CLICKS = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[1]";
			public static final String SELECT_PRODUCTS = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[2]/div/div[2]/div[7]";
			public static final String LAST_MONTH = "Last Month";
			public static final String LAST_3_MONTHS = "Last 3 Months";
			public static final String LAST_6_MONTHS = "Last 6 Months";
			public static final String LAST_12_MONTHS = "Last 12 Months";
			public static final String LAST_2_YEARS = "Last 2 Years";
			public static final String ALL_PRODUCTS_CHKBOX = "//*[@id='dvSelectProducts']/div[1]/input";
			public static final String VIEW_YOUR_CLICK_TRENDS_TEXT = "//*[@id='ibar']/div[5]/div[1]/div[1]";

			
			
			
			
		//----------------ypRealYellowPages-------------------
		public static final String YP_REAL_YELLOW_PAGES_URL1 = "https://adsolutions.test.yp.com/Account/MagicLogin?magicToken=24Hoh21ehUXlLq0sbGBy_AULq5zIxM9dfn ";
			//----------ypRealYellowPages Objects xpath-------
			public static final String ypREALYELLOWPAGES_HEADER = "//*[@id='header']/header/div/div/nav/ul[1]/li/ul/li[2]/a";
			public static final String REPORTS = "//*[@id='header']/header/div/div/nav/ul[1]/li/a";
			public static final String ypREAL_OVERVIEW_TAB = "//*[@id='dvSubNav']/img";
			public static final String ypREAL_CALLS_TAB = "//*[@id='dvSubNav']/a[1]/img";
			public static final String ypREAL_PURL_TAB = "//*[@id='dvSubNav']/a[2]/img";
			//public static final String ypREAL_OVERVIEW_TOPSECTION1 = "//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/*/*";
			public static final String ypREAL_OVERVIEW_TOPSECTION = "//*[@id='contentContainer']/form/div/div[1]/*/*/*/*/*/*";
			public static final String ypREAL_OVERVIEW_BOTTOMSECTION = "//*[@id='ibar']/*/*/*/*/*/*/*";
			public static final String ypREAL_OVERVIEW_TEXT="//*[@id='contentContainer']/form/div/div[1]/table/tbody/tr/td[1]/div/div[2]";
			
			
			
			
		
		//---------------LoginPage Class Objects Xpath's---------------------
		public static final String LOGIN_USERNAME = "//*[@id='username']";
		public static final String LOGIN_PASSWORD = "//*[@id='password']";
		public static final String POST_LOGIN_USERNAME = "//*[@id='LogOn']/strong";
		public static final String CALLCLOUD_LOGOUT= "html/body/div[2]/div";
		//***************End of Objects for LoginPage Class********************
	
		//-----------------CTNLandingPage Class objects Xpath's---------------------
		//----------------------Tab Elements------------------------------------
		public static final String CTN_TAB="//*[@id='menu-call-tracking-numbers']";
		public static final String USER_TAB ="//*[@id='menu-users']";
		public static final String INVENTORY_TAB ="//*[@id='menu-inventory']";
		public static final String MANAGEMENT_TAB="//*[@id='menu-management']";
		public static final String STATISTICS_TAB="//*[@id='menu-statistics']";
		//***********************End of Tab Elements****************************
		
		//-----------------------Hyperlinks Elements------------------------------
		public static final String CALLCLOUD_SEARCH="//*[@id='LogOn']/a[2]";
		public static final String PROVISION_BUTTON="//*[@id='wrapper']/div[2]/div[3]/div[1]/div[1]/div/span";
		public static final String ADVANCED_SEARCH="//*[@id='wrapper']/div[2]/div[4]/div[1]/div[2]/div/span";
		public static final String EXPORT_TO_XLS="//*[@id='wrapper']/div[2]/div[3]/div[1]/div[3]/div/span";
		public static final String BASIC_SEARCH="//*[@id='search-textbox']";
		public static final String CTN_INVENTORY_CHK="//*[@id='wrapper']/table/tbodtry//td[1]/a";
		public static final String LOCAL_CALLING_GUIDE="//*[@id='wrapper']/table/tbody/tr/td[3]/a";
		public static final String DEMOGRAPHIC_INFO="//*[@id='wrapper']/table/tbody/tr/td[5]/a";
		public static final String CTN="//*[@id='row1']/td[3]/div";
		//************************End of Hyperlink Elements****************************************************
		
		//-----------------------CTN Provision Page------------------------------------------------------------
		
		//-----------------------Existing Constants Re-used----------------------------------------------------
		//-----------------------Browser Type------------------------------------------------------------------
		
		public static final String MOZILLA = "mozilla";
		public static final String CHROME = "chrome";
		public static final String IE = "internet explorer";
		//*****************************************************************************************************
		
		//------------------------Environments-----------------------------------------------------------------
		public static final String TEST = "test";
		public static final String STAGE = "stage";
		//*****************************************************************************************************
		
		//------------------------Assertion values-------------------------------------------------------------
		public static final String PASS = "pass";
		public static final String TRUE = "true";
		//*****************************************************************************************************
		
		//-----------------------Error messages----------------------------------------------------------------
		public static final String OPENBROWSER_ERROR = "ERROR:Failed to open browser";
		public static final String NAVIGATE_ERROR = "ERROR : Failing to navigate";
		public static final String LOCATOR_ERROR = "ERROR: Invalid locator";
		public static final String FIND_ELEMENT_ERROR = "ERROR:Unable to find element";
		public static final String GENERAL_ERROR = "ERROR";
		//******************************************************************************************************
		
		//-----------------------Failure messages---------------------------------------------------------------
		public static final String ELEMENT_NOT_FOUND_FAILURE = "FAIL: element not found";
		public static final String TITLE_MISMATCH_FAILURE = "FAIL: mismatch in title";
		public static final String LOGIN_FAILURE = "FAIL:unable to login with default username/passwrd";
		public static final String CLICKANDWAIT_FAILURE = "FAIL:unable to click and wait";
		//******************************************************************************************************
		
		
}
