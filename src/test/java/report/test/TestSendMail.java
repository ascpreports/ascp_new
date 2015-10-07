package report.test;

import org.testng.annotations.AfterSuite;

import Util.SendMail;

public class TestSendMail {
	
	  @AfterSuite(groups={"Smoke", "Regression"})
	  public void sendMail() throws Exception{
		  SendMail.execute("emailable-report.html");
	  }
	

}
