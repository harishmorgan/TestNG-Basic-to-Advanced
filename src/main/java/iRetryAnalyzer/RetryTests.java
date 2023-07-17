package iRetryAnalyzer;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RetryTests {
	
	WebDriver driver;
    
    @BeforeTest
    public void setUp() {
          
         WebDriverManager.chromedriver().setup();
          
         ChromeOptions chromeOptions = new ChromeOptions();
   
         driver = new ChromeDriver(chromeOptions);
         driver.get("https://practicetestautomation.com/practice-test-login/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
  
    @Test(description = "This test validates title of login functionality")
    public void verifyLoginPage() {
  
    	String expectedTitle = driver.findElement(By.xpath("//*[@id='login']/h2")).getText();
    	  
        System.out.println("Title :" + expectedTitle);
        Assert.assertTrue(expectedTitle.equalsIgnoreCase("Test login"));
    }
  
    @Test(description = "This test validates  successful login to Home page")
    public void verifyHomePage() {
  
    	System.out.println("Username Entered");
        driver.findElement(By.name("username")).sendKeys("student");
  
        System.out.println("Password Entered");
        driver.findElement(By.name("password")).sendKeys("Password123");
  
        driver.findElement(By.id("submit")).submit();
  
        String newPageText = driver.findElement(By.className("post-title")).getText();
        System.out.println("newPageText :" + newPageText);
        Assert.assertTrue(newPageText.contains("Logged In Successfully"));
    }
  
    @AfterTest
    public void teardown() {
  
        driver.quit();
    }

}
