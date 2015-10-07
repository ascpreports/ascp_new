package Util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.testng.ConversionUtils;

public class TestUtil {
	public static boolean isExecutable(String testName, Xls_Reader_Vivek xls) {
		
		for(int rowNum=2;rowNum<=xls.getRowCount("TestCases");rowNum++){
			if(xls.getCellData("TestCases", "TCID", rowNum).equals(testName)){
				if(xls.getCellData("TestCases", "TCID", rowNum).equals("Y"))
					return true;
				else
					return false;
			}
		}
	
		return false;
	}
	
	public static Logger initLogging(Class clazz){
		// configure the appender here, with file location, etc
		FileAppender appender = new FileAppender();
		appender.setFile("c:\\temp\\ASCP_Results\\Logs"+clazz.getName()+".log");//check the path of the logs
		appender.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		appender.setAppend(false);
	    appender.activateOptions();
	   
	    Logger APPLICATION_LOG=Logger.getLogger(clazz.getName());
	    APPLICATION_LOG.setLevel(Level.DEBUG);
	    APPLICATION_LOG.addAppender(appender);
	    
	    return APPLICATION_LOG;
	
	
	
	}

}
