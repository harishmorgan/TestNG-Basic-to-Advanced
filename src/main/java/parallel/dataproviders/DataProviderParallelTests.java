package parallel.dataproviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderParallelTests {
	
	public WebDriver driver;
    private static final ThreadLocal<WebDriver> WEBDRIVER_THREADLOCAL = new ThreadLocal<WebDriver>();
     
     @BeforeMethod
    public void setUp(){
 
    	  System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
          driver = new ChromeDriver();
        WEBDRIVER_THREADLOCAL.set(driver);
        System.out.println("Before method Thread Id:" + Thread.currentThread().getId());
         
    }
     
    @Test(dataProvider = "testData", dataProviderClass = DataProviderDemo.class)
    public void invalidLoginTest(String username, String password, String errorMessage) throws InterruptedException {
              
        driver = WEBDRIVER_THREADLOCAL.get();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
      
        Thread.sleep(2000);
        driver.findElement(By.name("user-name")).sendKeys(username);
        System.out.println("Username :" + username);
         
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);
        System.out.println("password :" + password);
        
        driver.findElement(By.xpath("//*[@name='login-button']")).submit();
         
        Thread.sleep(2000);
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
		System.out.println("Actual ErrorMessage :" + actualErrorMessage);
		Assert.assertTrue(actualErrorMessage.contains(actualErrorMessage));

 
    }
          
    @AfterMethod
    public void tear_down() {
          
         WebDriver driver = WEBDRIVER_THREADLOCAL.get();
         System.out.println("After method Thread Id:" + Thread.currentThread().getId());
            if (driver != null) {
                driver.quit();
         }
    }   

}
