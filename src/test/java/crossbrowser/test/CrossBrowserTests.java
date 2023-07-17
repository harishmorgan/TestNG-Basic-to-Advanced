package crossbrowser.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrossBrowserTests extends BaseClass {
	
	@Test
    public void invalidLoginTest() throws InterruptedException {
         
        System.out.println("Test Case1");
                
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
 
        System.out.println("Test Case2");
         
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Boolean linkedInIcon = driver.findElement(By.xpath("//img[@class='custom-logo']")).isEnabled();
        System.out.println("Actual linkedIn Text :" + linkedInIcon);
        assertTrue(linkedInIcon);
    }
 
     
    @Test
    public void validLoginTest() throws InterruptedException {
         
        System.out.println("Test Case3");
 
        driver.manage().window().maximize();    
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@name='login-button']")).submit();
		String newPageText = driver.findElement(By.xpath("//*[@class ='title']")).getText();
		System.out.println("newPageText :" + newPageText);
		Assert.assertEquals(newPageText, "Products");
    }

}
