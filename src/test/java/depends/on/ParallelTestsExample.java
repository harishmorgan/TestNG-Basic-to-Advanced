package depends.on;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestsExample {
	
	 @Test
	    public void invalidLoginTest() throws InterruptedException {
	        System.out.println("Test Case 1 with Thread Id - "+Thread.currentThread().getId());
	 
	        WebDriver driver = WebDriverManager.chromedriver().create();  
	        driver.manage().window().maximize();
	        driver.get("https://www.saucedemo.com/");
	        driver.findElement(By.name("user-name")).sendKeys("1234");
			driver.findElement(By.name("password")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//*[@name='login-button']")).submit();
			String actualErrorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
			System.out.println("Actual ErrorMessage :" + actualErrorMessage);
			assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");

	 
	    }
	 
	    @Test
	    public void verifyLinkedIn() {
	 
	        System.out.println("Test Case 2 with Thread Id - "+Thread.currentThread().getId());
	         
	        WebDriver driver = WebDriverManager.chromedriver().create();    
	        driver.manage().window().maximize();
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	        Boolean linkedInIcon = driver.findElement(By.xpath("//img[@class='custom-logo']")).isEnabled();
	        System.out.println("Actual linkedIn Text :" + linkedInIcon);
	        assertTrue(linkedInIcon);
	    }
	 
	    @Test
	    public void validLoginTest() throws InterruptedException {
	 
	        System.out.println("Test Case 3 with Thread Id - "+Thread.currentThread().getId());
	 
	        WebDriver driver = WebDriverManager.chromedriver().create();  
	        driver.manage().window().maximize();    
	        driver.get("https://www.saucedemo.com/");
	        driver.findElement(By.name("user-name")).sendKeys("standard_user");
			driver.findElement(By.name("password")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//*[@name='login-button']")).submit();
			String newPageText = driver.findElement(By.xpath("//*[@class ='title']")).getText();
			System.out.println("newPageText :" + newPageText);
			Assert.assertEquals(newPageText, "Products");
	    }
	 
	    @Test
	    public void forgotLinkTest() throws InterruptedException {
	 
	        System.out.println("Test Case 4 with Thread Id - "+Thread.currentThread().getId());
	 
	        WebDriver driver = WebDriverManager.chromedriver().create();      
	        driver.manage().window().maximize();    
	        driver.get("https://www.browserstack.com/users/sign_in");
	        String expectedLink = driver.findElement(By.xpath("//a[@class='forgot-password-link']")).getText();
	        Assert.assertTrue(expectedLink.contains("Forgot password?"));
	    }

}
