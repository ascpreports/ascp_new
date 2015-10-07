package report.test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.lang.*;
import java.io.FileReader;
import java.io.IOException;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import org.openqa.selenium.WebElement;
//import org.testng.internal.Yaml;
import org.yaml.snakeyaml.*;

import report.pages.Contact;
import report.pages.PhoneNumbers;

public class TestYamlDataLoad {
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
	
	final String fileName1 = System.getProperty("user.dir")+"\\src\\test\\java\\util\\sample.yaml";
	final String fileName2 = System.getProperty("user.dir")+"\\src\\test\\java\\util\\sample1.yaml";
	final String fileName3 = System.getProperty("user.dir")+"\\src\\test\\java\\util\\sample3.yml";
	//C:\Users\VA4652\Automation\ascp-reports\src\test\java\Util\sample.yaml
	Yaml yaml1= new Yaml();
	HashMap<String, String> hmap = new HashMap<String, String>();
	Iterator<String> keySetIterator = hmap.keySet().iterator(); 
	
	        InputStream ios = new FileInputStream(new File(fileName1));
	        // Parse the YAML file and return the output as a series of Maps and Lists
	        hmap = (HashMap<String, String>)yaml1.load(ios);
	        //while(keySetIterator.hasNext()){ 
			//	String key = keySetIterator.next(); 
	       // Map<String,Object> result = (Map<String,Object>)yaml1.load(ios);
	       // System.out.println(result.toString());
	        System.out.println(hmap.get(""));
	        System.out.println(hmap.toString());
	       // }
	        Yaml yaml2= new Yaml();
	       
	        YamlReader reader = new YamlReader(new FileReader(fileName2));
	        Object object = reader.read();
	       // System.out.println(object);
	        Map map = (Map)object;
	        System.out.println(map.get("address"));
	        System.out.println(map.get("phone numbers"));
	        
	        Yaml yaml3= new Yaml();
		       
	        YamlReader reader3 = new YamlReader(new FileReader(fileName3));
	        reader3.getConfig().setPropertyElementType(Contact.class, "phoneNumbers", PhoneNumbers.class);
	       // Contact contact = reader3.read(type);
	        		//read(Contact.class,PhoneNumbers.class);
	        //PhoneNumbers phone = contact.g
	        //Object object3 = reader3.read();
	       // System.out.println(object);
	       // System.out.println(contact.phoneNumbers.size());
	       // System.out.println(contact.phoneNumbers..number);



	}
	

}
