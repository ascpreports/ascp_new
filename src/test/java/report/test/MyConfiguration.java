package report.test;

import static java.lang.String.format;

import java.util.Date;
import java.util.List;
 
public final class MyConfiguration { 
    private Date released;
    private String version;
    private List<ApplicationConfig> applicationConfigs;  
     
    ApplicationConfig appConfig = new ApplicationConfig();
    /**
     * @return the applicationConfigs
     */
    public List<ApplicationConfig> getApplicationConfigs() {
        return applicationConfigs;
    }
 
    /**
     * @param applicationConfigs the applicationConfigs to set
     */
    public void setApplicationConfigs(List<ApplicationConfig> applicationConfigs) {
        this.applicationConfigs = applicationConfigs;
    }
    
    public String getApplicationName1(){
    	String ApplicationName = appConfig.getApplicationName();
		return ApplicationName;
    	
    }
 
    public Date getReleased() {
        return released;
    }
 
    public String getVersion() {
        return version;
    }
  
    public void setReleased(Date released) {
        this.released = released;
    }
  
    public void setVersion(String version) {
        this.version = version;
    }
  
  
    @Override
    public String toString() {
        return new StringBuilder()
            .append( format( "Version: %s\n", version ) )
            .append( format( "Released: %s\n", released ) )
            .toString();
    }
}
