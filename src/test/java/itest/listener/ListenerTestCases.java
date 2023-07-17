package itest.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(itest.listener.ListenerDemo.class)
public class ListenerTestCases {

	static WebDriver driver;

	@Test
	public void TestPass() {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@name='login-button']")).submit();
		String newPageText = driver.findElement(By.xpath("//*[@class ='title']")).getText();
		System.out.println("newPageText :" + newPageText);
		Assert.assertEquals(newPageText, "Products");
		driver.quit();
	}

	@Test
	public void TestFail() {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@name='login-button']")).submit();
		String newPageText = driver.findElement(By.xpath("//*[@class ='title']")).getText();
		System.out.println("newPageText :" + newPageText);
		Assert.assertEquals(newPageText, "Product");
		driver.quit();
	}

}
