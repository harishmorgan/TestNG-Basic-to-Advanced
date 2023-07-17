package testng.features;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParameterizationDemo {

	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void parameterizedTest(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {

			driver = WebDriverManager.firefoxdriver().create();
			System.out.println("Browser Started :" + browser);

		} else if (browser.equalsIgnoreCase("chrome")) {

			driver = WebDriverManager.chromedriver().create();
			System.out.println("Browser Started :" + browser);
		}

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void validCredentials() {

		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@name='login-button']")).submit();

		String newPageText = driver.findElement(By.xpath("//*[@class ='title']")).getText();
		System.out.println("newPageText :" + newPageText);
		Assert.assertEquals(newPageText, "Products");
	}

	@Test
	public void invalidCredentials() {

		driver.findElement(By.name("user-name")).sendKeys("1234");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@name='login-button']")).submit();
		String actualErrorMessage = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
		System.out.println("Actual ErrorMessage :" + actualErrorMessage);
		assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
