package testng.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;

public class HardAssertionDemo {

	@Test
	public void AssertionFailure() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://duckduckgo.com/");
		String actualTitle = "DuckDuckGo — Privacy, simplified";

		String expectedTitle = driver.getTitle();
		String expectedText = driver.findElement(By.xpath("//*[@class = 'legacyhomepage_searchSection__vZPtW']//h1"))
				.getText();

		/* Hard Assert */
		System.out.println("Verify Title");
		Assert.assertEquals(expectedTitle, actualTitle, "Incorrect page title");

		System.out.println("Verify Text");
		Assert.assertEquals("Privacy Protection For Any Device", expectedText);

		driver.quit();
	}

	@Test
	public void print() {
		System.out.println("Hard Assertion is displayed");
	}
}
