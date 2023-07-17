package testng.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class SoftAssertionDemo {
	
	@Test
	 public void assertionFailure() {

	SoftAssert softAssertion = new SoftAssert();

	 WebDriverManager.chromedriver().setup();

	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://duckduckgo.com/");

	String actualTitle = "DuckDuckGo — Privacy, simplified";

	 String expectedTitle = driver.getTitle();
	String expectedText1 = driver.findElement(By.xpath("//*[@class = 'legacyhomepage_searchSection__vZPtW']//h1")).getText();

	 /* Soft Assert */
	System.out.println("Verify Title");
	 softAssertion.assertEquals(expectedTitle, actualTitle, "Incorrect page title");

	 System.out.println("Verify Text");
	softAssertion.assertEquals("Privacy Protection For Any Device", expectedText1);

	 driver.quit();
	 }

	 @Test
	 public void print() {
	 System.out.println("Soft Assertion is displayed");
	 }

}
