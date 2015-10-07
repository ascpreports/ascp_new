package report.test;

import java.util.List;
import java.util.Map;
 
 
public final class ApplicationConfig {
     
    private String applicationName;
    private String guestMode;
    private String runMode;
    private int poolSize;
    private Map< String, String > backendProxyURLs; 
    private List<Map< String, String >> myList;
     
     
     
    public Map<String, String> getBackendProxyURLs() {
        return backendProxyURLs;
    }
 
    public void setBackendProxyURLs(Map<String, String> backendProxyURLs) {
        this.backendProxyURLs = backendProxyURLs;
        
    }
    public List<Map< String, String >> getMyList(){
    	return myList;
    }
 
    public void setMyList(List<Map< String, String >> myList){
    	this.myList = myList;
    }
    public String getApplicationName() {
        return applicationName;
    }
 
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    
    public String getRunMode() {
        return runMode;
    }
 
    public void setRunMode(String runMode) {
        this.runMode = runMode;
    }
    
    public String getGuestMode() {
        return guestMode;
    }
 
    public void setGuestMode(String guestMode) {
        this.guestMode = guestMode;
    }
    
 
  
/*    public int getPoolSize() {
        return poolSize;
    }
 
    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
  
   public List< String > getProtocols() {
        return protocols;
    }
 
    public void setProtocols(List< String > protocols) {
        this.protocols = protocols;
    }*/
 
    @Override
    public String toString() {
       // return "ApplicationConfig [applicationName=" + applicationName + ", poolSize=" + poolSize
               // + ", backendProxyURLs=" + backendProxyURLs + ", protocols=" + protocols + "]";
    	
    	return ("[" + applicationName + "," + runMode + ","+guestMode+ backendProxyURLs+ myList+ "]");
    }
 
     
   
}