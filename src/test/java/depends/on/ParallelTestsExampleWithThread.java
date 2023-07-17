package depends.on;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTestsExampleWithThread extends HelperClass {

	@Test
	public void invalidLoginTest() {

		System.out.println("Test Case 1 with Thread Id - " + Thread.currentThread().getId());

		getDriver().findElement(By.name("user-name")).sendKeys("1234");
		getDriver().findElement(By.name("password")).sendKeys("secret_sauce");
		getDriver().findElement(By.xpath("//*[@name='login-button']")).submit();
		String actualErrorMessage = getDriver()
				.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
		System.out.println("Actual ErrorMessage :" + actualErrorMessage);
		assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");

	}

	@Test
	public void blankLoginTest() {

		System.out.println("Test Case 2 with Thread Id - " + Thread.currentThread().getId());

		getDriver().findElement(By.name("user-name")).sendKeys("");
		getDriver().findElement(By.name("password")).sendKeys("");
		getDriver().findElement(By.xpath("//*[@name='login-button']")).submit();
		String actualErrorMessage = getDriver()
				.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
		System.out.println("Actual ErrorMessage :" + actualErrorMessage);
		assertEquals(actualErrorMessage, "Epic sadface: Username is required");

	}

	@Test
	public void validLoginTest() throws InterruptedException {

		System.out.println("Test Case 3 with Thread Id - " + Thread.currentThread().getId());

		getDriver().findElement(By.name("user-name")).sendKeys("standard_user");
		getDriver().findElement(By.name("password")).sendKeys("secret_sauce");
		getDriver().findElement(By.xpath("//*[@name='login-button']")).submit();
		Thread.sleep(5000);
		String newPageText = getDriver().findElement(By.xpath("//*[@class ='title']")).getText();
		System.out.println("newPageText :" + newPageText);
		Assert.assertEquals(newPageText, "Products");
	}
}
