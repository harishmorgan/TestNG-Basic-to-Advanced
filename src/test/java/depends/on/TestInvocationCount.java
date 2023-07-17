package depends.on;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestInvocationCount {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {

		driver = WebDriverManager.chromedriver().create();

	}

	@Test(invocationCount = 3)
	public void verifyLinkedIn() {

		System.out.println("Test Case 1 with Thread Id - " + Thread.currentThread().getId());

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(invocationCount = 2)
	public void validLoginTest() throws InterruptedException {

		System.out.println("Test Case 2 with Thread Id - " + Thread.currentThread().getId());

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

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
	public void closeBrowser() {

		driver.quit();

	}

}
