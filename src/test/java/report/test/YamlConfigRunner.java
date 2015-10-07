package report.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.esotericsoftware.yamlbeans.YamlReader;
 
public class YamlConfigRunner {
    public static void main(String[] args) throws IOException {
   
        try {
            YamlReader yamlReader = new YamlReader(new FileReader("C:\\Users\\VA4652\\Automation\\ascp-reports\\src\\test\\java\\Util\\complexYaml.yml"));
            yamlReader.getConfig().setClassTag("MyConfiguration", MyConfiguration.class);
            yamlReader.getConfig().setClassTag("ApplicationConfig", ApplicationConfig.class);
             
            MyConfiguration myConfiguration = yamlReader.read(MyConfiguration.class);
            System.out.println(myConfiguration.getApplicationConfigs().size());
            System.out.println(myConfiguration.getApplicationConfigs().toString());
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getApplicationName());
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getGuestMode());
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getRunMode());
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getBackendProxyURLs().get("service3"));
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getBackendProxyURLs().size());
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getMyList().get(1).toString());
            System.out.println(myConfiguration.getApplicationConfigs().get(1).getMyList().get(1).get("url2"));
            //ApplicationConfig appConfig = yamlReader.read(ApplicationConfig.class);
           // System.out.println(appConfig.getApplicationName());
            		//
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
