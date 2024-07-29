package frameWork.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class FrameWorkBase {

	 public static WebDriver driver;
	 public static Properties FrameWorkProp;
	 
	 public FrameWorkBase() {//Constructor should not have a void just a class name
			// these are 3 things we need parent or base class
			//Constructor ( Constructor is special kind of method who initialize the value) //Constructor name should be as a class name
	
		 try {
			FileInputStream FrameWorkBaseFile = new FileInputStream (System.getProperty("user.dir")+"\\src\\test\\java\\frameWork\\config\\FrameWorkConfig.properties"); //create object
			 FrameWorkProp = new Properties();
			 FrameWorkProp.load(FrameWorkBaseFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		 
	 }
	//BrowserSetup
	 
	 public void FrameWorkBrowserSetup() {
		  
		 String FrameWorkAllBrowser = FrameWorkProp.getProperty("FrameWorkBrowser1");
			
			if(FrameWorkAllBrowser.equals("Chrome")) {
			
				System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"\\frameWorkDriver\\chromedriver.exe");
				
				ChromeOptions eb = new ChromeOptions();
				eb.addArguments("--remote-allow-origins=*");
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameWorkUtility.implicitlyWait)); //not took time to open URL 
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameWorkUtility.pageLoadTimeout)); //took time to open URL
				driver.manage().deleteAllCookies();
			}
				else if(FrameWorkAllBrowser.equals("IE"))
				{
					
				}
		 }
	//LunchURLSetup
	 public static void FrameWorkURLSetup (String URL){ //parameter korbo tai string lagbey, this method is responsible for launching url
		
		driver.get(FrameWorkProp.getProperty("FrameWorkURL")); // url is opening from here
		 //driver.get("https://askomdch.com/ ");
		 
	 }

}

