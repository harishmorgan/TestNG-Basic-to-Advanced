package testng.features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGRunFromCommandLine {
	
	WebDriver driver;

	@BeforeMethod
	 public void setUp() {

	System.setProperty("webdriver.chrome.driver", "E:\\New folder\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.saucedemo.com/");
	 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	 }

	 @Test(description = "This test validates title of login functionality", priority = 0)
	 public void verifyLoginPage() {
	 driver.getTitle();
	 }

	 @Test(description = "This test validates successful login to Home page", priority = 1)
	 public void verifyHomePage() {

	 System.out.println("Username Entered");
	 driver.findElement(By.name("user-name")).sendKeys("standard_user");

	 System.out.println("Password Entered");
	 driver.findElement(By.name("password")).sendKeys("secret_sauce");

	 driver.findElement(By.xpath("//*[@name='login-button']")).submit();

	 String newPageText = driver.findElement(By.xpath("//*[@class ='title']")).getText();
	 System.out.println("newPageText :" + newPageText);
	 Assert.assertEquals(newPageText, "Products");
	 }

	 @AfterMethod
	 public void teardown() {

	 driver.quit();
	 }

}
