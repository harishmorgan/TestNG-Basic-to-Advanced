package depends.on;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    
    @BeforeMethod
    public void setDriver()  {
         
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().get("https://www.saucedemo.com");
        driver.get().manage().window().maximize();
         System.out.println("Before method Thread Id:" + Thread.currentThread().getId());         
      
    }


    public WebDriver getDriver() {
        return driver.get();
    }


    @AfterMethod
    public  void closeBrowser() {
        System.out.println("After method Thread Id:" + Thread.currentThread().getId());
        driver.get().quit();
        driver.remove();          
    }
}


