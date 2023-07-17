package crossbrowser.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
 
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {

	 WebDriver driver;
     
	    @BeforeMethod
	    @Parameters("browser")
	    public void setup(String browser) throws Exception {
	 
	       if (browser.equalsIgnoreCase("firefox")) {
	           
	            driver = WebDriverManager.firefoxdriver().create();
	            System.out.println("Browser Started:" + browser);
	        
	       } else if (browser.equalsIgnoreCase("chrome")) {
	             
	             driver = WebDriverManager.chromedriver().create();
	             System.out.println("Browser Started:" + browser);
	       } else if (browser.equalsIgnoreCase("edge")) {
	             
	             driver = WebDriverManager.edgedriver().create();
	             System.out.println("Browser Started:" + browser);
	       } else {               
	                 throw new Exception("Browser is not correct");
	        }
	        
	       driver.get("https://www.saucedemo.com/");
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       driver.manage().window().maximize();
	    }
	     
	 
	        @AfterMethod
	        public  void closeBrowser() {
	             
	            driver.quit();
	             
	               
	        }
}
