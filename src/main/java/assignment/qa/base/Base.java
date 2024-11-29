package assignment.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		
		//.\\src\\main\\java\\assignment\\qa\\config.properties
	
		try {
		prop = new Properties();
		FileInputStream ca = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Assignment_Automation\\src\\test\\resources\\config.properties");
		prop.load(ca);
		} 
		catch (FileNotFoundException e) {
			  e.printStackTrace();
		}
		catch (IOException e) {
			  e.printStackTrace();
		}
	}			
		
		public static void initialization() {
						
			if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
			{
			 WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		   }
			
			else if(prop.getProperty("Browser").equalsIgnoreCase("firefox"))
		   {
			   WebDriverManager.firefoxdriver().setup();
				  driver = new FirefoxDriver();  
		   }
			
			else if(prop.getProperty("Browser").equalsIgnoreCase("edge"))
			   {
				   WebDriverManager.edgedriver().setup();
					  driver = new EdgeDriver();  
			   }
			
			else if(prop.getProperty("Browser").equalsIgnoreCase("ie"))
			   {
				   WebDriverManager.iedriver().setup();
					  driver = new InternetExplorerDriver();  
			   }
			
			else {
				
				System.out.println("Browser details not found");
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("Url") );
			  
			
		   }
		
		
		
		
		
		
	}
	
	
